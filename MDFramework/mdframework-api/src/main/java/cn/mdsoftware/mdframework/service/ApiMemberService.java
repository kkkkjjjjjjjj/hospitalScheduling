package cn.mdsoftware.mdframework.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.mdsoftware.mdframework.bean.api.*;
import cn.mdsoftware.mdframework.bean.entity.member.MemberDO;
import cn.mdsoftware.mdframework.bean.entity.member.PhotoDO;
import cn.mdsoftware.mdframework.common.Constants;
import cn.mdsoftware.mdframework.common.enums.HttpResponseEnum;
import cn.mdsoftware.mdframework.common.utils.Base64Utils;
import cn.mdsoftware.mdframework.common.utils.FastDFSClientWrapper;
import cn.mdsoftware.mdframework.common.utils.MD5Utils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cn.mdsoftware.mdframework.bean.api.ChangePasswordReq;
import cn.mdsoftware.mdframework.bean.api.HttpResponse;
import cn.mdsoftware.mdframework.bean.api.LogoutReq;
import cn.mdsoftware.mdframework.bean.api.MemberEditReq;
import cn.mdsoftware.mdframework.bean.api.MemberEditResp;
import cn.mdsoftware.mdframework.bean.entity.member.MemberDO;
import cn.mdsoftware.mdframework.bean.entity.member.PhotoDO;
import cn.mdsoftware.mdframework.common.Constants;
import cn.mdsoftware.mdframework.common.enums.HttpResponseEnum;
import cn.mdsoftware.mdframework.common.utils.Base64Utils;
import cn.mdsoftware.mdframework.common.utils.FastDFSClientWrapper;
import cn.mdsoftware.mdframework.common.utils.MD5Utils;
import cn.mdsoftware.mdframework.dao.member.MemberMapper;
import cn.mdsoftware.mdframework.dao.member.PhotoMapper;

@Service
public class ApiMemberService {
	
	private final Logger log = LoggerFactory.getLogger(ApiMemberService.class);
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private PhotoMapper photoMapper;
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private FastDFSClientWrapper dfsClient;
	
	@Value("${fastdfs.ipAddrPort}")
	private String fastDFSIPPort;
	
	@Transactional(rollbackFor = Exception.class)
	public void updatePassword(ChangePasswordReq req, HttpResponse<String> resp) {
		
		if (!authService.isLogin(req.getPhone(), req.getToken(), resp)) {
			return;
		}
		
		if (StringUtils.isBlank(req.getPassword())) {
			log.error("密码不能为空！");
			resp.setHttpResponseEnum(HttpResponseEnum.PARAM_REQUIRED_PASSWORD);
			return;
		}
		if (StringUtils.isBlank(req.getCaptcha())) {
			log.error("验证码不能为空！");
			resp.setHttpResponseEnum(HttpResponseEnum.CAPTCHA_ERROR);
			return;
		}
		
		String key = Constants.RedisKey.APP_CAPTCHA.concat(req.getPhone());
		String capthca = (String) redisTemplate.opsForValue().get(key);
		log.info("系统验证码：{}，请求的验证码：{}", capthca, req.getCaptcha());
		if (!req.getCaptcha().equals(capthca)) {
			log.error("验证码错误！");
			resp.setHttpResponseEnum(HttpResponseEnum.CAPTCHA_ERROR);
			return;
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("phone", req.getPhone());
		List<MemberDO> list = memberMapper.list(map);
		if (CollectionUtils.isEmpty(list)) {
			log.error("查无此手机号：{}", req.getPhone());
			resp.setHttpResponseEnum(HttpResponseEnum.NOT_FOND_PHONE);
			return;
		}
		
		MemberDO member = new MemberDO();
		member.setId(list.get(0).getId());
		member.setPassword(MD5Utils.encrypt(Base64Utils.decode(req.getPassword())));
		memberMapper.update(member);
	}

	/**
	 * 退出登录
	 * @param req
	 * @param resp
	 */
	public void logout(LogoutReq req, HttpResponse<String> resp) {
		if (!authService.isLogin(req.getPhone(), req.getToken(), resp)) {
			return;
		}
		String key = Constants.RedisKey.APP_SESSION.concat(req.getPhone());
		
		redisTemplate.delete(key);
	}

	/**
	 * 会员编辑
	 * @param req
	 * @param fileMap
	 * @param resp
	 */
	@Transactional(rollbackFor = Exception.class)
	public void edit(MemberEditReq req, Map<String, MultipartFile> fileMap, HttpResponse<MemberEditResp> resp) {
		
		MemberEditResp data = new MemberEditResp();
		
		log.info("请求参数：{}", req.toString());
		if (!authService.isLogin(req.getPhone(), req.getToken(), resp)) {
			return;
		}
		Map<String, Object> map = new HashMap<>();
		map.put("phone", req.getPhone());
		List<MemberDO> members = memberMapper.list(map);
		if (CollectionUtils.isEmpty(members)) {
			log.error("查无此会员，当前手机号：{}", req.getPhone());
			resp.setHttpResponseEnum(HttpResponseEnum.NOT_FOND_PHONE);
			return;
		}
		
		MemberDO member = new MemberDO();
		member.setId(members.get(0).getId());
		if (StringUtils.isNotBlank(req.getNickname())) {
			member.setName(req.getNickname());
			memberMapper.update(member);
			data.setNickname(req.getNickname());
		}
		
		if (fileMap != null) {
			try {
				for (Map.Entry<String, MultipartFile> entry : fileMap.entrySet()) {
					if (entry == null) {
						log.warn("文件entity为空");
						break;
					}
					MultipartFile file = entry.getValue();
					
					if (file == null) {
						log.warn("文件file为空");
						break;
					}
					
					String key = entry.getKey();
					
					log.info(key + ":fileName == >" + file.getOriginalFilename());
					
					if (!"headerFile".equals(key)) {
						log.error("上传文件key不对，请检查，当前文件key为：{}", key);
						resp.setHttpResponseEnum(HttpResponseEnum.FILE_PARAM_NAME_ERROR);
						return;
					}
					String url = dfsClient.uploadFile(entry.getValue());
					Map<String, Object> photoMap = new HashMap<>();
					photoMap.put("memberId", member.getId());
					photoMap.put("isHead", 1);
					List<PhotoDO> photoList = photoMapper.list(photoMap);
					PhotoDO photo = new PhotoDO();
					if (CollectionUtils.isNotEmpty(photoList)) {// 更新
						photo.setId(photoList.get(0).getId());
						photo.setPhotoUrl(url);
						photoMapper.update(photo);
						
						log.info("old file path:" + photoList.get(0).getPhotoUrl());
						dfsClient.deleteFile(photoList.get(0).getPhotoUrl());
						
					} else {// 新增
						photo.setCreateTime(new Date());
						photo.setIsHead(1);
						photo.setIsShow(1);
						photo.setMemberId(member.getId());
						photo.setPhotoUrl(url);
						photoMapper.save(photo);
					}
					data.setHeaderUrl(fastDFSIPPort + url);
				}
			} catch (Exception e) {
				log.error("上传fastDFS出错！error:", e);
				resp.setHttpResponseEnum(HttpResponseEnum.SYSTEM_ERROR);
				return;
			}
		}
		
		resp.setData(data);
	}
}

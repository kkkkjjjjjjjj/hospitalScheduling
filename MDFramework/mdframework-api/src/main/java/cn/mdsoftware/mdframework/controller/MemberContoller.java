package cn.mdsoftware.mdframework.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.mdsoftware.mdframework.bean.api.*;
import cn.mdsoftware.mdframework.common.utils.FastDFSClientWrapper;
import cn.mdsoftware.mdframework.service.ApiMemberService;
import cn.mdsoftware.mdframework.service.ApiMemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.github.tobato.fastdfs.service.FastFileStorageClient;
import cn.mdsoftware.mdframework.bean.api.ChangePasswordReq;
import cn.mdsoftware.mdframework.bean.api.HttpResponse;
import cn.mdsoftware.mdframework.bean.api.LogoutReq;
import cn.mdsoftware.mdframework.bean.api.MemberEditReq;
import cn.mdsoftware.mdframework.bean.api.MemberEditResp;
import cn.mdsoftware.mdframework.common.utils.FastDFSClientWrapper;
import cn.mdsoftware.mdframework.service.ApiMemberService;

@RestController
@RequestMapping("/member")
public class MemberContoller {
	
	private final Logger log = LoggerFactory.getLogger(MemberContoller.class);
	
	@Autowired
	private ApiMemberService apiMemberService;
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public HttpResponse<String> changePassword(@RequestBody ChangePasswordReq req) {
		HttpResponse<String> resp = new HttpResponse<>();
		apiMemberService.updatePassword(req, resp);
		log.info("/member/changePassword 接口返回：{}", resp.toString());
		return resp;
	}
	
	@RequestMapping(value = "/setPassword", method = RequestMethod.POST)
	public HttpResponse<String> setPassword(@RequestBody ChangePasswordReq req) {
		HttpResponse<String> resp = new HttpResponse<>();
		apiMemberService.updatePassword(req, resp);
		log.info("/member/setPassword 接口返回：{}", resp.toString());
		return resp;
	}
	

	/**
	 * 退出登录
	 * @param phone
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public HttpResponse<String> logout(@RequestBody LogoutReq req) {
		HttpResponse<String> resp = new HttpResponse<>();
		apiMemberService.logout(req, resp);
		log.info("/member/logout 接口返回：{}", resp.toString());
		return resp;
	}
	
	/**
	 * 会员信息编辑
	 * @param phone
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public HttpResponse<MemberEditResp> edit(MemberEditReq req, HttpServletRequest request) {
		HttpResponse<MemberEditResp> resp = new HttpResponse<>();
		MultipartHttpServletRequest multipartReq = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartReq.getFileMap();
		apiMemberService.edit(req, fileMap, resp);
		log.info("/member/edit 接口返回：{}", resp.toString());
		return resp;
	}
	
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public HttpResponse<String> upload(LogoutReq logout, HttpServletRequest request) throws IOException {
		HttpResponse<String> resp = new HttpResponse<>();
		
		System.out.println(logout.getPhone());
		System.out.println(logout.getToken());
		
		MultipartHttpServletRequest multipartReq = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartReq.getFileMap();
		fileMap.forEach((k,v) -> outPut(k,v));
		
		log.info("/member/upload 接口返回：{}", resp.toString());
		return resp;
	}
	
	@Autowired
    private FastFileStorageClient storageClient;
	@Autowired
	private FastDFSClientWrapper dfsClient;
	
	private void outPut(String k, MultipartFile file) {
		try {
			System.out.println(k + ":fileName == >" + file.getOriginalFilename());
//			String url = dfsClient.uploadFile(file);
//			System.out.println(url);
//			StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
//			System.out.println(storePath.getFullPath());
//			System.out.println(storePath.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

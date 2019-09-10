package cn.mdsoftware.mdframework.controller.bannerInfo;

import cn.mdsoftware.mdframework.bean.api.HttpResponse;
import cn.mdsoftware.mdframework.bean.entity.bannerInfo.BannerInfoDO;
import cn.mdsoftware.mdframework.common.annotation.JSON;
import cn.mdsoftware.mdframework.common.utils.PageUtils;
import cn.mdsoftware.mdframework.common.utils.Query;
import cn.mdsoftware.mdframework.service.bannerInfo.BannerInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


/**
 * 
 * 
 * @author 110
 * @email 110@163.com
 * @date 2018-02-07 12:10:13
 */
@Controller
@RequestMapping("/banner")
public class BannerInfoController {
	@Autowired
	private BannerInfoService bannerInfoService;
	
	@GetMapping()
	@RequiresPermissions("bannerInfo:bannerInfo")
	String BannerInfo(){
	    return "bannerInfo/bannerInfo";
	}
	
	@GetMapping("/list")
	@JSON(type=BannerInfoDO.class,include = "id,title,linkUrl,mainPic")
	public Object list(@RequestParam Map<String, Object> params){
		//查询列表数据
		HttpResponse<PageUtils> resp = new HttpResponse<>();
        Query query = new Query(params);
		query.put("status",1);
		query.put("sort","order_By");
		query.put("order","asc");

		List<BannerInfoDO> bannerInfoList = bannerInfoService.list(query);
		int total = bannerInfoService.count(query);
		PageUtils pageUtils = new PageUtils(bannerInfoList, total);
		resp.setData(pageUtils);
		return resp;
	}

	@ResponseBody
	@RequestMapping("/test")
	public HttpResponse test(){
		HttpResponse resp = new HttpResponse<>();
		BannerInfoDO bannerInfoDO = new BannerInfoDO();
		resp.setData(bannerInfoDO);
		return resp;
	}


}

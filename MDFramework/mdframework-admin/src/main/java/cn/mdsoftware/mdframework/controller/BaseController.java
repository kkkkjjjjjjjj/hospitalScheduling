package cn.mdsoftware.mdframework.controller;

import org.springframework.stereotype.Controller;

import cn.mdsoftware.mdframework.bean.entity.system.SysUserDO;
import cn.mdsoftware.mdframework.common.utils.ShiroUtils;

@Controller
public class BaseController {
	public SysUserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}
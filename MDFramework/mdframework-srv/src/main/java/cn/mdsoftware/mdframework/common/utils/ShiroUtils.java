package cn.mdsoftware.mdframework.common.utils;

import cn.mdsoftware.mdframework.bean.entity.system.SysUserDO;
import cn.mdsoftware.mdframework.bean.entity.system.SysUserDO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import cn.mdsoftware.mdframework.bean.entity.system.SysUserDO;

public class ShiroUtils {
	public static Subject getSubjct() {
		return SecurityUtils.getSubject();
	}
	public static SysUserDO getUser() {
		return (SysUserDO)getSubjct().getPrincipal();
	}
	public static Long getUserId() {
		return getUser().getUserId();
	}
	public static void logout() {
		getSubjct().logout();
	}
}

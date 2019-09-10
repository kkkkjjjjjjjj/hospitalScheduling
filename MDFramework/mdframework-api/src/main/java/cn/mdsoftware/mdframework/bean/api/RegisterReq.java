package cn.mdsoftware.mdframework.bean.api;

import java.io.Serializable;

/**
 * 注册&忘记密码请求参数
 * @author Jax
 *
 */
public class RegisterReq implements Serializable {

	private static final long serialVersionUID = -8131637238584253360L;

	private String phone;
	
	private String password;
	
	private String captcha;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	@Override
	public String toString() {
		return "RegisterReq [phone=" + phone + ", password=" + password + ", captcha=" + captcha + "]";
	}
}

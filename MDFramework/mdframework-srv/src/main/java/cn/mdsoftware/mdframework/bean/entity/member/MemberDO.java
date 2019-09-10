package cn.mdsoftware.mdframework.bean.entity.member;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author 110
 * @email 110@163.com
 * @date 2017-09-20 11:01:06
 */
public class MemberDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String name;
	//
	private String realName;
	//
	private Integer sex;
	//
	private String address;
	//
	private Integer age;
	//
	private String constellation;
	//
	private Integer emotion;
	//
	private String profession;
	//
	private String loginName;
	//
	private String password;
	//
	private String email;
	//
	private String phone;
	//
	private Date createTime;
	//
	private Integer status;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}
	/**
	 * 获取：
	 */
	public String getRealName() {
		return realName;
	}
	/**
	 * 设置：
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * 获取：
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * 设置：
	 */
	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}
	/**
	 * 获取：
	 */
	public String getConstellation() {
		return constellation;
	}
	/**
	 * 设置：
	 */
	public void setEmotion(Integer emotion) {
		this.emotion = emotion;
	}
	/**
	 * 获取：
	 */
	public Integer getEmotion() {
		return emotion;
	}
	/**
	 * 设置：
	 */
	public void setProfession(String profession) {
		this.profession = profession;
	}
	/**
	 * 获取：
	 */
	public String getProfession() {
		return profession;
	}
	/**
	 * 设置：
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	/**
	 * 获取：
	 */
	public String getLoginName() {
		return loginName;
	}
	/**
	 * 设置：
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：
	 */
	public Integer getStatus() {
		return status;
	}
}

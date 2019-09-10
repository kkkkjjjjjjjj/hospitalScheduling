package cn.mdsoftware.mdframework.bean.entity.baseInfo;

import java.io.Serializable;


/**
 * 
 * 
 * @author 110
 * @email 110@163.com
 * @date 2018-02-08 17:57:16
 */
public class BaseInfoDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//公司名称
	private String name;
	//logo
	private String mainPic;
	//客服电话
	private String phone;
	//qq号码
	private String qqNumber;
	//关于我们
	private String aboutUs;
	//删除状态
	private Integer delStatus;
	private String commonPassword;


	public String getCommonPassword() {
		return commonPassword;
	}

	public void setCommonPassword(String commonPassword) {
		this.commonPassword = commonPassword;
	}






	/**
	 * 设置：id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：公司名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：公司名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：logo
	 */
	public void setMainPic(String mainPic) {
		this.mainPic = mainPic;
	}
	/**
	 * 获取：logo
	 */
	public String getMainPic() {
		return mainPic;
	}
	/**
	 * 设置：客服电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：客服电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：qq号码
	 */
	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber;
	}
	/**
	 * 获取：qq号码
	 */
	public String getQqNumber() {
		return qqNumber;
	}
	/**
	 * 设置：关于我们
	 */
	public void setAboutUs(String aboutUs) {
		this.aboutUs = aboutUs;
	}
	/**
	 * 获取：关于我们
	 */
	public String getAboutUs() {
		return aboutUs;
	}
	/**
	 * 设置：删除状态
	 */
	public void setDelStatus(Integer delStatus) {
		this.delStatus = delStatus;
	}
	/**
	 * 获取：删除状态
	 */
	public Integer getDelStatus() {
		return delStatus;
	}
}

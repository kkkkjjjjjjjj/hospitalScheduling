package cn.mdsoftware.mdframework.bean.entity.member;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author 110
 * @email 110@163.com
 * @date 2017-10-15 22:58:22
 */
public class PhotoDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Integer memberId;
	//
	private String photoUrl;
	//
	private Integer isHead;
	//
	private Integer isShow;
	//
	private Date createTime;

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
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取：
	 */
	public Integer getMemberId() {
		return memberId;
	}
	/**
	 * 设置：
	 */
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	/**
	 * 获取：
	 */
	public String getPhotoUrl() {
		return photoUrl;
	}
	/**
	 * 设置：
	 */
	public void setIsHead(Integer isHead) {
		this.isHead = isHead;
	}
	/**
	 * 获取：
	 */
	public Integer getIsHead() {
		return isHead;
	}
	/**
	 * 设置：
	 */
	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}
	/**
	 * 获取：
	 */
	public Integer getIsShow() {
		return isShow;
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
}

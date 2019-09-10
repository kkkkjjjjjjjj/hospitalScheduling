package cn.mdsoftware.mdframework.bean.entity.member;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author 110
 * @email 110@163.com
 * @date 2017-10-19 00:35:55
 */
public class ShareDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String name;
	//
	private String description;
	//
	private Integer memberId;
	//
	private Date createTime;
	//
	private String visitUrl;
	//
	private Integer productId;
	//
	private Integer newsId;

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
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：
	 */
	public String getDescription() {
		return description;
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
	public void setVisitUrl(String visitUrl) {
		this.visitUrl = visitUrl;
	}
	/**
	 * 获取：
	 */
	public String getVisitUrl() {
		return visitUrl;
	}
	/**
	 * 设置：
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	/**
	 * 获取：
	 */
	public Integer getProductId() {
		return productId;
	}
	/**
	 * 设置：
	 */
	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}
	/**
	 * 获取：
	 */
	public Integer getNewsId() {
		return newsId;
	}
}

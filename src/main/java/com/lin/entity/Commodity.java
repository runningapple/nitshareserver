package com.lin.entity;

import java.util.Date;

/*
id	bigint(20)	NO	PRI		auto_increment
pubDate	datetime	NO			
name	varchar(255)	NO			
price	decimal(10,0)	NO			
description	varchar(255)	YES			
imgUrl0	varchar(255)	NO			
imgUrl1	varchar(255)	YES	
imgUrl2	varchar(255)	YES					
*/
/**
* 
* @ClassName: Commodity 
* @Description: TODO
* @author linzj 
* @date 2016年4月3日 下午4:56:39 
*
*/
public class Commodity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5800521327031285119L;
	
	/*商品id*/
	private String id;
	
	/*发布时间*/
	private Date pubDate;
	
	/*商品名*/
	private String name;
	
	/*商品价格*/
	private Double price;
	
	/*商品展示图片0*/
	private String imgUrl0;
	
	/*商品展示图片1*/
	private String imgUrl1;
	
	/*商品展示图片2*/
	private String imgUrl2;
	
	/*商品描述*/
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl0() {
		return imgUrl0;
	}

	public void setImgUrl0(String imgUrl0) {
		this.imgUrl0 = imgUrl0;
	}

	public String getImgUrl1() {
		return imgUrl1;
	}

	public void setImgUrl1(String imgUrl1) {
		this.imgUrl1 = imgUrl1;
	}

	public String getImgUrl2() {
		return imgUrl2;
	}

	public void setImgUrl2(String imgUrl2) {
		this.imgUrl2 = imgUrl2;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Commodity [id=" + id + ", pubDate=" + pubDate + ", name="
				+ name + ", price=" + price + ", imgUrl0=" + imgUrl0
				+ ", imgUrl1=" + imgUrl1 + ", imgUrl2=" + imgUrl2
				+ ", description=" + description + "]";
	}
	
	
	
	
}

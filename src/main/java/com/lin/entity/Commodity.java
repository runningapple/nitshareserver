package com.lin.entity;

import java.util.Date;

/*
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pubDate` datetime NOT NULL COMMENT '商品发布日期',
  `cname` varchar(255) NOT NULL COMMENT '商品名',
  `price` decimal(10,2) NOT NULL COMMENT '商品价格',
  `description` varchar(255) DEFAULT NULL COMMENT '商品描述',
  `imgUrl0` varchar(255) NOT NULL COMMENT '图片地址',
  `imgUrl1` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `imgUrl2` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `uid` bigint(20) NOT NULL COMMENT '用户id',
  `tradePlace` varchar(100) NOT NULL COMMENT '交易地址',
  `type` int(20) NOT NULL COMMENT '商品类型',
  `qq` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `bargain` int(10) NOT NULL COMMENT '是否可以讲价',
  `state` int(10) NOT NULL COMMENT '商品状态',
  `click` bigint(255) NOT NULL DEFAULT '0' COMMENT '商品点击量',
  `mid` bigint(20) NOT NULL DEFAULT '0' COMMENT '商品消息id',	
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
	
	/*商品id*/
	private Integer id;
	
	/*商品拥有者id*/
	private Integer uid;
	
	/*发布时间*/
	private Date pubDate;
	
	/*商品名*/
	private String cname;
	
	/*商品价格*/
	private Double price;
	
	/*商品展示图片0*/
	private String imgUrl0;
	
	/*商品展示图片1*/
	private String imgUrl1="";
	
	/*商品展示图片2*/
	private String imgUrl2="";
	
	/*商品描述*/
	private String description="该用户太懒，还没有添加描述";
	
	/*交易地点*/
	private String tradePlace="";
	
	/*商品类型*/
	private Integer type=0;
	
	private String qq="";
	
	private String mobile="";
	
	/*是否可以讲价*/
	private Integer bargain;
	
	/*商品状态*/
	private Integer state;
	
	/*点击量*/
	private Integer click=0;
	
	/*消息id*/
	private Integer mid;
	
	public Commodity(){
		super();
	};
	
	public Commodity(Integer id, Integer uid, Date pubDate, String cname,
			Double price, String imgUrl0, String imgUrl1, String imgUrl2,
			String description, String tradePlace, Integer type, String qq,
			String mobile, Integer bargain, Integer state, Integer click, Integer mid) {
		super();
		this.id = id;
		this.uid = uid;
		this.pubDate = pubDate;
		this.cname = cname;
		this.price = price;
		this.imgUrl0 = imgUrl0;
		this.imgUrl1 = imgUrl1;
		this.imgUrl2 = imgUrl2;
		this.description = description;
		this.tradePlace = tradePlace;
		this.type = type;
		this.qq = qq;
		this.mobile = mobile;
		this.bargain = bargain;
		this.state = state;
		this.click = click;
		this.mid = mid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
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

	public String getTradePlace() {
		return tradePlace;
	}

	public void setTradePlace(String tradePlace) {
		this.tradePlace = tradePlace;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getBargain() {
		return bargain;
	}

	public void setBargain(Integer bargain) {
		this.bargain = bargain;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getClick() {
		return click;
	}

	public void setClick(Integer click) {
		this.click = click;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "Commodity [id=" + id + ", uid=" + uid + ", pubDate=" + pubDate
				+ ", cname=" + cname + ", price=" + price + ", imgUrl0="
				+ imgUrl0 + ", imgUrl1=" + imgUrl1 + ", imgUrl2=" + imgUrl2
				+ ", description=" + description + ", tradePlace=" + tradePlace
				+ ", type=" + type + ", qq=" + qq + ", mobile=" + mobile
				+ ", bargain=" + bargain + ", state=" + state + ", click="
				+ click + ", mid=" + mid + "]";
	}

	
}

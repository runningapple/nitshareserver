package com.lin.entity;


/*
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `account` varchar(60) NOT NULL,
  `pwd` varchar(60) NOT NULL,
  `mobile` varchar(60) DEFAULT NULL,
  `mail` varchar(60) DEFAULT NULL,
  `qq` varchar(60) DEFAULT NULL,
  `nickname` varchar(60) NOT NULL,
  `headimg` varchar(60) DEFAULT NULL,
  `score` bigint(255) unsigned zerofill NOT NULL,
  `rank` int(255) NOT NULL,
 */
/**
 * 
 * <p>ClassName: User.java<p>
 * <p>Description<p>
 * @author linzj
 * @createTime 2016年4月1日  下午3:38:31
 */
public class User {

	private Integer id;
	
	/*昵称*/
    private String nickname;
    
    /*账号*/
    private String account;
    
    /*密码*/
    private String pwd;
    
    /*分数*/
    private Integer score;
    
    /*等级*/
    private Integer rank;
    
    /*手机*/
    private String mobile;
    
    /*邮箱*/
    private String mail;
    
    private String qq;
    
    /*头像*/
	private String headimg;

	public User(){
		super();
	}
	
	public User(Integer id, String nickname, String account, String pwd,
			Integer score, Integer rank, String mobile, String qq,String mail,
			String headimg) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.account = account;
		this.pwd = pwd;
		this.score = score;
		this.rank = rank;
		this.mobile = mobile;
		this.qq = qq;
		this.headimg = headimg;
		this.mail = mail;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getHeadimg() {
		return headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
    
    
}

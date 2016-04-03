package com.lin.entity;

import java.io.Serializable;

/**
 * 
 * <p>ClassName: User.java<p>
 * <p>Description<p>
 * @author linzj
 * @createTime 2016年4月1日  下午3:38:31
 */
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
    
    private String nickname;
    
    private String account;
    
    private Integer score;
    
    private Integer level;
    
    private String mobile;
    
    private String qq;
    
	private String headImg;
    
    private Commodity publishCommodity;
    
    
}

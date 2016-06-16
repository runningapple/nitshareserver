package com.lin.service;

import com.lin.entity.User;

public interface UserService {

	/**
	 * 用户登录
	 * @param account
	 * @param pwd
	 * @return
	 */
	public String loginUser(String account, String pwd);
	
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	public String registerUser(User user);
	
	/**
	 * 查询账号是否重复
	 * @param mail
	 * @return
	 */
	public String checkAccount(String account);
	
	/**
	 * 获取用户详细信息
	 * @param id
	 * @return
	 */
	public String searchUser(String id);
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public String updateUser(User user);
	
}

package com.lin.dao;

import java.util.HashMap;
import java.util.List;

import com.lin.entity.User;

/**
 * 
 * <p>ClassName: UserDao.java<p>
 * <p>Description<p>
 * @author linzj
 * @createTime 2016年4月8日  上午9:30:48
 */
public interface UserDao {

	/**
	 * 根据账号和密码查询用户
	 * @param account
	 * @param pwd
	 * @return
	 */
	public List<HashMap<String, Object>> queryUserByAP(String account, String pwd);
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public boolean addUser(User user);
	
	/**
	 * 判断账号是否存在
	 * @param account
	 * @return
	 */
	public List<HashMap<String, Object>> isExist(String account);
}

package com.lin.redis;

import com.lin.entity.User;

/**
 * 
 * 用户登录或者退出状态直接保存在redis里
 * <p>ClassName: UserRedis.java<p>
 * <p>Description<p>
 * @author linzj
 * @createTime 2016年4月1日  下午4:19:08
 */
public interface UserRedis {
	
	/**
	 * 添加或者更新redis中的用户
	 * @param user
	 */
	public void addOrUpdate(User user);
	
	/**
	 * 根据用户id获取用户对象
	 * @param id
	 * @return
	 */
	public User loadUser(String id);
	
	/**
	 * 根据id删除redis中的用户
	 * @param id
	 */
	public void deleteUserById(String id);
}

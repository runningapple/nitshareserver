package com.lin.redis;


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
	 * @param account
	 */
	public void addOrUpdate(String account);
	
	/**
	 * 根据用户id获取用户对象
	 * @param account
	 * @return
	 */
	public boolean loadUser(String account);
	
	/**
	 * 根据id删除redis中的用户
	 * @param account
	 */
	public void deleteUserById(String account);
}

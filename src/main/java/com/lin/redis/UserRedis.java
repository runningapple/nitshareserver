package com.lin.redis;

import com.lin.entity.User;

/**
 * 用户登录或者退出状态直接保存在redis里
 * <p>ClassName: UserRedis.java<p>
 * <p>Description<p>
 * @author linzj
 * @createTime 2016年4月1日  下午4:19:08
 */
public interface UserRedis {
	public void addOrUpdate(User user);
	
	public User load(String id);
	
	public void delete(String id);
}

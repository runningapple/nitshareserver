package com.lin.redis.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.lin.entity.User;
import com.lin.redis.UserRedis;

/**
 * 
 * <p>ClassName: UserRedisImpl.java<p>
 * <p>Description<p>
 * @author linzj
 * @createTime 2016年4月1日  下午4:19:21
 */
@Service("userRedis")
public class UserRedisImpl implements UserRedis{
	
	@Autowired
	private RedisTemplate<String, User> redisTemplate;
	
	@Override
	public void addOrUpdate(User user) {
		redisTemplate.opsForValue().set("user.id."+user.getId(), user);
	}

	@Override
	public void deleteUserById(String id) {
		redisTemplate.delete("user.id." + id);
	}

	@Override
	public User loadUser(String id) {
		
		User user = (User)redisTemplate.opsForValue().get("user.id." + id);
		
		return user;
	}

}

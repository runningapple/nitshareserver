package com.lin.redis.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

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
	private RedisTemplate<String, String> redisTemplate;
	
	@Override
	public void addOrUpdate(String account) {
//		redisTemplate.opsForValue().set("user.id"+user.getAccount(), user);
		redisTemplate.opsForSet().add("user.id", account);
	}

	@Override
	public void deleteUserById(String account) {
//		redisTemplate.delete("user.id" + id);
		redisTemplate.opsForSet().remove("user.id", account);
	}

	@Override
	public boolean loadUser(String account) {
		
//		Object oj = redisTemplate.opsForValue().get("user.id." + account);
		boolean result = redisTemplate.opsForSet().isMember("user.id", account);
		return result;
//		return user;
	}

}

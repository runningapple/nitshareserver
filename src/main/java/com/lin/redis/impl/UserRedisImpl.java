package com.lin.redis.impl;

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
@Service
public class UserRedisImpl implements UserRedis{

	@Override
	public void addOrUpdate(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User load(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}
/*
	@Autowired
	private RedisTemplate<String, Book> redisTemplate;

	@Override
	public void addOrUpdate(Book user) {
		redisTemplate.opsForValue().set("user.id."+user.getId(), user);
	}

	@Override
	public Book load(String id) {
		return redisTemplate.opsForValue().get("user.id." + id); 
	}

	@Override
	public void delete(String id) {
		redisTemplate.delete("user.id." + id);
	}*/

}

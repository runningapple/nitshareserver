package com.lin.redis.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.lin.entity.Book;
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
	}

}

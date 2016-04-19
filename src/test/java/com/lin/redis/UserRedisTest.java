package com.lin.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lin.entity.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml","classpath:spring-redis.xml"})
public class UserRedisTest {

	@Autowired
	private UserRedis userRedis;
	
	/**
	 * 添加用户测试
	 */
	@Test
	public void addUserTest(){
		User user = new User();
		user.setId(41545);
		user.setAccount("aaa");
		userRedis.addOrUpdate(user);
	}
	
	
}

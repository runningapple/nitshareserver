package com.lin.test;

import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lin.entity.User;
import com.lin.redis.UserRedis;

/**
 * 
 * <p>ClassName: RedisTest.java<p>
 * <p>redis测试类<p>
 * @author linzj
 * @createTime 2016年4月1日  下午3:37:05
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-redis.xml")
public class RedisTest {
	
	@Autowired
	private UserRedis userRedis;
	
	private String id = "123";
	private String name = "toadm";
	User user = new User();
	
	/**
	 * 测试保存，set
	 */
	@Test
	public void save(){

	}
	
	/**
	 * 测试获取
	 */
	@Test
	public void read(){
	}
	
	/**
	 * 测试删除
	 */
	@Test
	public void delete(){
		userRedis.delete(id);
		user = userRedis.load(id);
		assertNull(user);
	}
}

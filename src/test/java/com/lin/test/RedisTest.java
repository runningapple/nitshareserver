package com.lin.test;

import static org.junit.Assert.*;

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
	 * 添加测试，set
	 */
	@Test
	public void add(){
		user.setId(0);
		user.setAccount("12241");
		user.setHeadimg("img");
		user.setMail("admin@admin.com");
		user.setPwd("dfd");
		user.setNickname("linzj");
//		userRedis.addOrUpdate(user);
	}
	
	/**
	 * 测试获取
	 */
	@Test
	public void read(){
//		user = userRedis.loadUser("0");
		System.out.println(user);
		assertEquals("linzj",user.getNickname());
	}
	
	/**
	 * 测试删除
	 */
	@Test
	public void delete(){
		userRedis.deleteUserById("0");
//		user = userRedis.loadUser("0");
		assertNull(user);
	}
}

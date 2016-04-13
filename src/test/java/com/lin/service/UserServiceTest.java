package com.lin.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lin.entity.User;

/**
 * 
 * <p>ClassName: UserServiceTest.java<p>
 * <p>Description<p>
 * @author linzj
 * @createTime 2016年4月13日  上午11:01:07
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 用户注册测试
	 */
	@Test
	public void registerTest(){
		User user = new User();
		user.setAccount("runningapple@abcx.com");
		user.setNickname("linzjx");
		user.setPwd("abc");
		String result = userService.registerUser(user);
		System.out.println(result);
	}
	
}

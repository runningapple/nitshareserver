package com.lin.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lin.entity.User;
import com.lin.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-jpa.xml"})
public class JpaTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void testJpa() {
		List<User> users = userService.find();
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testfindUserByName(){
		String name = "aa";
		System.out.println(userService.findUserByName(name));
	}
	
	@Test
	public void testfindUserByAge(){
		Integer age = 23;
		System.out.println(userService.findUserByAge(age));
	}
}

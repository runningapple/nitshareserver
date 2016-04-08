package com.lin.dao;

import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONArray;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lin.entity.User;

/**
 * 
 * <p>ClassName: UserDaoTest.java<p>
 * <p>Description<p>
 * @author linzj
 * @createTime 2016年4月8日  上午10:46:30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class UserDaoTest {
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void addTest(){
		User user = new User(0, "yyy","yyy", "yyy",0,0,"1572654665","a@b.com","851522","asdf");
		boolean result = userDao.addUser(user);
		System.out.println(result);
	}
	
	@Test
	public void findTest(){
		List<HashMap<String, Object>> resultList = userDao.queryUserByAP("yyy", "yyy");
		String result = JSONArray.fromObject(resultList).toString();
		System.out.println(result);
	}
	
	@Test
	public void checkTest(){
		List<HashMap<String, Object>> resultList = userDao.isExist("yayy");
		String result = JSONArray.fromObject(resultList).toString();
		System.out.println(result);
	}
}

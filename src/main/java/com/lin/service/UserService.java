package com.lin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lin.dao.UserDao;
import com.lin.entity.User;

/**
 * 
 * <p>ClassName: UserService.java<p>
 * <p>Description<p>
 * @author linzj
 * @createTime 2016年4月1日  下午3:38:46
 */
@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public List<User> find(){
		return (List<User>) userDao.findAll();
	}
	
	public User findUserByName(String name){
		return userDao.findByUsername(name);
	}
	
	public User findUserByAge(Integer age){
		return userDao.findByUserage(age);
	}
}

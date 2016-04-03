package com.lin.service;

import org.springframework.stereotype.Service;

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
	
	
	public User findUserByName(String name){
		return new User();
	}
	
	public User findUserByAge(Integer age){
		return new User();
	}
}

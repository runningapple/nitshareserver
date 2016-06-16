package com.lin.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lin.dao.UserDao;
import com.lin.entity.User;
import com.lin.service.UserService;

/**
 * 
 * <p>ClassName: UserServiceImpl.java<p>
 * <p>Description<p>
 * @author linzj
 * @createTime 2016年4月8日  上午11:06:29
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public String loginUser(String account, String pwd) {
		/**
		 * 这里需要添加验证方法
		 */
		List<HashMap<String, Object>> resultList = this.userDao.queryUserByAP(account, pwd);
		
		return JSONArray.fromObject(resultList).toString();
	}

	@Override
	public String registerUser(User user) {
		boolean result = this.userDao.addUser(user);
		List<HashMap<String, Object>> resultList = null;
		if (result == true){
			resultList = this.userDao.queryUserByAP(user.getAccount(), user.getPwd());
		}
		return JSONArray.fromObject(resultList).toString();
	}

	@Override
	public String checkAccount(String account) {

		List<HashMap<String, Object>> resultList = this.userDao.isExist(account);
		
		return JSONArray.fromObject(resultList).toString();
	}

	@Override
	public String searchUser(String id) {
		
		List<HashMap<String, Object>> resultList = this.userDao.queryUserById(id);
		
		return JSONArray.fromObject(resultList).toString();
	}

	@Override
	public String updateUser(User user) {
		boolean result = this.userDao.updateUser(user);
		return result == true ? "success" : "fail";
	}
	
}

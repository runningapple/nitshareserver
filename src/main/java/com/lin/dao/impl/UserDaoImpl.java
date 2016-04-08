package com.lin.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.lin.dao.UserDao;
import com.lin.entity.User;

/**
 * 
 * <p>ClassName: UserDaoImpl.java<p>
 * <p>Description<p>
 * @author linzj
 * @createTime 2016年4月8日  上午9:30:21
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SqlMapClient sqlMapClient;
	
	@Override
	public List<HashMap<String, Object>> queryUserByAP(String account, String pwd) {
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
		HashMap<String, String> codMap = new HashMap<String, String>();
		codMap.put("account", account);
		codMap.put("pwd", pwd);
		try{
			result = this.sqlMapClient.queryForList("User.getUser", codMap);
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean addUser(User user) {
		boolean result = true;
		try{
			this.sqlMapClient.insert("User.insert", user);
		} catch(SQLException ex){
			result = false;
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public List<HashMap<String, Object>> isExist(String account) {
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
		HashMap<String, String> codMap = new HashMap<String, String>();
		codMap.put("account", account);
		try{
			result = this.sqlMapClient.queryForList("User.checkAccount", codMap);
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return result;
	}

}

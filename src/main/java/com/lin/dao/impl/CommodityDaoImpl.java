package com.lin.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.lin.dao.CommodityDao;
import com.lin.entity.Commodity;

/**
 * 
* @ClassName: CommodityDaoImpl 
* @Description: TODO 
* @author linzj 
* @date 2016年4月3日 下午5:40:08 
*
 */
@Repository("commodityDao")
public class CommodityDaoImpl implements CommodityDao {

	@Autowired
	private SqlMapClient sqlMapClient;
	
	@Override
	public List<HashMap<String, Object>> getCommodity(int page, int size) {
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
		HashMap<String, Integer> codMap = new HashMap<String, Integer>();
		codMap.put("page", page);
		codMap.put("size", size);
		try{
			result = this.sqlMapClient.queryForList("Commodity.get", codMap);
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean addCommodity(Commodity commodity) {
		boolean result = true;
		try{
			this.sqlMapClient.insert("Commodity.insert", commodity);
		} catch(SQLException ex){
			result = false;
			ex.printStackTrace();
		}
		return result;
	}

}

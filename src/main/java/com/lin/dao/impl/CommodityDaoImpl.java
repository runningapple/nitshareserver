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
	public List<HashMap<String, Object>> queryCommodityIntroduction(int page, int size) {
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
		HashMap<String, Integer> codMap = new HashMap<String, Integer>();
		codMap.put("page", page);
		codMap.put("size", size);
		try{
			result = this.sqlMapClient.queryForList("Commodity.getCommodityIntroduction", codMap);
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

	@Override
	public boolean delCommodity(int commodityId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<HashMap<String, Object>> queryCommodityByName(String name, int page, int size) {
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
		HashMap<String, Object> codMap = new HashMap<String, Object>();
		codMap.put("name", name);
		codMap.put("page", page);
		codMap.put("size", size);
		try{
			result = this.sqlMapClient.queryForList("Commodity.fuzzyQuery", codMap);
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public List<HashMap<String, Object>> queryCommodityByType(int type,int page, int size) {
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
		HashMap<String, Integer> codMap = new HashMap<String, Integer>();
		codMap.put("type", type);
		codMap.put("page", page);
		codMap.put("size", size);
		try{
			result = this.sqlMapClient.queryForList("Commodity.typeQuery", codMap);
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public List<HashMap<String, Object>> queryCommodityDetail(int id) {
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
		HashMap<String, Integer> codMap = new HashMap<String, Integer>();
		codMap.put("id", id);
		try{
			result = this.sqlMapClient.queryForList("Commodity.getCommodityDetail", codMap);
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean updateCommodity(Commodity commodity) {
		boolean result = true;
		try{
			this.sqlMapClient.update("Commodity.update", commodity);
		} catch(SQLException ex){
			result = false;
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public List<HashMap<String, Integer>> findMaxId(Commodity commodity) {
		List<HashMap<String, Integer>> result = new ArrayList<HashMap<String,Integer>>();
		HashMap<String, Object> codMap = new HashMap<String, Object>();
		codMap.put("uid", commodity.getUid());
		try{
			result = this.sqlMapClient.queryForList("Commodity.findmaxid", codMap);
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public List<HashMap<String, Object>> queryCommodityByDate(int page,
			int size) {
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
		HashMap<String, Integer> codMap = new HashMap<String, Integer>();
		codMap.put("page", page);
		codMap.put("size", size);
		try{
			result = this.sqlMapClient.queryForList("Commodity.date", codMap);
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return result;
	}


}

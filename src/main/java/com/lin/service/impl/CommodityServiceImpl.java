package com.lin.service.impl;

import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lin.dao.CommodityDao;
import com.lin.entity.Commodity;
import com.lin.service.CommodityService;

/**
 * 
* @ClassName: CommodityServiceImpl 
* @Description: TODO 
* @author linzj 
* @date 2016年4月4日 下午1:10:32 
*
 */
@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {

	@Autowired
	private CommodityDao commodityDao;
	
	@Override
	public String getCommodity(String page, String size) {
		List<HashMap<String, Object>> resultList = this.commodityDao.queryCommodity(Integer.parseInt(page), Integer.parseInt(size));
		return JSONArray.fromObject(resultList).toString();
	}

	@Override
	public String addCommodity(Commodity commodity) {
		boolean result = this.commodityDao.addCommodity(commodity);
		String resultString = result == true ? "success" : "false";
		return resultString;
	}

}

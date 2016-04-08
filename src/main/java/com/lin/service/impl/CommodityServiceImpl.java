package com.lin.service.impl;

import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lin.dao.CommodityDao;
import com.lin.entity.Commodity;
import com.lin.service.CommodityService;
import com.lin.utils.NumberRegex;

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
	public String queryCommodityByPage(String page, String size) {
		int npage = 0;
		int nsize = 0;
		
		if (NumberRegex.isUnNagativeInteger(page) && NumberRegex.isUnNagativeInteger(size)){
			nsize = Integer.parseInt(size);
			npage = Integer.parseInt(page) * nsize;
		}
		List<HashMap<String, Object>> resultList = this.commodityDao.queryCommodityIntroduction(npage, nsize);
		return JSONArray.fromObject(resultList).toString();
	}

	@Override
	public String addCommodity(Commodity commodity) {
		boolean result = this.commodityDao.addCommodity(commodity);
		String resultString = result == true ? "success" : "false";
		return resultString;
	}

	@Override
	public String fuzzyQuery(String name, String page, String size) {
		int npage = 0;
		int nsize = 0;
		
		if (NumberRegex.isUnNagativeInteger(page) && NumberRegex.isUnNagativeInteger(size)){
			nsize = Integer.parseInt(size);
			npage = Integer.parseInt(page) * nsize;
		}
		List<HashMap<String, Object>> resultList = this.commodityDao.queryCommodityByName(name, npage, nsize);
		return JSONArray.fromObject(resultList).toString();
	}

}

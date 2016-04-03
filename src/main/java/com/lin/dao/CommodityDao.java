package com.lin.dao;

import java.util.HashMap;
import java.util.List;

import com.lin.entity.Commodity;

/**
 * 
* @ClassName: CommodityDao 
* @Description: TODO 
* @author linzj 
* @date 2016年4月3日 下午5:38:46 
*
 */
public interface CommodityDao {
	
	/**
	 * 分页获取商品
	 * @return
	 */
	public List<HashMap<String, Object>> getCommodity(int page, int size);
	
	/**
	 * 添加商品
	 * @param commodity
	 * @return
	 */
	public boolean addCommodity(Commodity commodity);
	
}

package com.lin.service;

import com.lin.entity.Commodity;

/**
 * 
* @ClassName: CommodityService 
* @Description: TODO 
* @author linzj 
* @date 2016年4月3日 下午6:03:59 
*
 */
public interface CommodityService {

	/**
	 * 获取商品
	 * @param page	页数
	 * @param size	个数
	 * @return
	 */
	public String queryCommodityByPage(String page, String size);
	
	/**
	 * 添加商品
	 * @param commodity
	 * @return
	 */
	public String addCommodity(Commodity commodity);
	
	
}

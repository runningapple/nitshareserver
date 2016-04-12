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
	 * 分页获取商品概要信息
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
	
	/**
	 * 根据商品名模糊查询商品
	 * @param name	待查询商品名
	 * @param page
	 * @param size
	 * @return
	 */
	public String fuzzyQuery(String name, String page, String size);
	
	/**
	 * 根据商品类型查询商品概要信息
	 * @param type	商品类型码
	 * @param page
	 * @param size
	 * @return
	 */
	public String queryByType(String type, String page, String size);
	
	/**
	 * 根据商品id查询商品详细信息
	 * @param id
	 * @return
	 */
	public String queryCommodityById(String id);
	
}

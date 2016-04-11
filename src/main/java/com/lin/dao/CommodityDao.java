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
	 * 分页获取商品,展示商品
	 * @return
	 */
	public List<HashMap<String, Object>> queryCommodityIntroduction(int page, int size);
	
	
	/**
	 * 添加商品
	 * @param commodity
	 * @return
	 */
	public boolean addCommodity(Commodity commodity);
	
	/**
	 * 删除商品
	 * @param commodityId
	 * @return
	 */
	public boolean delCommodity(int commodityId);
	
	/**
	 * 修改商品信息
	 * @param commodity
	 * @return
	 */
	public boolean modifyCommodity(Commodity commodity);
	
	/**
	 * 根据商品类型分页查询商品概要信息
	 * @param type
	 * @param page
	 * @param size
	 * @return
	 */
	public List<HashMap<String, Object>> queryCommodityByType(int type, int page, int size);
	
	/**
	 * 根据商品名，用户名模糊分页查询商品
	 * @param name
	 * @param page
	 * @param size
	 * @return
	 */
	public List<HashMap<String, Object>> queryCommodityByName(String name, int page, int size);
}

package com.lin.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONArray;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lin.dao.CommodityDao;
import com.lin.entity.Commodity;

/**
 * 
* @ClassName: CommodityTest 
* @Description: TODO 
* @author linzj 
* @date 2016年4月4日 下午1:08:52 
*
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class CommodityTest {
	
	@Autowired
	private CommodityDao commodityDao;
	
	/**
	 * 商品分页获取测试
	 */
	@Test
	public void queryCommodityTest(){
		List<HashMap<String, Object>> resultList = commodityDao.queryCommodity(0, 1);
		String result = JSONArray.fromObject(resultList).toString();
		System.out.println(result);
	}
	
	/**
	 * 商品添加测试
	 */
	@Test
	public void addCommodityTest(){
		Commodity cd = new Commodity(2,1,new Date(),"test1",
				3.2,"test1","test","test","test","test",0,"test","test",0,0);
		boolean result = commodityDao.addCommodity(cd);
		System.out.println(result);
	}
}

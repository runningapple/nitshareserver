package com.lin.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * <p>ClassName: CommodityServiceTest.java<p>
 * <p>Description<p>
 * @author linzj
 * @createTime 2016年4月5日  上午9:49:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class CommodityServiceTest {

	@Autowired
	private CommodityService cs;
	
	/**
	 * 分页获取商品测试
	 */
	@Test
	public void queryByPageTest(){
		String result = cs.queryCommodityByPage("0", "4");
		System.out.println(result);
	}
	
	@Test
	public void fuzzyQueryTest(){
		String result = cs.fuzzyQuery("a", "0", "1");
		System.out.println(result);
	}
	
	/**
	 * 根据商品商品类型查询
	 */
	@Test
	public void typeQuery(){
		String result = cs.queryByType("0", "0", "1");
		System.out.println(result);
	}
	
	/**
	 * 根据id查询商品
	 */
	@Test
	public void queryByid(){
		String result = cs.queryCommodityById("1");
		System.out.println(result);
	}
}

package com.lin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lin.service.CommodityService;

/**
 * 
 * <p>ClassName: WebserviceInterface.java<p>
 * <p>Service接口<p>
 * @author linzj
 * @createTime 2016年4月1日  下午2:42:57
 */
@Controller
@RequestMapping("/serve")
public class WebserviceInterface {

	@Autowired
	private CommodityService commodityService;
	
	/**
	 * 测试demo
	 * @param name
	 * @param callback
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/find", method=RequestMethod.GET)
	public String test(String name, String callback){
		System.out.println("in");
		return this.result(callback,name);
	}
	
	/**
	 * 分页获取商品接口
	 * http://localhost:8080/nitshare/serve/commodity.get?page=0&size=1&callback=back
	 * @param page
	 * @param size
	 * @param callback
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="commodity.get", method=RequestMethod.GET)
	public String queryCommodity(String page, String size, String callback){
		return this.result(callback, this.commodityService.queryCommodityByPage(page.trim(), size.trim()));
	}
	
	/**
	 * 包装函数
	 * @param callbackFunction
	 * @param resultData
	 * @return
	 */
	private String result(String callbackFunction, String resultData) {
		return callbackFunction + "(" + resultData + ")";
	}
}
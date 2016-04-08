package com.lin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lin.entity.User;
import com.lin.service.CommodityService;
import com.lin.service.UserService;

/**
 * mvn package -Dmaven.test.failture.ignore=true maven打包
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
	
	@Autowired
	private UserService userService;
	
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
	@RequestMapping(value="commodity.get",produces="text/html;charset=UTF-8", method=RequestMethod.GET)//添加produces防止数据传到前台乱码
	public String queryCommodity(String page, String size, String callback){
		return this.result(callback, this.commodityService.queryCommodityByPage(page.trim(), size.trim()));
	}
	
	/**
	 * 根据商品名，模糊分页查询商品
	 * @param name
	 * @param page
	 * @param size
	 * @param callback
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="commodity.fuzzy",produces="text/html;charset=UTF-8", method=RequestMethod.GET)
	public String fuzzyQuery(String name, String page, String size, String callback){
		return this.result(callback, this.commodityService.fuzzyQuery(name.trim(), page.trim(), size.trim()));
	}
	/**
	 * 注册用户
	 * 
	 * http://localhost:8080/nitshare/serve/user.register?nickname=tom&password=123&phone=123&qq=33&mail=a@b.com&callback=back
	 * @param user
	 * @param callback
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="user.register", produces="text/html;charset=UTF-8", method=RequestMethod.GET)
	public String registerUser(User user, String callback){
		return this.result(callback, this.userService.registerUser(user));
	}
	
	/**
	 * 用户登录
	 * http://localhost:8080/nitshare/serve/user.login?account=yyy&pwd=yyy&callback=back
	 * @param account	账号
	 * @param password	密码
	 * @param callback
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/user.login", produces="text/html;charset=UTF-8", method = RequestMethod.GET)
	public String loginUser(String account, String pwd, String callback) {
		return this.result(callback, this.userService.loginUser(account, pwd));
	}
	
	/**
	 * 验证账号唯一性
	 * 
	 * http://localhost:8080/nitshare/serve/user.login?account=yyy&callback=back
	 * @param account
	 * @param callback
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/user.check", produces="text/html;charset=UTF-8", method = RequestMethod.GET)
	public String checkAccount(String account, String callback){
		return this.result(callback, this.userService.checkAccount(account));
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
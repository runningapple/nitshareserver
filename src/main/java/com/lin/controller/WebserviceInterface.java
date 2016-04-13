package com.lin.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lin.entity.User;
import com.lin.service.CommodityService;
import com.lin.service.UploadFileService;
import com.lin.service.UserService;
import com.lin.utils.PropertiesUtil;

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
	
	@Autowired
	private UploadFileService uploadFileService;
	
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
	 * 根据id获取商品详细信息
	 * http://localhost:8080/nitshare/serve/commodity.detail?id=1&callback=back
	 * @param id
	 * @param callback
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="commodity.detail",produces="text/html;charset=UTF-8", method=RequestMethod.GET)
	public String queryCommodityDetail(String id, String callback){
		return this.result(callback, this.commodityService.queryCommodityById(id.trim()));
	}
	
	/**
	 * 根据商品名模糊分页查询商品，根据商品类型查询
	 * 当type为-1的时候，则表示根据商品名进行模糊查询，否则为根据商品类型精确查询
	 * http://localhost:8080/nitshare/serve/commodity.fuzzy?name=a&type=其它&page=0&size=1&callback=back
	 * @param name
	 * @param type
	 * @param page
	 * @param size
	 * @param callback
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="commodity.fuzzy",produces="text/html;charset=UTF-8", method=RequestMethod.GET)
	public String fuzzyQuery(String name, String type, String page, String size, String callback){
		
		if ("-1".equals(type)){
			return this.result(callback, this.commodityService.fuzzyQuery(name.trim(), page.trim(), size.trim()));
		}else{
			String typeCode = PropertiesUtil.getConfig(type.trim()).trim();
			return this.result(callback, this.commodityService.queryByType(typeCode, page.trim(), size.trim()));
		}
	}
	
	/**
	 * 注册用户
	 * 
	 * http://localhost:8080/nitshare/serve/user.register?nickname=tom&pwd=123&account=adf&callback=back
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
	 * http://localhost:8080/nitshare/serve/user.check?account=yyy&callback=back
	 * @param account
	 * @param callback
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="user.check", produces="text/html;charset=UTF-8", method = RequestMethod.GET)
	public String checkAccount(String account, String callback){
		return this.result(callback, this.userService.checkAccount(account));
	}
	
	/**
	 * 判断用户是否已经登录过，用户登录记录存储在redis里
	 * @param account
	 * @param callback
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="user.islogin", produces="text/html;charset=UTF-8", method = RequestMethod.GET)
	public String checkUserInRedis(String account, String callback){
		
		return null;
	}
	
	/**
	 * 上传文件
	 * http://localhost:8080/nitshare/serve/uploadfile
	 * @param filename
	 * @param clientfile
	 * @param callback
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="uploadfile", method=RequestMethod.POST)
	public String uploadFile(@RequestParam("filepic") MultipartFile filepic){
		uploadFileService.uploadFile("./", filepic, "test.txt");
		return "success";
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
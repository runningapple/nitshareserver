package com.lin.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lin.entity.Commodity;
import com.lin.entity.User;
import com.lin.service.CommodityService;
import com.lin.service.UploadFileService;
import com.lin.service.UserService;
import com.lin.utils.FileUtil;
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
	 * 获取最新商品信息
	 * @param page
	 * @param size
	 * @param callback
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="commodity.date",produces="text/html;charset=UTF-8", method=RequestMethod.GET)
	public String queryCommodityByDate(String page, String size, String callback){
		return this.result(callback, this.commodityService.queryCommodityByDate(page.trim(), size.trim()));
	}
	
	/**
	 * 根据id获取商品详细信息
	 * http://localhost:8080/nitshareserver/serve/commodity.detail?id=1&callback=back
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
		String resultName = "";
		try {
			resultName = URLDecoder.decode(name.trim(), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if ("-1".equals(type.trim())){
			return this.result(callback, this.commodityService.fuzzyQuery(resultName.trim(), page.trim(), size.trim()));
		}else{
//			String typeCode = PropertiesUtil.getConfig(type.trim()).trim();
			return this.result(callback, this.commodityService.queryByType(type.trim(), page.trim(), size.trim()));
		}
	}
	
	/**
	 * 添加商品信息
	 * @param commodity
	 * @param callback
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="commodity.add",produces="text/html;charset=UTF-8", method=RequestMethod.GET)
	public String addCommodityDetail(Commodity commodity, String callback){
		return this.result(callback, this.commodityService.updateCommodity(commodity));
	}
	
	
	/**
	 * 注册用户
	 * 
	 * http://localhost:8080/nitshareserver/serve/user.register?nickname=tom&pwd=123&account=adf&callback=back
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
	 * http://localhost:8080/nitshareserver/serve/user.login?account=yyy&pwd=yyy&callback=back
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
	 * 文件上传
	 * http://localhost:8080/nitshareserver/serve/fileupload
	 * @param name
	 * @param myfiles
	 * @param request
	 * @param response
	 * @return
	 */
//	@ResponseBody
	@RequestMapping(value="fileupload", method=RequestMethod.POST,produces="text/html;charset=utf-8")
	public void addPic(HttpServletResponse response,HttpServletRequest request,
			@RequestParam(value="file", required=false) MultipartFile file,
			@RequestParam(value="uid", required=false) String uid) throws IOException{
		
		String fileName = file.getOriginalFilename().replaceAll(" ", "");
		System.out.println(fileName);
		if (file.getSize() > 0){
			FileUtil.saveFile(fileName, file);
		}
		
		String showDir = PropertiesUtil.getConfig("getPicUrl")+"/" + fileName;
		Commodity commodity = new Commodity();
		commodity.setImgUrl0(showDir);
		commodity.setUid(Integer.parseInt(uid.trim()));
		commodity.setPubDate(new Date());
		commodityService.addCommodity(commodity);
		
		/**
		 * 将结果返回前端
		 */
		List<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("showDir", showDir);
		list.add(hashMap);
		String result = JSONArray.fromObject(list).toString();
		response.getWriter().append(result);
		response.setContentType("application/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
	}
	
	/**
	 * 上传文件
	 * http://localhost:8080/nitshareserver/serve/uploadfile
	 * @param filename
	 * @param clientfile
	 * @param callback
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="uploadfile", method=RequestMethod.POST)
	public String uploadFile(@RequestParam("filepic") MultipartFile filepic, String callback){
		System.out.println(callback);
		uploadFileService.uploadFile("./", filepic, "test.jpg");
		return this.result(callback,"success");
	}
	
	/**
	 * 包装方法
	 * @param callbackFunction
	 * @param resultData
	 * @return
	 */
	private String result(String callbackFunction, String resultData) {
		return callbackFunction + "(" + resultData + ")";
	}
}
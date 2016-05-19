package com.lin.utils;

import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * <p>ClassName: PropertiesUtil.java<p>
 * <p>配置文件读取类<p>
 * @author linzj
 * @createTime 2016年4月11日  下午1:29:08
 */
public class PropertiesUtil {
	
	private static Properties properties = null;
	public static final String DEFAULT_CONFIG_FILE = "imgurl.properties";
	
	public static final Properties loadProperties(){
		return loadProperties(DEFAULT_CONFIG_FILE);
	}
	
	public static final Properties loadProperties(String fileName){
		if (null == properties){
			try{
				ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
				InputStream is = classLoader.getResourceAsStream(fileName);
				properties = new Properties();
				properties.load(is);
			}catch (Exception ex){
				ex.printStackTrace();
			}
		}
		return properties;
	}
	
	public static String getConfig(String key){
		return getConfigString(key);
	}
	
	public static String getConfigString(String key){
		return getConfigString(key, null);
	}
	
	public static String getConfigString (String key, String defaultValue){
		loadProperties(DEFAULT_CONFIG_FILE);
		if (null == properties) return defaultValue;
		return properties.getProperty(key,defaultValue);
	}
	
	public static void main(String[] args) {
		System.out.println(PropertiesUtil.getConfig("热门推荐").trim());
	}
}

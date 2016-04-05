package com.lin.utils;

import java.util.List;

import org.junit.Test;

/**
 * <p>ClassName: FileUtilTest.java<p>
 * <p>文件测试<p>
 * @author linzj
 * @createTime 2016年4月5日  下午1:50:04
 */
public class FileUtilTest {

	
	/**
	 * 测试文件获取
	 */
	@Test
	public void getFile(){
		FileUtil fu = new FileUtil();
		fu.getFile("E:\\素材\\nitshareImg\\copy");
		List<String> result = fu.getResult();
		for (String s : result){
			String t = s.replaceAll("\\\\", "\\/");
			System.out.println(t);
		}
	}
}

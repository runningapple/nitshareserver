package com.lin.utils;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

/**
 * 
 * <p>ClassName: ImgUtilTest.java<p>
 * <p>图片测试<p>
 * @author linzj
 * @createTime 2016年4月5日  下午1:49:41
 */
public class ImgUtilTest {
	
	@Test
	public void imgTest(){
		int cnt = 0;
		FileUtil fu = new FileUtil();
		fu.getFile("E:\\素材\\nitshareImg");
		List<String> result = fu.getResult();
		for (String s : result){
			try {
				s = s.replaceAll("\\\\", "\\\\\\\\");
				ImageUtil.resizeImage(s, "E:\\素材\\nitshareImg\\copy\\"+cnt+".jpg", 160, 160);
				cnt++;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void oneImgTest(){
		try {
			ImageUtil.resizeImage("E:\\素材\\nitshareImg\\a.jpg", "E:\\素材\\nitshareImg\\copy\\a.jpg", 160, 160);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package com.lin.utils;

import org.junit.Test;

public class PropertiesUtilTest {
	
	@Test
	public void readTest(){
		System.out.println(PropertiesUtil.getConfig("savePicUrl").trim());
	}
}

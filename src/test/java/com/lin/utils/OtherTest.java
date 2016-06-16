package com.lin.utils;

import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONArray;

import org.junit.Test;

public class OtherTest {
	
	@Test
	public void tt(){
		List<HashMap<String, Object>> result = null;
		System.out.println(JSONArray.fromObject(result).toString().equals("[null]"));
	}
}

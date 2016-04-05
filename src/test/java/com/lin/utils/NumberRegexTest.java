package com.lin.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 * <p>ClassName: NumberRegexTest.java<p>
 * <p>整型数判断测试<p>
 * @author linzj
 * @createTime 2016年4月5日  上午9:51:09
 */
public class NumberRegexTest {
	
	/**
	 * 判断是否为整数（不包括0）
	 */
	@Test
	public void testIsPositiveInteger() {
		assertEquals(true,NumberRegex.isPositiveInteger("1"));
		assertEquals(false,NumberRegex.isPositiveInteger("-1"));
		assertEquals(false,NumberRegex.isPositiveInteger("0"));
		assertEquals(false,NumberRegex.isPositiveInteger("adf"));
		assertEquals(false,NumberRegex.isPositiveInteger("135.54"));
	}
	
	/**
	 * 判断是否为非负整数
	 */
	@Test
	public void testIsUnNagativeInteger() {
		assertEquals(true,NumberRegex.isUnNagativeInteger("1"));
		assertEquals(false,NumberRegex.isUnNagativeInteger("-1"));
		assertEquals(true,NumberRegex.isUnNagativeInteger("0"));
		assertEquals(false,NumberRegex.isUnNagativeInteger("adf"));
		assertEquals(false,NumberRegex.isUnNagativeInteger("135.54"));
	}
}

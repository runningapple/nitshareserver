package com.lin.utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * <p>ClassName: NumberRegex.java<p>
 * <p>判断是否为数字<p>
 * @author linzj
 * @createTime 2016年4月5日  上午9:51:45
 */
public class NumberRegex {
	
/*	
	private boolean matchCapacity(String regx, String num){
		Pattern numPattern = Pattern.compile(regx);
		Matcher numMatcher = numPattern.matcher(num);
		return numMatcher.matches();
	}
	*/
	
	/**
	 * 判断是否为正整数
	 * @param num
	 * @return
	 */
	public static boolean isPositiveInteger(String num){
		num.trim();
		Pattern numPattern = Pattern.compile("^[1-9]\\d*$");
		Matcher numMatcher = numPattern.matcher(num);
		return numMatcher.matches();
	}
	
	/**
	 * 判断是否为非负整数
	 * @param num
	 * @return
	 */
	public static boolean isUnNagativeInteger(String num){
		num.trim();
		Pattern numPattern = Pattern.compile("^[1-9]\\d*|0$");
		Matcher numMatcher = numPattern.matcher(num);
		return numMatcher.matches();
	}
	
	/**
	 * 判断是否为负整数
	 * @return
	 */
	public static boolean isNagativeInteger(String num){
		num.trim();
		Pattern numPattern = Pattern.compile("^-[1-9]\\d*$");
		Matcher numMatcher = numPattern.matcher(num);
		return numMatcher.matches();
	}
	
	/**
	 * 判断是否为整数
	 * @return
	 */
	public static boolean isInteger(String num){
		num.trim();
		Pattern numPattern = Pattern.compile("^(-?[1-9]\\d*+)|0$");
		Matcher numMatcher = numPattern.matcher(num);
		return numMatcher.matches();
	}
	
	/**
	 * 判断是否为正浮点数
	 * @param num
	 * @return
	 */
	public static boolean isPositiveDecimal(String num){
		num.trim();
		Pattern numPattern = Pattern.compile("^[1-9]\\d*.\\d+|0.\\d*[1-9]\\d*$");
		Matcher numMatcher = numPattern.matcher(num);
		return numMatcher.matches();
	}
	
	/**
	 * 判断是否为负浮点数
	 * @param num
	 * @return
	 */
	public static boolean isNagativeDecimal(String num){
		num.trim();
		Pattern numPattern = Pattern.compile("^-([1-9]\\d*.\\d+|0.\\d*[1-9]\\d*$)");
		Matcher numMatcher = numPattern.matcher(num);
		return numMatcher.matches();
	}
	
	/**
	 * 判断是否为浮点数
	 * @param num
	 * @return
	 */
	public static boolean isDecimal(String num){
		num.trim();
		Pattern numPattern = Pattern.compile("^-?([1-9]\\d*.\\d+|0.\\d*[1-9]\\d*$)");
		Matcher numMatcher = numPattern.matcher(num);
		return numMatcher.matches();
	}

//	public static boolean test(){
//		Pattern numPattern = Pattern.compile("(?<=<title>).*");
//		Matcher numMatcher = numPattern.matcher("<title>abc");
//		System.out.println(numMatcher.matches());
//		return false;
//	}
	
	public static void main(String[] args) {
		String num;
		Scanner cin = new Scanner(System.in);
		while(cin.hasNext()){
			num = cin.next();
			System.out.println(num + " 是正整数吗？ " + NumberRegex.isPositiveInteger(num));
			System.out.println(num + " 是负整数吗？ " + NumberRegex.isNagativeInteger(num));
			System.out.println(num + " 是整数吗？ " + NumberRegex.isInteger(num));
			System.out.println(num + " 是正浮点数吗？ " + NumberRegex.isPositiveDecimal(num));
			System.out.println(num + " 是负浮点数吗？ " + NumberRegex.isNagativeDecimal(num));
			System.out.println(num + " 是浮点数吗？ " + NumberRegex.isDecimal(num));
		}
		
	}
}

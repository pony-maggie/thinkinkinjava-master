package com.mess;

public class ValueofTest 
{

	/**
	 * @param args
	 * 输出结果是
	 * false
	 * false
	 * true
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		//首先valueof返回是字符串所表示的整型对象的引用，下面实际上是两个引用的比较
		//按照一些网站上的分析，第一行应该返回true,因为当数据在-128~127之间时，会从缓存取，应该是同一个对象
		//不知道为什么我的运行结果是false, 和jdk版本有关,jdk5.0以上才可以，可以查看valueOf的实现源码，就很容易明白差异
		System.out.println(Integer.valueOf("127") == Integer.valueOf("127"));
		System.out.println(Integer.valueOf("128") == Integer.valueOf("128"));
		
		//parseint返回的是int型基本变量值，相当于比较128 == 128，所以是相同的。
		System.out.println(Integer.parseInt("128") == Integer.parseInt("128"));
		

	}

}

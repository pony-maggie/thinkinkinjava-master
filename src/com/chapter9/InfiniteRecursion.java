package com.chapter9;

import java.util.*;

//如何打印类对象本身的地址
public class InfiniteRecursion {

	public String toString()
	{
		//注意这里不用this, 会造成死循环
		//类InfiniteRecursion直接继承自Object，而这个类的toString方法唯一的功能就是打印对象的地址
		return "InfiniteRecursion address:" + super.toString() + "\n";
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ArrayList<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
		for(int i = 0; i < 3; i++)
		{
			v.add(new InfiniteRecursion());
		}
		System.out.println(v);
		
		
	}

}

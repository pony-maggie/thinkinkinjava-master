package com.chapter9;
import java.util.*;



public class PrintingContainers 
{

	/*
	 * 这样不指定类型(<E>)也是可以的, 或者这样写:
	 * static Collection<String> fill(Collection<String> c)
	 * 这样可以元素保留自己的特性 ，一旦他被转换成 object 它的特性就失去了，除非你再将它转换成它原来的类型才可以
	 * 从警告也可以看出，保留会好一些.
	 * 另外，注意Hahset的输出结果，少了一个dog.
	 */
	//这样不指定类型(<E>)也是可以的
	static Collection fill(Collection c)
	{
		c.add("dog");
		c.add("dog");
		c.add("cat");
		return c;
	}
	
	static Map fill(Map m)
	{
		m.put("dog", "bosco");
		m.put("dog", "spot");
		m.put("cat", "rags");
		return m;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println(fill(new ArrayList()));
		System.out.println(fill(new HashSet()));
		System.out.println(fill(new HashMap()));

	}

}

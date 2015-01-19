package com.chapter9;
import java.util.*;


public class FillingList {

	/**
	 * @param args
	 * fill只会对已经存在空间填充，所以下面的for循环必不可少
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		
		for (int i = 0; i < 10; i++) 
		{
			list.add("");
		}
		
		Collections.fill(list, "hello");
		System.out.println(list);

	}

}

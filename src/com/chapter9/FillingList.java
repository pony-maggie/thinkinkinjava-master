package com.chapter9;
import java.util.*;


public class FillingList {

	/**
	 * @param args
	 * fillֻ����Ѿ����ڿռ���䣬���������forѭ���ز�����
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

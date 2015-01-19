package com.chapter12;

import java.lang.reflect.*;

public class ShowMethods 
{

	static final String usage = 
		"Usage: \n" +
		"ShowMethods qualified.class.name\n" +
		"To show all methods in class or: \n"+
		"ShowMethods qualified.class.name word\n"+
		"To search for methods involving 'word'";
	
	
	/**
	 * @param args
	 * 打印一个类所有的方法，包括基类中的方法
	 * 执行这个代码要在run configuration里指定参数
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		if(args.length < 1)
		{
			System.out.println(usage);
			System.exit(0);
		}
		
		System.out.println(String.valueOf(' '));
		
		try 
		{
			Class c = Class.forName(args[0]);
			Method[] methods = c.getMethods();
			Constructor[] ctor = c.getConstructors();
			if(args.length == 1)
			{
				for(int i = 0; i < methods.length; i++)
				{
					System.out.println(methods[i]);//注意这个也会打印基类的方法
				}
				for(int i = 0; i < ctor.length; i++)
				{
					System.out.println(ctor[i]);
				}
			}
			else
			{
				//这一段的意义第一个参数是类名，第二个参数是要查找到方法名关键字
				for(int i = 0; i < methods.length; i++)
				{
					if(methods[i].toString().indexOf(args[1]) != -1)
						System.out.println(methods[i]);
				}
				
				for(int i = 0; i < ctor.length; i++)
				{
					if(ctor[i].toString().indexOf(args[1]) != -1)
						System.out.println(ctor[i]);
				}
			}
			
		} catch (ClassNotFoundException e) 
		{
			// TODO: handle exception
			System.err.println("no such class: " + e);
		}
	}

}

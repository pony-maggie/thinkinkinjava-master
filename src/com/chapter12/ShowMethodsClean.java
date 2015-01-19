package com.chapter12;

import java.lang.reflect.*;

import com.bruceeckel.util.*;

public class ShowMethodsClean 
{
	static final String usage = 
		"Usage: \n" +
		"ShowMethods qualified.class.name\n" +
		"To show all methods in class or: \n"+
		"ShowMethods qualified.class.name word\n"+
		"To search for methods involving 'word'";

	/**
	 * @param args
	 *这个示例和上一个ShowMethods输出差不多，只不过它去掉了像"java.lang"这样的限定词，看着舒服些
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		if(args.length < 1)
		{
			System.out.println(usage);
			System.exit(0);
		}
		try
		{
			Class c = Class.forName(args[0]);
			Method[] methods = c.getMethods();
			Constructor[] ctor = c.getConstructors();
			
			String[] n = new String[methods.length + ctor.length];
			for(int i = 0; i < methods.length; i++)
			{
				String s = methods[i].toString();
				n[i] = StripQualifiers.strip(s);
			}
			
			for(int i = 0; i < ctor.length; i++)
			{
				String s = ctor[i].toString();
				n[i + methods.length] = StripQualifiers.strip(s);
			}
			
			if(args.length == 1)
			{
				for(int i = 0; i < n.length; i++)
				{
					System.out.println(n[i]);//注意这个也会打印基类的方法
				}
			}
			else
			{
				//这一段的意义第一个参数是类名，第二个参数是要查找到方法名关键字
				for(int i = 0; i < n.length; i++)
				{
					if(n[i].indexOf(args[1]) != -1)
						System.out.println(n[i]);
				}
			}
		}catch (ClassNotFoundException e) 
		{
		// TODO: handle exception
			System.err.println("no such class: " + e);
	
		}


	}

}

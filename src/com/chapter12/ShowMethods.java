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
	 * ��ӡһ�������еķ��������������еķ���
	 * ִ���������Ҫ��run configuration��ָ������
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
					System.out.println(methods[i]);//ע�����Ҳ���ӡ����ķ���
				}
				for(int i = 0; i < ctor.length; i++)
				{
					System.out.println(ctor[i]);
				}
			}
			else
			{
				//��һ�ε������һ���������������ڶ���������Ҫ���ҵ��������ؼ���
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

package com.bruceeckel.util;

//ģ��C�е�Assert
public class Assert 
{
	private static void perr(String msg)
	{
		System.out.println(msg);
	}
	
	public final static void is_true(boolean exp)
	{
		if(!exp) perr("Assertion failed");
	}
	
	public final static void is_false(boolean exp)
	{
		if(exp) perr("Assertion failed");
		
	}
}

package com.chapter10;

//重新抛出异常，注意区别fillInStackTrace
public class Rethrowing 
{

	public static void f() throws Exception
	{
		System.out.println("originating exception in f");
		throw new Exception("thrown from f");
	}
	
	public static void g() throws Throwable
	{
		try 
		{
			f();
		} 
		catch (Exception e) 
		{
			System.out.println("inside g, e.printStackTrace");
			e.printStackTrace(System.err);
			//throw e; //重新抛出异常
			throw e.fillInStackTrace();
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Throwable
	{
		// TODO Auto-generated method stub
		try 
		{
			g();
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			System.out.println("catch in main, e.printtrackStack");
			e.printStackTrace(System.err);
			
		}

	}

}

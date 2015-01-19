package com.chapter10;

public class ExceptionMethods 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		try 
		{
			throw new Exception("this is my exception");
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			System.err.println(e.getMessage());
			System.err.println(e.getLocalizedMessage());
			System.err.println(e);
			e.printStackTrace(System.err);
		}

	}

}

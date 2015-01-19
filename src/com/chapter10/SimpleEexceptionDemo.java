package com.chapter10;



class SimpleException extends Exception
{
	
}

public class SimpleEexceptionDemo 
{

	public void f() throws SimpleException
	{
		System.out.println("throw a simple exception");
		throw new SimpleException();
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		SimpleEexceptionDemo sed = new SimpleEexceptionDemo();
		try {
			sed.f();
			
		} catch (SimpleException e) 
		{
			// TODO: handle exception
			System.err.println("catch it");
		}


	}

}

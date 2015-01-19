package com.chapter10;

import java.io.*;

class InputFile
{
	private BufferedReader in;
	public InputFile(String fileName) throws Exception
	{
		try 
		{
			in = new BufferedReader(new FileReader(fileName));
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println("file not open!");
			throw e;
		}
		catch (Exception e) 
		{
			//all other exception
			try 
			{
				in.close();
			} 
			catch (Exception e2) 
			{
				// TODO: handle exception
				System.err.println("close file failed!");
			}
			throw e;
			
		}
		finally
		{
			// don't close in here
		}
	}
	
	String getLine()
	{
		String s;
		try 
		{
			s = in.readLine();
		} 
		catch (IOException e) 
		{
			System.err.println("read line failed!");
			s = "failed";
		}
		System.out.println("test, test, after catch!");
		return s;
	}
	
	void cleanup()
	{
		try 
		{
			in.close();
		} 
		catch (Exception e) 
		{
			System.err.println("in cleanup close failed!");
		}
	}
}

public class Cleanup 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		try 
		{
			InputFile in = new InputFile("Cleanup.java");
			String s;
			int i = 1;
			while((s = in.getLine()) != null)
			{
				System.out.println("" + (i++) + s);
			}
			in.cleanup();
		} 
		catch (Exception e) 
		{
			System.out.println("catch in main, ");
			e.printStackTrace(System.err);
		}
		
		
		

	}

}

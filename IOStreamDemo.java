package com.chapter11;

import java.io.*;

public class IOStreamDemo 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new FileReader("IOStreamDemo.java"));
		String s, s2 = new String();
		
		while((s = in.readLine()) != null)
		{
			s2 += s + "\n";
		}
		in.close();
		
		//input from standard.
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("input a line:");
		System.out.println(stdin.readLine());
		
		//input from memory
		StringReader in2 = new StringReader(s2);
		int c;
		while((c = in2.read()) != -1)
			System.out.print((char)c);
		
		//format memory input
		//×Ö½ÚÁ÷, byte
		try 
		{
			DataInputStream in3 = new DataInputStream(new ByteArrayInputStream(s2.getBytes()));
			while(true)
			{
				System.out.println((char)in3.readByte());
			}
		} 
		catch (EOFException e) 
		{
			// TODO: handle exception
			System.err.println("end of stream");
		}
		
		//file output
		try 
		{
			BufferedReader in4 = new BufferedReader(new StringReader(s2));
			PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter("demo.out")));
			PrintWriter out2 = new PrintWriter(new File("demo1.out"));
			PrintWriter out3 = new PrintWriter(new FileWriter("demo3.out"));
			
			int lineNumber = 1;
			while ((s = in4.readLine()) != null) 
			{
				out1.println(lineNumber++ + ":" + s);
			}
			out1.close();
			
		} 
		catch (EOFException e) 
		{
			// TODO: handle exception
			System.err.println("end of stream");
		}
		
		//storing and recovering data
		

	}

}

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
		{
			System.out.print((char)c);
		}
		
		//format memory input
		//字节流, byte
		try 
		{
			int nCount = 0;
			DataInputStream in3 = new DataInputStream(new ByteArrayInputStream(s2.getBytes()));
			while(nCount < 30)
			{
				System.out.println((char)in3.readByte());
				//System.out.println(in3.readChar());//直接用readChar会输出乱码
				nCount++;
			}
			
			//用DataInputStream readChar()读文件
			DataInputStream in3_1 = new DataInputStream(new FileInputStream("test.txt"));
			
			while(in3_1.available() > 0)
			{
				//这里也是乱码，要把文件转成UTF-16格式的才可以
				System.out.print(in3_1.readChar());
				nCount++;
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
			//下面三种方法都可以实现同样的效果
			BufferedReader in4 = new BufferedReader(new StringReader(s2));
			PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter("demo.out")));
			PrintWriter out2 = new PrintWriter(new File("demo1.out"));
			PrintWriter out3 = new PrintWriter(new FileWriter("demo3.out"));
			
			int lineNumber = 1;
			while ((s = in4.readLine()) != null) 
			{
				out3.println(lineNumber++ + ":" + s);
			}
			out3.close();
			
		} 
		catch (EOFException e) 
		{
			// TODO: handle exception
			System.err.println("end of stream");
		}
		
		//storing and recovering data
		try 
		{
			DataOutputStream out2 = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("data.txt")));
			out2.writeDouble(3.1415);
			out2.writeChars("that is pi\n");
			out2.writeBytes("that was pi\n");
			out2.close();
			
			DataInputStream in5 = new DataInputStream(new BufferedInputStream(new FileInputStream("data.txt")));
			BufferedReader in5br = new BufferedReader(new InputStreamReader(in5));
			
			System.out.println(in5.readDouble());
			System.out.println(in5br.readLine());//也读出来了
			System.out.println(in5br.readLine()); // the one created with writebytes is ok.
		} 
		catch (EOFException e) 
		{
			// TODO: handle exception
		}
		

	}

}

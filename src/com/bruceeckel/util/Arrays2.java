package com.bruceeckel.util;

import java.util.*;

public class Arrays2 
{

	private static void start(int from, int to, int length)
	{
		if (from != 0 || to != length) 
		{
			System.out.print("[" + from + ":" + to + "]");
		}
		System.out.print("(");
	}
	
	private static void end()
	{
		System.out.print(")");
		System.out.println();//回车
	}
	
	//////////////////////////////////////////////////////////
	public static void print(Object[] a)
	{
		print(a, 0, a.length);
	}
	
	public static void print(Object[] a, int from, int to)
	{
		start(from, to, a.length);
		for (int i = from; i < to; i++) 
		{
			System.out.print(a[i]);
			if (i < (to - 1)) 
			{
				System.out.print(", ");
			}
		}
		
		end();
	}
	
	public static void print(String msg, Object[] a)
	{
		System.out.print(msg + " ");
		print(a, 0, a.length);
	}
	//////////////////////////////////////////////////////////
	public static void print(boolean[] a)
	{
		print(a, 0, a.length);
	}
	
	public static void print(boolean[] a, int from, int to)
	{
		start(from, to, a.length);
		for (int i = from; i < to; i++) 
		{
			System.out.print(a[i]);
			if (i < (to - 1)) 
			{
				System.out.print(", ");
			}
		}
		
		end();
	}
	
	public static void print(String msg, boolean[] a)
	{
		System.out.print(msg + " ");
		print(a, 0, a.length);
	}
	//////////////////////////////////////////////////////////
	public static void print(byte[] a)
	{
		print(a, 0, a.length);
	}
	
	public static void print(byte[] a, int from, int to)
	{
		start(from, to, a.length);
		for (int i = from; i < to; i++) 
		{
			System.out.print(a[i]);
			if (i < (to - 1)) 
			{
				System.out.print(", ");
			}
		}
		
		end();
	}
	
	public static void print(String msg, byte[] a)
	{
		System.out.print(msg + " ");
		print(a, 0, a.length);
	}
	//////////////////////////////////////////////////////////
	public static void print(char[] a)
	{
		print(a, 0, a.length);
	}
	
	public static void print(char[] a, int from, int to)
	{
		start(from, to, a.length);
		for (int i = from; i < to; i++) 
		{
			System.out.print(a[i]);
			if (i < (to - 1)) 
			{
				System.out.print(", ");
			}
		}
		
		end();
	}
	
	public static void print(String msg, char[] a)
	{
		System.out.print(msg + " ");
		print(a, 0, a.length);
	}
	//////////////////////////////////////////////////////////
	public static void print(short[] a)
	{
		print(a, 0, a.length);
	}
	
	public static void print(short[] a, int from, int to)
	{
		start(from, to, a.length);
		for (int i = from; i < to; i++) 
		{
			System.out.print(a[i]);
			if (i < (to - 1)) 
			{
				System.out.print(", ");
			}
		}
		
		end();
	}
	
	public static void print(String msg, short[] a)
	{
		System.out.print(msg + " ");
		print(a, 0, a.length);
	}
	//////////////////////////////////////////////////////////
	public static void print(int[] a)
	{
		print(a, 0, a.length);
	}
	
	public static void print(int[] a, int from, int to)
	{
		start(from, to, a.length);
		for (int i = from; i < to; i++) 
		{
			System.out.print(a[i]);
			if (i < (to - 1)) 
			{
				System.out.print(", ");
			}
		}
		
		end();
	}
	
	public static void print(String msg, int[] a)
	{
		System.out.print(msg + " ");
		print(a, 0, a.length);
	}
	//////////////////////////////////////////////////////////
	public static void fill(Object[] a, Generator gen)
	{
		fill(a, 0, a.length, gen);
	}
	public static void fill(Object[] a, int from, int to, Generator gen)
	{
		for (int i = from; i < to; i++) 
		{
			a[i] = gen.next();
		}
	}
	
	public static void fill(boolean[] a, BooleanGenerator gen)
	{
		fill(a, 0, a.length, gen);
	}
	public static void fill(boolean[] a, int from, int to, BooleanGenerator gen)
	{
		for (int i = from; i < to; i++) 
		{
			a[i] = gen.next();
		}
	}
	
	public static void fill(byte[] a, ByteGenerator gen)
	{
		fill(a, 0, a.length, gen);
	}
	public static void fill(byte[] a, int from, int to, ByteGenerator gen)
	{
		for (int i = from; i < to; i++) 
		{
			a[i] = gen.next();
		}
	}
	
	public static void fill(char[] a, CharGenerator gen)
	{
		fill(a, 0, a.length, gen);
	}
	public static void fill(char[] a, int from, int to, CharGenerator gen)
	{
		for (int i = from; i < to; i++) 
		{
			a[i] = gen.next();
		}
	}
	
	public static void fill(int[] a, IntGenerator gen)
	{
		fill(a, 0, a.length, gen);
	}
	public static void fill(int[] a, int from, int to, IntGenerator gen)
	{
		for (int i = from; i < to; i++) 
		{
			a[i] = gen.next();
		}
	}
	
	public static void fill(float[] a, FloatGenerator gen)
	{
		fill(a, 0, a.length, gen);
	}
	public static void fill(float[] a, int from, int to, FloatGenerator gen)
	{
		for (int i = from; i < to; i++) 
		{
			a[i] = gen.next();
		}
	}
	
	public static void fill(double[] a, DoubleGenerator gen)
	{
		fill(a, 0, a.length, gen);
	}
	public static void fill(double[] a, int from, int to, DoubleGenerator gen)
	{
		for (int i = from; i < to; i++) 
		{
			a[i] = gen.next();
		}
	}
	//////////////////////////////////////////////////////////
	private static Random r = new Random();
	
	public static class RandBooleanGenerator implements BooleanGenerator
	{
		//注意这里, 
		public boolean next()
		{
			return r.nextBoolean();
		}
	}
	
	public static class RandByteGenerator implements ByteGenerator
	{
		public byte next()
		{
			return (byte)(r.nextInt());
		}
	}
	
	static String ssSource = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz";
	
	static char[] src = ssSource.toCharArray();
	public static class RandCharGenerator implements CharGenerator
	{
		
		public char next()
		{
			int nPos = Math.abs(r.nextInt());
			return src[nPos%(src.length)];
		}
	}
	
	public static class RandStringGenerator implements Generator
	{
		private int len;
		private RandCharGenerator charGenerator = new RandCharGenerator();
		
		public RandStringGenerator(int length)
		{
			len = length;
		}
		
		public Object next()
		{
			char[] buf = new char[len];
			for (int i = 0; i < buf.length; i++) 
			{
				buf[i] = charGenerator.next();
			}
			return new String(buf);
		}
	}
	
	public static class RandShortGenerator implements ShortGenerator
	{
		public short next()
		{
			return (short)(r.nextInt());
		}
	}
	
	public static class RandIntGenerator implements IntGenerator
	{
		private int mod;
		public RandIntGenerator()
		{
			mod = 1000;
		}
		public RandIntGenerator(int module)
		{
			mod = module;
		}
		
		public int next()
		{
			return (r.nextInt()%mod);
		}
	}
	
	
}


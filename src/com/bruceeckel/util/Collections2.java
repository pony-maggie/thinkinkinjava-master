package com.bruceeckel.util;

import java.util.*;

public class Collections2 
{

	public static void fill(Collection c, Generator gen, int nCount)
	{
		for(int i = 0; i < nCount; i++)
		{
			c.add(gen.next());
		}
	}
	
	public static void fill(Map m, MapGenerator gen, int nCount)
	{
		for(int i = 0; i < nCount; i++)
		{
			Pair p = gen.next();
			m.put(p.key, p.value);
		}
	}
	
	public static class RandStringPairGenerator implements MapGenerator
	{
		private Arrays2.RandStringGenerator gen;
		public RandStringPairGenerator(int len)
		{
			gen = new Arrays2.RandStringGenerator(len);
		}
		
		public Pair next()
		{
			return new Pair(gen.next(), gen.next());
		}
	}
	
	
}

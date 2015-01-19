package com.chapter9;

import java.util.*;

//学习使用comparable接口

class MyType implements Comparable<MyType>
{
	private int i;
	public MyType(int n)
	{
		i = n;
	}
	
	public boolean equals(Object a)
	{
		return ((a instanceof MyType) &&(i == ((MyType)a).i));
	}
	
	public int hashCode()
	{
		return i;
	}
	
	public String toString()
	{
		return i + " ";
	}
	
	public int compareTo(MyType o)
	{
		int i2 = o.i;
		return (i2 < i?-1:(i2==i?0:1));
	}
}

public class Set2 
{
	public static Set<MyType> fill(Set<MyType> a, int size)
	{
		for(int i = 0; i < size; i++)
		{
			a.add(new MyType(i));
		}
		return a;
	}
	
	public static void test(Set<MyType> a)
	{
		fill(a, 10);
		fill(a, 10);
		fill(a, 10);
		
		a.addAll(fill(new TreeSet<MyType>(), 10));
		System.out.println(a);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		test(new TreeSet<MyType>());
		test(new HashSet<MyType>());

	}

}

package com.chapter3;

class Value
{
	int i;
	
	public int hashCode()
	{
		return i;
	}
	public boolean equals(Object oo)
	{
		return (i == ((Value)oo).i);
	}
}

public class Equivalence 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Integer n1 = new Integer(47);
		Integer n2 = new Integer(47);
		
		System.out.println(n1 == n2);
		System.out.println(n1.equals(n2));
		
		Value v1 = new Value();
		Value v2 = new Value();
		v1.i = v2.i = 100;
		System.out.println(v1.equals(v2));

	}

}

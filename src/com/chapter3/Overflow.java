package com.chapter3;

public class Overflow 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{

		int big = 0x7fffffff; //max int value
		System.out.println("big = " + big);
		int bigger = big * 4;
		System.out.println("bigger = " + bigger);
		
		long reallyBig = 0x7fffffffL;
		System.out.println("reallyBig = " + reallyBig);
		long reallyBigger = reallyBig * 4;
		System.out.println("reallyBigger = " + reallyBigger);
		
	}

}

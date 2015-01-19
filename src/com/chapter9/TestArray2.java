package com.chapter9;


import com.bruceeckel.util.*;

public class TestArray2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int nSize = 6;
		boolean[] a1 = new boolean[nSize];
		byte[] a2 = new byte[nSize];
		char[] a3 = new char[nSize];
		int[] a5 = new int[nSize];
		String[] a9 = new String[nSize];
		
		Arrays2.fill(a1, new Arrays2.RandBooleanGenerator());
		Arrays2.print(a1);
		Arrays2.print("a1 = ", a1);
		Arrays2.print(a1, nSize/3, (nSize/3 + nSize/3));
		
		Arrays2.fill(a2, new Arrays2.RandByteGenerator());
		Arrays2.print(a2);
		Arrays2.print("a2 = ", a2);
		Arrays2.print(a2, nSize/3, (nSize/3 + nSize/3));
		
		Arrays2.fill(a3, new Arrays2.RandCharGenerator());
		Arrays2.print(a3);
		Arrays2.print("a3 = ", a3);
		Arrays2.print(a3, nSize/3, (nSize/3 + nSize/3));
		
		Arrays2.fill(a5, new Arrays2.RandIntGenerator());
		Arrays2.print(a5);
		Arrays2.print("a5 = ", a5);
		Arrays2.print(a5, nSize/3, (nSize/3 + nSize/3));
		
		Arrays2.fill(a9, new Arrays2.RandStringGenerator(7));
		Arrays2.print(a9);
		Arrays2.print("a9 = ", a9);
		Arrays2.print(a9, nSize/3, (nSize/3 + nSize/3));
		
		
		

	}

}

package com.chapter11;
import java.io.*;
import java.util.*;

import com.bruceeckel.util.*;

public class DirList 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		File path = new File(".");
		String[] list;
		list = path.list();
		
		Arrays.sort(list, new AlphabeticComparator());
		
		for (int i = 0; i < list.length; i++) 
		{
			System.out.println(list[i]);
		}

	}

}

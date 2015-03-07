package com.chapter4;

import com.bruceeckel.util.*;

//了解初始化的顺序

class Mug
{
	Mug(int maker)
	{
		Tool.rintln("Mug(" + maker + ")");
		
	}
}
public class Mugs 
{
	Mug c1;
	Mug c2;
	
	{
		c1 = new Mug(1);
		c2 = new Mug(2);
	}
	
	Mugs()
	{
		System.out.println("Mugs");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mugs x = new Mugs();
	}

}

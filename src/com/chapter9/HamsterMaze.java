package com.chapter9;

import java.awt.print.*;
import java.util.*;



class Hamster
{
	private int hamsterNumber;
	public Hamster(int i)
	{
		hamsterNumber = i;
	}
	
	public String toString()
	{
		return "this is hamster number #" + hamsterNumber;
	}
	
}

class Printer
{
	public static void printall(Iterator<Hamster> e)
	{
		while(e.hasNext())
		{
			System.out.println(e.next());
		}
	}
}


public class HamsterMaze 
{

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ArrayList<Hamster> v = new ArrayList<Hamster>();
		
		for(int i = 0; i < 3; i++)
		{
			v.add(new Hamster(i));
		}
		
		Printer.printall(v.iterator());
		

	}

}

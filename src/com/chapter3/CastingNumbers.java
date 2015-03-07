package com.chapter3;

public class CastingNumbers 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		for(int i = 0; i < 100; i++)
		{
			char c = (char)(Math.random()*26 + 'a');
			System.out.print(c + " ");
			
			
		}
		
		System.out.println("");
		
		double above = 0.7;
		double below = 0.4;
		
		System.out.println("above: " + above);
		System.out.println("below: " + below);
		
		System.out.println("(int)above: " + (int)above);
		System.out.println("(int)below: " + (int)below);
		
		System.out.println("(char)('a' + above): " + (char)('a' + above));
		System.out.println("(char)('a' + below): " + (char)('a' + below));

	}

}

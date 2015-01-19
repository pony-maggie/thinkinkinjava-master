package com.chapter12;

import java.util.*;


public class PetCount 
{

	static String[] typeNames = 
	{
		"Pet", "Dog", "Pug", "Cat", "Rodent", "Gerbil", "Hamster"
	};
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		ArrayList pets = new ArrayList();
		try
		{
			Class[] petTypes = 
			{
					//注意这里要改一下，因为有包在，要用完整路径,否则会找不到类
					Class.forName("com.chapter12.Dog"),
					Class.forName("com.chapter12.Pug"),
					Class.forName("com.chapter12.Cat"),
					Class.forName("com.chapter12.Rodent"),
					Class.forName("com.chapter12.Gerbil"),
					Class.forName("com.chapter12.Hamster"),
					
			};
			
			for(int i = 0; i < 15; i++)
			{
				//动态加载类并实例化,
				pets.add(petTypes[(int)(Math.random()*petTypes.length)].newInstance());
			}
			
			
		}
		catch (InstantiationException e) 
		{
			// TODO: handle exception
			System.err.println("cannot instantiate");
			throw e;
		}
		catch (IllegalAccessException e) 
		{
			// TODO: handle exception
			System.err.println("cannot instantiate");
			throw e;
			
			
		}
		catch (ClassNotFoundException e) 
		{
			// TODO: handle exception
			System.err.println("cannot find class");
			throw e;
			
			
		}
		
		HashMap hashMap =new HashMap();
		for(int i = 0; i < typeNames.length; i++)
		{
			hashMap.put(typeNames[i], new Counter());
		}
		
		for(int i = 0; i < pets.size(); i++)
		{
			Object o = pets.get(i);
			if(o instanceof Pet) ((Counter)hashMap.get("Pet")).i++;
			if(o instanceof Dog) ((Counter)hashMap.get("Dog")).i++;
			if(o instanceof Pug) ((Counter)hashMap.get("Pug")).i++;
			if(o instanceof Cat) ((Counter)hashMap.get("Cat")).i++;
			if(o instanceof Rodent) ((Counter)hashMap.get("Rodent")).i++;
			if(o instanceof Gerbil) ((Counter)hashMap.get("Gerbil")).i++;
			if(o instanceof Hamster) ((Counter)hashMap.get("Hamster")).i++;

		}
		
		for(int i = 0; i < pets.size(); i++)
		{
			System.out.println(pets.get(i).getClass());//会调用toString
		}
		
		for(int i = 0; i < typeNames.length; i++)
		{
			System.out.println(typeNames[i] + " quanlity:" + ((Counter)hashMap.get(typeNames[i])).i);
		}
		

	}

}

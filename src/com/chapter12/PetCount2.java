package com.chapter12;

import java.util.*;

public class PetCount2 
{
	/**
	 * @param args
	 * 1 获取类引用的方式变了, xxx.class
	 * 2 petTypes初始化不用放在try块里了，是因为如果类不存在，xx.class可以在编译期间发现错误，不用等到运行时
	 * 所以，ClassNotFoundException这个异常也就不用了
	 * 3 typeNames这个变量不存了，直接用petTypes类名转化的字符串
	 * 4 最后输出结果那里用了迭代器
	 */
	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		ArrayList pets = new ArrayList();
		
		Class[] petTypes = 
		{
				Pet.class,
				Pug.class,
				Cat.class,
				Rodent.class,
				Gerbil.class,
				Hamster.class,
				
		};
		
		try
		{
			
			
			for(int i = 0; i < 15; i++)
			{
				int rnd = 1 + (int)((Math.random()*(petTypes.length-1)));
				
				//动态加载类并实例化,
				pets.add(petTypes[rnd].newInstance());
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
		
		HashMap hashMap =new HashMap();
		for(int i = 0; i < petTypes.length; i++)
		{
			//注意区分下面几个获取的名字区别
			//Converts the object to a string. The string representation is the string "class" or "interface", 
			//followed by a space, and then by the fully qualified name of the class in the format returned by getName. 
			//If this Class object represents a primitive type, this method returns the name of the primitive type. 
			//If this Class object represents void this method returns "void". 
			
			String strPetName = petTypes[i].toString();//"class com.chapter12.Pet"
			String strPetName2 = petTypes[i].getName();//"com.chapter12.Pet"
			
			//调用object的toString方法,返回类名+@hashCode
			hashMap.put(strPetName, new Counter());
		}
		
		for(int i = 0; i < pets.size(); i++)
		{
			Object o = pets.get(i);
			if(o instanceof Pet) ((Counter)hashMap.get("class com.chapter12.Pet")).i++;
			if(o instanceof Dog) ((Counter)hashMap.get("class com.chapter12.Dog")).i++;
			if(o instanceof Pug) ((Counter)hashMap.get("class com.chapter12.Pug")).i++;
			if(o instanceof Cat) ((Counter)hashMap.get("class com.chapter12.Cat")).i++;
			if(o instanceof Rodent) ((Counter)hashMap.get("class com.chapter12.Rodent")).i++;
			if(o instanceof Gerbil) ((Counter)hashMap.get("class com.chapter12.Gerbil")).i++;
			if(o instanceof Hamster) ((Counter)hashMap.get("class com.chapter12.Hamster")).i++;

		}
		
		for(int i = 0; i < pets.size(); i++)
		{
			System.out.println(pets.get(i).getClass());//会调用toString
		}
		
		Iterator keys = hashMap.keySet().iterator();
		while(keys.hasNext())
		{
			String name = (String)keys.next();//注意这里要强制转换
			Counter cn = (Counter)hashMap.get(name);
			System.out.println(name + " quanlity:" + cn.i);
		}
	}

}

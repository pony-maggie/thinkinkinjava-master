package com.chapter12;

import java.util.*;

public class PetCount2 
{
	/**
	 * @param args
	 * 1 ��ȡ�����õķ�ʽ����, xxx.class
	 * 2 petTypes��ʼ�����÷���try�����ˣ�����Ϊ����಻���ڣ�xx.class�����ڱ����ڼ䷢�ִ��󣬲��õȵ�����ʱ
	 * ���ԣ�ClassNotFoundException����쳣Ҳ�Ͳ�����
	 * 3 typeNames������������ˣ�ֱ����petTypes����ת�����ַ���
	 * 4 ����������������˵�����
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
				
				//��̬�����ಢʵ����,
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
			//ע���������漸����ȡ����������
			//Converts the object to a string. The string representation is the string "class" or "interface", 
			//followed by a space, and then by the fully qualified name of the class in the format returned by getName. 
			//If this Class object represents a primitive type, this method returns the name of the primitive type. 
			//If this Class object represents void this method returns "void". 
			
			String strPetName = petTypes[i].toString();//"class com.chapter12.Pet"
			String strPetName2 = petTypes[i].getName();//"com.chapter12.Pet"
			
			//����object��toString����,��������+@hashCode
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
			System.out.println(pets.get(i).getClass());//�����toString
		}
		
		Iterator keys = hashMap.keySet().iterator();
		while(keys.hasNext())
		{
			String name = (String)keys.next();//ע������Ҫǿ��ת��
			Counter cn = (Counter)hashMap.get(name);
			System.out.println(name + " quanlity:" + cn.i);
		}
	}

}

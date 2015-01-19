package com.chapter12;

//testing class Class��һЩ����

interface HasBatteries {}
interface WaterProof {}
interface ShootsThings {}

class Toy 
{
	Toy()
	{
		
	}
	Toy(int i)
	{
		
	}
}

class FuncyToy extends Toy implements HasBatteries,WaterProof,ShootsThings
{
	FuncyToy()
	{
		super(1);
	}
}

public class ToyTest 
{

	static void printInfo(Class cc)
	{
		System.out.println("Class name: " + cc.getName() + " is interface ? [" +
				cc.isInterface() +"]");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		Class c = null;
		try 
		{
			c = Class.forName("com.chapter12.FuncyToy");
		} catch (ClassNotFoundException e) 
		{
			// TODO: handle exception
			System.out.println("can not find fancyToy");
			throw e;
		}
		
		printInfo(c);
		
		Class[] faces = c.getInterfaces();//�ܻ�ȡ��ǰ�����ʵ�������нӿ�
		for(int i = 0; i < faces.length; i++)
		{
			printInfo(faces[i]);
		}
		
		Class cy = c.getSuperclass();
		Object ooObject = null;
		
		try 
		{
			ooObject = cy.newInstance();//���︳ֵToy��ʵ��
		} catch (InstantiationException e) 
		{
			// TODO: handle exception
			System.out.println("can not Instantia");
			throw e;
		}
		catch (IllegalAccessException e) 
		{
			// TODO: handle exception
			System.out.println("can access");
			throw e;
		}
		printInfo(ooObject.getClass());

	}

}

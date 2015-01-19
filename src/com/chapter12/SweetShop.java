package com.chapter12;

//学习class类的原理, 主要是静态类forName的用法
//还要学习的一点就是，类对象只在被用到的时候才被装载到内存.

/*
 * 在运行期间，如果我们要产生某个类的对象，Java虚拟机(JVM)会检查该类型的Class对象是否已被加载。
 * 如果没有被加载，JVM会根据类的名称找到.class文件并加载它。一旦某个类型的Class对象已被加载到内存，就可以用它来产生该类型的所有对象
 */

class Candy
{
	//静态域的初始始在类开始加载时就执行, 比构造函数还要先执行。
	static
	{
		System.out.println("loading candy");
	}
	public Candy()
	{
		System.out.println("candy constructor");
	}
}

class Gum
{
	static
	{
		System.out.println("loading Gum");
	}
}

class Cookie
{
	static
	{
		System.out.println("loading Cookie");
	}
}

public class SweetShop 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("inside main");
		new Candy();
		System.out.println("after creating candy");
		
		try 
		{
			Class.forName("com.chapter12.Gum");// get the reference to the class object
			System.out.println(Class.forName("com.chapter12.Gum"));
			System.out.println(Gum.class);//这种方式也可以获得类对象的引用
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO: handle exception
			e.printStackTrace(System.err);
		}
		
		System.out.println("after class.forname(\"Gum\")");//注意这个转义字符的使用
		new Cookie();
		System.out.println("after creating Cookie");
		
		
		

	}

}

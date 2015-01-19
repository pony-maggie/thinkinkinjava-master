package com.chapter12;

//ѧϰclass���ԭ��, ��Ҫ�Ǿ�̬��forName���÷�
//��Ҫѧϰ��һ����ǣ������ֻ�ڱ��õ���ʱ��ű�װ�ص��ڴ�.

/*
 * �������ڼ䣬�������Ҫ����ĳ����Ķ���Java�����(JVM)��������͵�Class�����Ƿ��ѱ����ء�
 * ���û�б����أ�JVM�������������ҵ�.class�ļ�����������һ��ĳ�����͵�Class�����ѱ����ص��ڴ棬�Ϳ������������������͵����ж���
 */

class Candy
{
	//��̬��ĳ�ʼʼ���࿪ʼ����ʱ��ִ��, �ȹ��캯����Ҫ��ִ�С�
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
			System.out.println(Gum.class);//���ַ�ʽҲ���Ի������������
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO: handle exception
			e.printStackTrace(System.err);
		}
		
		System.out.println("after class.forname(\"Gum\")");//ע�����ת���ַ���ʹ��
		new Cookie();
		System.out.println("after creating Cookie");
		
		
		

	}

}

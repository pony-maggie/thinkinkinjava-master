package com.chapter12;

//the difference between instanceof and class

class Base
{
	
}

class Derived extends Base {}

public class FamilyVsExactType 
{

	static void test(Object x)
	{
		System.out.println("Testing x of type " + x.getClass());
		System.out.println("x instance of base " + (x instanceof Base));
		System.out.println("x instance of Derived " + (x instanceof Derived));
		System.out.println("Base.isinstace (x) " + Base.class.isInstance(x));
		System.out.println("Derived.isinstace (x) " + Derived.class.isInstance(x));
		System.out.println("x.getClass() == Base.class " + (x.getClass() == Base.class));
		System.out.println("x.getClass() == Derived.class " + (x.getClass() == Derived.class));
		System.out.println("x.getClass.equals(Base.class) " + (x.getClass().equals(Base.class)));
		System.out.println("x.getClass.equals(Derived.class) " + (x.getClass().equals(Derived.class)));
		
	}
	/**
	 * @param args
	 * ������:
	 * Testing x of typeclass com.chapter12.Base //���������⣬���ǵ�ǰ�������
		x instance of base true //Base���ʵ��
		x instance of Derived false //��Ȼ����Derived���ʵ��
		Base.isinstace (x) true //isInstance �� instance of��һ����Ч��,ֻ�������÷���һ��
		Derived.isinstace (x) false
		x.getClass() == Base.class true
		x.getClass() == Derived.class false
		x.getClass.equals(Base.class) true
		x.getClass.equals(Derived.class) false
		
		
		
		Testing x of typeclass com.chapter12.Derived
		x instance of base true
		x instance of Derived true //ע������
		Base.isinstace (x) true
		Derived.isinstace (x) true //ע������
		x.getClass() == Base.class false
		x.getClass() == Derived.class true
		x.getClass.equals(Base.class) false
		x.getClass.equals(Derived.class) true
		
		���￴��, getClass��ȡ���Ǿ�ȷ�����ͣ���ʹ�ǻ����������Ҳƥ�䲻�ϣ���instance of�Ǳ������Ƿ������������Ļ����ʵ����
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		test(new Base());
		test(new Derived());

	}

}

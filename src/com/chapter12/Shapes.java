package com.chapter12;

import java.util.*;


class Shape
{
	void draw()
	{
		System.out.println(this + ".draw()");
	}
}

class Circle extends Shape
{
	public String toString()
	{
		return "circle";
	}
}

class Square extends Shape
{
	public String toString()
	{
		return "square";
	}
}


public class Shapes 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ArrayList<Shape> arrayList = new ArrayList<Shape>();
		
		arrayList.add(new Circle());
		arrayList.add(new Square());
		
		Iterator<Shape> e = arrayList.iterator();
		while(e.hasNext())
		{
			//e.next().draw(); Ҳ��ͬ����Ч������Ϊǰ���Ѿ��ڼ�������ָ����<Shape>������������Բ���ǿ��ת��
			((Shape)e.next()).draw();
		}
	}

}

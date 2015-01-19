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
			//e.next().draw(); 也是同样的效果，因为前面已经在尖括号里指明了<Shape>，所以这里可以不用强制转换
			((Shape)e.next()).draw();
		}
	}

}

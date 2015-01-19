package com.chapter12;

import java.util.*;

//与Shapes的区别是ArrayList并没有指明实际类型，所以add的参数是Object
//输出结果是一样的。

public class Shapes2 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ArrayList arrayList = new ArrayList();
		
		arrayList.add(new Circle());
		arrayList.add(new Square());
		
		Iterator e = arrayList.iterator();
		while(e.hasNext())
		{
			//e.next().draw();这里就不能直接调用draw了，要强制转换
			//这个Shape的强制转换，其实是RTTI,也就是运行时检查的,这一点跟C++是不一样的。
			((Shape)e.next()).draw();
		}

	}

}

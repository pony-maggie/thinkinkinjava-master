package com.chapter12;

import java.util.*;

//��Shapes��������ArrayList��û��ָ��ʵ�����ͣ�����add�Ĳ�����Object
//��������һ���ġ�

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
			//e.next().draw();����Ͳ���ֱ�ӵ���draw�ˣ�Ҫǿ��ת��
			//���Shape��ǿ��ת������ʵ��RTTI,Ҳ��������ʱ����,��һ���C++�ǲ�һ���ġ�
			((Shape)e.next()).draw();
		}

	}

}

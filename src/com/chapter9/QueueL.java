package com.chapter9;

import java.util.*;


//��linkedlistʵ��һ������
public class QueueL 
{
	private LinkedList list = new LinkedList();

	public void put(Object a)
	{
		list.addFirst(a);
	}
	
	public Object get()
	{
		return list.removeLast();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}

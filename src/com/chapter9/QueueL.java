package com.chapter9;

import java.util.*;


//用linkedlist实现一个队列
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

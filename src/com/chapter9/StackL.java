package com.chapter9;
import java.util.*;

import com.bruceeckel.*;


//用linklist实现一个栈结构
public class StackL
{

	private LinkedList list = new LinkedList();
	
	public void Push(Object a)
	{
		list.addFirst(a);
	}
	
	public Object Top()
	{
		return list.getFirst();
	}
	
	public Object Pop()
	{
		return list.removeFirst();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		StackL stack = new StackL();
		
		stack.Push(new String("aaa"));
		stack.Push(new String("bbb"));
		stack.Push(new String("ccc"));
		
		System.out.println(stack.Top());
		System.out.println(stack.Top());
		System.out.println(stack.Pop());
		System.out.println(stack.Pop());

	}

}

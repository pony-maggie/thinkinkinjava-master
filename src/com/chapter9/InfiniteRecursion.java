package com.chapter9;

import java.util.*;

//��δ�ӡ�������ĵ�ַ
public class InfiniteRecursion {

	public String toString()
	{
		//ע�����ﲻ��this, �������ѭ��
		//��InfiniteRecursionֱ�Ӽ̳���Object����������toString����Ψһ�Ĺ��ܾ��Ǵ�ӡ����ĵ�ַ
		return "InfiniteRecursion address:" + super.toString() + "\n";
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ArrayList<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
		for(int i = 0; i < 3; i++)
		{
			v.add(new InfiniteRecursion());
		}
		System.out.println(v);
		
		
	}

}

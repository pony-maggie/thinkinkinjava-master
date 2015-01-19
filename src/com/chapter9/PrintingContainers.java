package com.chapter9;
import java.util.*;



public class PrintingContainers 
{

	/*
	 * ������ָ������(<E>)Ҳ�ǿ��Ե�, ��������д:
	 * static Collection<String> fill(Collection<String> c)
	 * ��������Ԫ�ر����Լ������� ��һ������ת���� object �������Ծ�ʧȥ�ˣ��������ٽ���ת������ԭ�������Ͳſ���
	 * �Ӿ���Ҳ���Կ������������һЩ.
	 * ���⣬ע��Hahset��������������һ��dog.
	 */
	//������ָ������(<E>)Ҳ�ǿ��Ե�
	static Collection fill(Collection c)
	{
		c.add("dog");
		c.add("dog");
		c.add("cat");
		return c;
	}
	
	static Map fill(Map m)
	{
		m.put("dog", "bosco");
		m.put("dog", "spot");
		m.put("cat", "rags");
		return m;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println(fill(new ArrayList()));
		System.out.println(fill(new HashSet()));
		System.out.println(fill(new HashMap()));

	}

}

package com.mess;


public class ArrayTest 
{
	String s1 = new String("good");
	String[] ss1 = {"aaa"}; //string���飬ֻ��һ��Ԫ��
	
	String[] m_myArray;
	
	//string����Ϊֵ���ݣ���string���������ô��ݣ���������Ľ����"goodbbb"
	public void arrayPassTest(String s, String[] ss)
	{
		s = "bad";
		ss[0] = "bbb";
	}
	
	//���溯��Ҳ������һ����ʾ����дһ��������������ʱ����Ҫֱ�Ӷ��ڲ���Ա��ֵ���������Ͳ��ɿ���
	//���������������,���myArray��ĳ����Ա�����ı��ˣ���ô���ݵ��������Ҳ��ı�
	public void setArray(String[] newArray)
	{
		this.m_myArray = newArray;
	} 
	
	//Ӧ������д
	public void setArrayNew(String[] newArray)
	{
		if(newArray == null)
		{
			this.m_myArray = new String[0];
		}
		else
		{
			this.m_myArray = new String[newArray.length];
			System.arraycopy(newArray, 0, this.m_myArray, 0, newArray.length);
		}
	}
	/**
	 * @param args
	 * ������Ϊ��������
	 */
	public static void main(String[] args) 
	{
		ArrayTest test = new ArrayTest();
		test.arrayPassTest(test.s1, test.ss1);
		System.out.println(test.s1+test.ss1[0]);
		String[] ssNew = {"ccc", "ddd"};
		
		test.setArrayNew(ssNew);
		
		
		System.out.println(test.m_myArray[0] + test.m_myArray[1]);
		//��һ�ִ�ӡ�ķ���
		for(String s:test.m_myArray)
			System.out.println(s);

	}

}

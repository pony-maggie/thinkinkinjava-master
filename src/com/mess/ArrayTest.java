package com.mess;

//������blog
public class ArrayTest 
{
	//�������ô���, ����Ľ����"goodbbb"
	public void arrayPassTest(String s, String[] ss)
	{
		s = "bad";
		ss[0] = "bbb";
	}
	
	String[] m_myArray;
	
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
		String s1 = new String("good");
		String[] ss1 = {"aaa"}; //string���飬ֻ��һ��Ԫ��
		
		ArrayTest test = new ArrayTest();
		test.arrayPassTest(s1, ss1);
		System.out.println(s1+ss1[0]);
		
		
		String[] ssNew = {"ccc", "ddd"};
		
		test.setArrayNew(ssNew);
		
		
		System.out.println(test.m_myArray[0] + test.m_myArray[1]);
		//��һ�ִ�ӡ�ķ���
		for(String s:test.m_myArray)
			System.out.println(s);

	}

}

package com.mess;

//已整理blog
public class ArrayTest 
{
	//都是引用传递, 输出的结果是"goodbbb"
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
	
	//应该这样写
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
	 * 数组作为参数传递
	 */
	public static void main(String[] args) 
	{
		String s1 = new String("good");
		String[] ss1 = {"aaa"}; //string数组，只有一个元素
		
		ArrayTest test = new ArrayTest();
		test.arrayPassTest(s1, ss1);
		System.out.println(s1+ss1[0]);
		
		
		String[] ssNew = {"ccc", "ddd"};
		
		test.setArrayNew(ssNew);
		
		
		System.out.println(test.m_myArray[0] + test.m_myArray[1]);
		//另一种打印的方法
		for(String s:test.m_myArray)
			System.out.println(s);

	}

}

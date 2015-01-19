package com.mess;


public class ArrayTest 
{
	String s1 = new String("good");
	String[] ss1 = {"aaa"}; //string数组，只有一个元素
	
	String[] m_myArray;
	
	//string是作为值传递，而string数组是引用传递，所以输出的结果是"goodbbb"
	public void arrayPassTest(String s, String[] ss)
	{
		s = "bad";
		ss[0] = "bbb";
	}
	
	//上面函数也给我们一个提示，当写一个函数传递数组时，不要直接对内部成员赋值，否则结果就不可控了
	//比如下面这个函数,如果myArray被某个成员函数改变了，那么传递的这个数组也会改变
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
		ArrayTest test = new ArrayTest();
		test.arrayPassTest(test.s1, test.ss1);
		System.out.println(test.s1+test.ss1[0]);
		String[] ssNew = {"ccc", "ddd"};
		
		test.setArrayNew(ssNew);
		
		
		System.out.println(test.m_myArray[0] + test.m_myArray[1]);
		//另一种打印的方法
		for(String s:test.m_myArray)
			System.out.println(s);

	}

}

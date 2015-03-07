package com.mess;

public class StringTest {
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//比较两个字符串一定要用equals而不是直接用==,因为后者比较的是引用，而不实际值
		String s1 = "abd";
		String s2 = "abd";
		
		String s3 = new String("123");
		String s4 = new String("123");
		
		//如果s1和s2都是同一个字面量赋值，那么无论是用==比较，还是用equals函数比较，都会返回true
		//多个String引用指向同一个字面量时，在堆内存当中只有一个Java对象
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
		//如果调用String的构造函数给String类型的引用赋值，那么每调用一次构造函数，在堆内存当中就会生成一个String对象
		System.out.println(s3 == s4);
		System.out.println(s3.equals(s4));
		
		//另外，针对安全性比较高的数据，尽量用char[]，而不是string, 因为后者是不可更改的，直到被回收，所以容易被入侵。
		
		
		//String与StringBuilder的区别是后者可以改变，
		//因此在每次对 String 类型进行改变的时候其实都等同于生成了一个新的 String 对象，然后将指针指向新的 String 对象，所以经常改变内容的字符串最好不要用 String
		String S1 = "This is only a simple test";
		

		
		StringBuilder Sb = new StringBuilder("This is only a simple ").append("test");
		S1 += "aaa";
		
		System.out.println(S1);
		System.out.println(Sb);
		

	}

}

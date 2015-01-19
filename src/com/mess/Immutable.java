package com.mess;

public class Immutable {

	/**
	 * @param args
	 * 测试对象的不可变性
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//String对象是不变对象, 就是一个String对象一旦生成，它就一直存在，不变，直到垃圾回收
		//看下面这段代码，看起来似乎改变了str1这个对象，其实不然，首先第一行，它其实是new 一个String对象
		//内容是"aaa",然后变量str1指向它，当赋值为"bbb"时，其实又new了一个对象，内容是"bbb", 然后让str1再指向这个新的地址
		//原来的地址上,内容是"aaa"的对象还是存在的，只是没有变量指向它了。 这种对象就是被垃圾回收的下场。
		String str1 = "aaa";
		System.out.println(str1);
		str1 = "bbb";
		System.out.println(str1);
		
		//再看看下面
		//subString其实也是新生成了一个String对象,然后str2这个变量指向它。
		String str2 = str1.substring(2);
		System.out.println(str2);
		//最后，其实可以看看String的源码，它的成员变量都是final的，尤其注意它的value成员。这也能说明，
		//它的成员变量一旦通过构造函数生成，就不能再改了。
	}

}

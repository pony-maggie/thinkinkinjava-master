package com.chapter14;

//通过一个很简单的示例，先来看一下如何使用多线程
//java里处理多线程的方法很多，继承Thread是最简单的方法。
//这个示例创建5个线程实例, 每个实际有一个内部的计数器，初始值是5,线程每得到一个运行的机会(run),这个计数器会减1
//减到0该线程就会停止。

//当我们启动一个java程序的时候，就有一个java.exe的进程，这个进程至少存在一个线程，也就是当前运行main的主线程，然后我们就可以
//通过new Thread这种方式去创建新的线程。

public class SimpleThread extends Thread
{

	public int countDown = 5;
	public static int threadCount = 0;
	public int threadNumber = ++threadCount;
	
	public SimpleThread()
	{
		System.out.println("making" + threadNumber);
	}
	
	//start与run的区别
	
	//run是最重要的方法，这个方法是你要继承实现的，是线程的实际处理函数
	//可以理解为一个线程的线程体，是这个线程实际要做的事情。
	//要记得你的程序中不要直接调用run方法，不然它就是直接在你的主线程里，并没有起到多线程的作用。
	
	//start是启动一个线程，是要在当前主线程中显示调用的。
	public void run()
	{
		while(true)
		{
			System.out.println("thread "+threadNumber + "(" + countDown + ")");
			if(--countDown == 0) return;//run里有个退出机制来释放CPU
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//线程之间的运行顺序跟创建的顺序并没有关系
		for(int i = 0; i < 5; i++)
			new SimpleThread().start();
		System.out.println("all threads start");

	}

}

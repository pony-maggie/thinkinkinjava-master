package com.mess;

import java.util.concurrent.*;

/*
 * 在很多情况下，主线程生成并起动了子线程，如果子线程里要进行大量的耗时的运算，主线程往往将于子线程之前结束，
 * 但是如果主线程处理完其他的事务后，需要用到子线程的处理结果，也就是主线程需要等待子线程执行完成之后再结束，
 * 这个时候就要用到join()方法了。
 */

class Thread1 extends Thread
{
	public Thread1()
	{
		super("[Thread1] Thread");
	}
	public void run()
	{
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " start.");
		try 
		{
			for(int i = 0; i < 5; i++)
			{
				System.out.println(threadName + " loop at " + i);
				Thread.sleep(1000);
			}
			System.out.println(threadName + " end.");
		} 
		catch (Exception e) 
		{
			System.out.println("exception from " + threadName + ".run");
		}
		
		
	}
}

class Thread2 extends Thread
{
	Thread1 t1;
	public Thread2(Thread1 thread1)
	{
		super("[Thread2] Thread");
		this.t1 = thread1;
	}
	public void run()
	{
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " start.");
		try 
		{
			t1.join();
			System.out.println(threadName + " end.");
		} 
		catch (Exception e) 
		{
			System.out.println("exception from" + threadName + ".run");
		}
		
		
	}
}

class Producer extends Thread
{
	public void run()
	{
		for(int i = 0; i < 5; i++)
		{
			System.out.println("i am producer: producerd item " + i);
			Thread.yield();
		}
	}
}

class Consumer extends Thread
{
	public void run()
	{
		for(int i = 0; i < 5; i++)
		{
			System.out.println("i am Consumer: Consumed item " + i);
			Thread.yield();
		}
	}
}
public class JoinAndYieldTestDemo 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
/*
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " start.");
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2(t1);
		try 
		{
			t1.start();
			Thread.sleep(2000);
			t2.start();
			t2.join();
		} catch (Exception e) 
		{
			System.out.println("exception from main");
		}
		
		System.out.println(threadName + " end.");
	*/
		
		Thread producer = new Producer();
		Thread consumer = new Consumer();
		
		producer.setPriority(Thread.MIN_PRIORITY);
		consumer.setPriority(Thread.MAX_PRIORITY);
		
		producer.start();
		consumer.start();
	}

}

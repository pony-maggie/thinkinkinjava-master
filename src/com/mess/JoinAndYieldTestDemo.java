package com.mess;

import java.util.concurrent.*;

/*
 * �ںܶ�����£����߳����ɲ��������̣߳�������߳���Ҫ���д����ĺ�ʱ�����㣬���߳������������߳�֮ǰ������
 * ����������̴߳������������������Ҫ�õ����̵߳Ĵ�������Ҳ�������߳���Ҫ�ȴ����߳�ִ�����֮���ٽ�����
 * ���ʱ���Ҫ�õ�join()�����ˡ�
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

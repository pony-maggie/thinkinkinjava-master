package com.chapter14;

//ͨ��һ���ܼ򵥵�ʾ����������һ�����ʹ�ö��߳�
//java�ﴦ����̵߳ķ����ܶ࣬�̳�Thread����򵥵ķ�����
//���ʾ������5���߳�ʵ��, ÿ��ʵ����һ���ڲ��ļ���������ʼֵ��5,�߳�ÿ�õ�һ�����еĻ���(run),������������1
//����0���߳̾ͻ�ֹͣ��

//����������һ��java�����ʱ�򣬾���һ��java.exe�Ľ��̣�����������ٴ���һ���̣߳�Ҳ���ǵ�ǰ����main�����̣߳�Ȼ�����ǾͿ���
//ͨ��new Thread���ַ�ʽȥ�����µ��̡߳�

public class SimpleThread extends Thread
{

	public int countDown = 5;
	public static int threadCount = 0;
	public int threadNumber = ++threadCount;
	
	public SimpleThread()
	{
		System.out.println("making" + threadNumber);
	}
	
	//start��run������
	
	//run������Ҫ�ķ����������������Ҫ�̳�ʵ�ֵģ����̵߳�ʵ�ʴ�����
	//�������Ϊһ���̵߳��߳��壬������߳�ʵ��Ҫ�������顣
	//Ҫ�ǵ���ĳ����в�Ҫֱ�ӵ���run��������Ȼ������ֱ����������߳����û���𵽶��̵߳����á�
	
	//start������һ���̣߳���Ҫ�ڵ�ǰ���߳�����ʾ���õġ�
	public void run()
	{
		while(true)
		{
			System.out.println("thread "+threadNumber + "(" + countDown + ")");
			if(--countDown == 0) return;//run���и��˳��������ͷ�CPU
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//�߳�֮�������˳���������˳��û�й�ϵ
		for(int i = 0; i < 5; i++)
			new SimpleThread().start();
		System.out.println("all threads start");

	}

}

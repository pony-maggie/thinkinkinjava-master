package com.chapter14;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.bruceeckel.swing.*;


public class Counter1 extends JApplet
{

	private int count = 0;
	private JButton startButton = new JButton("Start");
	private JButton onoffButton = new JButton("Toggle");
	private JTextField t = new JTextField(10);
	private boolean runFlag = true;
	
	public void init()
	{
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(t);
		
		startButton.addActionListener(new StartL());
		cp.add(startButton);
		
		onoffButton.addActionListener(new OnOffL());
		cp.add(onoffButton);
		
		
	}
	
	//点击start发现程序出现"死机"现象，不再响应其它事件，你可以试试点击Toggle按钮是没有作用的
	//虽然go函数里有sleep，可能会误以为点击其它按钮应该可以响应？但是因为go里面有个while 无限循环，
	//所以go函数出不来，那么actionPerformed函数也就出不来，所以也就无法响应其它的事件。
	//单个线程的劣势就在这里，因为是单线程，一个动作完不成，另一个动作当然也就轮不到。多线程就是为解决类似这样的瓶颈产生的。
	public void go()
	{
		while(true)
		{
			try 
			{
				Thread.sleep(100);
			} 
			catch (InterruptedException e) 
			{
				//注意到sleep有可能产生InterruptedException这样的异常，这个是当前的线程被另一个线程中断时发出的
				//这是一个检查异常(checked exception),所以要处理。
				//可以会有疑问，线程正在睡觉，还怎么能抛出异常呢？ 网上有人这样理解:，它正在睡觉，突然被吵醒了，很生气就抛出了一个异常。
				//不过我倒是觉得，只有当前线程sleep了才可能抛出异常，如果一直工作状态，是无法抛出的。
				//事实上，每个线程都有一个与之对应的状态，标记线程的中断状态，默认当然是false,
				//当另一个线程通过调用 Thread.interrupt() 中断一个线程时，会出现以下两种情况之一。如果那个线程在执行一个低级可中断阻塞方法，
				//例如 Thread.sleep()、 Thread.join() 或 Object.wait()，那么它将取消阻塞并抛出 InterruptedException
				//当然有些方法并没有这么友好，收到中断通知就马上中断，可能会忽略。
				
				// TODO: handle exception
				System.err.println("Interrupted");
			}
			
			if(runFlag)
			{
				t.setText(Integer.toString(count++));
			}
		}
	}
	
	class StartL implements ActionListener
	{
		//点击start按钮触发go函数执行。
		public void actionPerformed(ActionEvent e)
		{
			go();
		}
	}
	
	class OnOffL implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			runFlag = !runFlag;
		}
	}
	
	public static void main(String[] args)
	{
		Console.run(new Counter1(), 300, 100);
	}
	
	
	
}

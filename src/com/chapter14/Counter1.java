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
	
	//���start���ֳ������"����"���󣬲�����Ӧ�����¼�����������Ե��Toggle��ť��û�����õ�
	//��Ȼgo��������sleep�����ܻ�����Ϊ���������ťӦ�ÿ�����Ӧ��������Ϊgo�����и�while ����ѭ����
	//����go��������������ôactionPerformed����Ҳ�ͳ�����������Ҳ���޷���Ӧ�������¼���
	//�����̵߳����ƾ��������Ϊ�ǵ��̣߳�һ�������겻�ɣ���һ��������ȻҲ���ֲ��������߳̾���Ϊ�������������ƿ�������ġ�
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
				//ע�⵽sleep�п��ܲ���InterruptedException�������쳣������ǵ�ǰ���̱߳���һ���߳��ж�ʱ������
				//����һ������쳣(checked exception),����Ҫ����
				//���Ի������ʣ��߳�����˯��������ô���׳��쳣�أ� ���������������:��������˯����ͻȻ�������ˣ����������׳���һ���쳣��
				//�����ҵ��Ǿ��ã�ֻ�е�ǰ�߳�sleep�˲ſ����׳��쳣�����һֱ����״̬�����޷��׳��ġ�
				//��ʵ�ϣ�ÿ���̶߳���һ����֮��Ӧ��״̬������̵߳��ж�״̬��Ĭ�ϵ�Ȼ��false,
				//����һ���߳�ͨ������ Thread.interrupt() �ж�һ���߳�ʱ������������������֮һ������Ǹ��߳���ִ��һ���ͼ����ж�����������
				//���� Thread.sleep()�� Thread.join() �� Object.wait()����ô����ȡ���������׳� InterruptedException
				//��Ȼ��Щ������û����ô�Ѻã��յ��ж�֪ͨ�������жϣ����ܻ���ԡ�
				
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
		//���start��ť����go����ִ�С�
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

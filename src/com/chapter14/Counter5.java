package com.chapter14;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.bruceeckel.swing.*;

class Ticker2 extends Thread
{
	private JButton b = new JButton("Toggle");
	private JButton incPriority = new JButton("up");
	private JButton decPriority = new JButton("dwon");
	
	private JTextField t = new JTextField(10),
	pr = new JTextField(3); //display priority
	
	private int count = 0;
	private boolean runFlag = true;
	
	public Ticker2(Container c)
	{
		b.addActionListener(new ToggleL());
		incPriority.addActionListener(new UpL());
		decPriority.addActionListener(new DownL());
		
		//�����½�panel��Ŀ����Ϊ�˷��飬��ΪtickerҪ�������飬����ÿ��ʵ�������Լ���panel
		JPanel p = new JPanel();
		p.add(t);
		p.add(pr);
		
		p.add(b);
		p.add(incPriority);
		p.add(decPriority);
		
		c.add(p);//����ֱ����containerӦ��Ҳ�У����ü�panel
		//
		
		
		
	}
	class ToggleL implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			runFlag = !runFlag;
		}
	}
	class UpL implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//Java�̵߳����ȼ�ȡֵ��Χ��1 ��Thread.MIN_PRIORITY �� �� 10 ��Thread.MAX_PRIORITY ����
			int newPriority = getPriority() + 1; //ÿ�ε���
			if(newPriority > Thread.MAX_PRIORITY)
			{
				newPriority = Thread.MAX_PRIORITY;
			}
			setPriority(newPriority);
		}
	}
	
	class DownL implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int newPriority = getPriority() - 1;
			if(newPriority < Thread.MIN_PRIORITY)
			{
				newPriority = Thread.MIN_PRIORITY;
			}
			setPriority(newPriority);
		}
	}
	
	public void run()
	{
		while(true)
		{
			if(runFlag)
			{
				t.setText(Integer.toString(count++));
				pr.setText(Integer.toString(getPriority()));
			}
			//yield������ͬ���ȼ����߳���ִ�еĻ��ᡣ
			yield();
		}
	}
}


public class Counter5 extends JApplet
{

	private JButton start = new JButton("Start");
	private JButton upMax = new JButton("Inc Max Priority");
	private JButton downMax = new JButton("Dec Max Priority");
	
	private boolean started = false;
	private static final int SIZE = 10;
	private Ticker2[] s = new Ticker2[SIZE];
	private JTextField mp = new JTextField(3);
	
	public void init()
	{
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		for(int i = 0; i < s.length; i++)
		{
			s[i] = new Ticker2(cp);
		}
		
		cp.add(new JLabel("MAX_PRIORITY = " + Thread.MAX_PRIORITY));
		cp.add(new JLabel("MIN_PRIORITY = " + Thread.MIN_PRIORITY));
		cp.add(new JLabel("Group max priority"));
		
		cp.add(mp);
		cp.add(start);
		cp.add(upMax);
		cp.add(downMax);
		start.addActionListener(new StartL());
		upMax.addActionListener(new UpMaxL());
		downMax.addActionListener(new DownMaxL());
		showMaxPriority();
		
		//recursively display parent thread group
		ThreadGroup parent = s[0].getThreadGroup().getParent();
		while(parent != null)
		{
			cp.add(new Label("parent threadgroup max priority = " +
					parent.getMaxPriority()));
			parent = parent.getParent();
		}
		
		
	}
	public void showMaxPriority()
	{
		int maxp = s[0].getThreadGroup().getMaxPriority();
		mp.setText(Integer.toString(maxp));
	}
	
	class StartL implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(!started)
			{
				started = true;
				for(int i = 0; i < s.length; i++)
				{
					s[i].start();
				}
			}
		}
	}
	
	class UpMaxL implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int maxp = s[0].getThreadGroup().getMaxPriority();
			if(++maxp > Thread.MAX_PRIORITY)
			{
				maxp = Thread.MAX_PRIORITY;
			}
			s[0].getThreadGroup().setMaxPriority(maxp);
			showMaxPriority();
		}
	}
	class DownMaxL implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int maxp = s[0].getThreadGroup().getMaxPriority();
			if(--maxp < Thread.MIN_PRIORITY)
			{
				maxp = Thread.MIN_PRIORITY;
			}
			s[0].getThreadGroup().setMaxPriority(maxp);
			showMaxPriority();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Console.run(new Counter5(), 450, 600);

	}

}

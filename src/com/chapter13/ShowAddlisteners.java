package com.chapter13;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;

import javax.swing.*;

import com.bruceeckel.swing.*;
import com.bruceeckel.util.*;

//swing的事件驱动模型，
//swing是java的控件开发包，主要用于开发基于java的一些界面应用程序。
//控件一般都有对应的事件，比如点击一个按钮，产生一个事件，我们可以处理这个事件，表达点击按钮希望完成的动作。
//swing有个监听器机制(listener)用来监听它所注册的控件产生的事件。
//控件通过调用addXXXListener方法来注册一个监听器，监听器中会实现接口的方法(actionPerformed)来处理具体的事件响应处理动作。
//XXX代表的是监听的类型，比如addActionListener是监听动作事件，对于按钮它可能是用户按下或释放鼠标，对于JTextField控件，可能是用户在输入框里按下回车这个动作。
//尽量用内部类

public class ShowAddlisteners extends JApplet
{
	Class cl;
	Method[] m;
	Constructor ctor;
	String[] n = new String[0];
	
	JTextField name = new JTextField(25);
	JTextArea results = new JTextArea(40, 65);
	
	class NameL implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String nm = name.getText().trim();//消除前后的空格
			if(nm.length() == 0)
			{
				results.setText("no match");
				n = new String[0]; //这里不明白什么意思???, 可以不加吧
				return;
			}
			
			try 
			{
				cl = Class.forName("javax.swing." + nm);
			} 
			catch (ClassNotFoundException e2) 
			{
				// TODO: handle exception
				results.setText("no match");
				return;
			}
			
			m = cl.getMethods();
			n = new String[m.length];
			for(int i = 0; i < m.length; i++)
			{
				n[i] = m[i].toString();
			}
			reDisplay();
		}
		
		
	}
	
	//只显示addListener相关的
	void reDisplay()
	{
	
		String[] rs = new String[n.length];
		int j = 0;
		
		for(int i = 0; i < n.length; i++)
		{
			if((n[i].indexOf("add") != -1) && (n[i].indexOf("Listener") != -1))
			{
				rs[j++] = n[i].substring(n[i].indexOf("add"));
			}
		}
		results.setText(""); //这个不要的话可以吗？
		for(int i = 0; i < j; i++)
		{
			results.append(StripQualifiers.strip(rs[i]) + "\n");
		}
	}
	
	public void init()
	{
		/*
		 * 都是容器, 不过
			JPanel:JPanel 是一般轻量级容器，可以向JPanel容器中放入JPanel，JTextfiled，JButton等；
			Container:基本可以包容awt的所有组件，包括JPanel
		 */
		name.addActionListener(new NameL());
		JPanel top = new JPanel();
		top.add(new JLabel("swing class name (pess enter):"));
		top.add(name);
		Container cp = getContentPane();
		cp.add(BorderLayout.NORTH, top);
		cp.add(new JScrollPane(results));
	}
	
	public static void main(String[] args)
	{
		Console.run(new ShowAddlisteners(), 500, 400);
	}

}

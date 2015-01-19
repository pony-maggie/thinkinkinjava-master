package com.chapter13;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;

import javax.swing.*;

import com.bruceeckel.swing.*;
import com.bruceeckel.util.*;

//swing���¼�����ģ�ͣ�
//swing��java�Ŀؼ�����������Ҫ���ڿ�������java��һЩ����Ӧ�ó���
//�ؼ�һ�㶼�ж�Ӧ���¼���������һ����ť������һ���¼������ǿ��Դ�������¼����������ťϣ����ɵĶ�����
//swing�и�����������(listener)������������ע��Ŀؼ��������¼���
//�ؼ�ͨ������addXXXListener������ע��һ�����������������л�ʵ�ֽӿڵķ���(actionPerformed)�����������¼���Ӧ��������
//XXX������Ǽ��������ͣ�����addActionListener�Ǽ��������¼������ڰ�ť���������û����»��ͷ���꣬����JTextField�ؼ����������û���������ﰴ�»س����������
//�������ڲ���

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
			String nm = name.getText().trim();//����ǰ��Ŀո�
			if(nm.length() == 0)
			{
				results.setText("no match");
				n = new String[0]; //���ﲻ����ʲô��˼???, ���Բ��Ӱ�
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
	
	//ֻ��ʾaddListener��ص�
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
		results.setText(""); //�����Ҫ�Ļ�������
		for(int i = 0; i < j; i++)
		{
			results.append(StripQualifiers.strip(rs[i]) + "\n");
		}
	}
	
	public void init()
	{
		/*
		 * ��������, ����
			JPanel:JPanel ��һ��������������������JPanel�����з���JPanel��JTextfiled��JButton�ȣ�
			Container:�������԰���awt���������������JPanel
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

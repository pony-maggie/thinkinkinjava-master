package com.chapter13;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.bruceeckel.swing.*;


public class Button2 extends JApplet
{
	JButton b1 = new JButton("button 1");
	JButton b2 = new JButton("button 2");
	
	JTextField textField = new JTextField(20);
	
	class BL implements ActionListener
	{
		//加到按钮里就是按下的事件
		public void actionPerformed(ActionEvent e)
		{
			String name = ((JButton)e.getSource()).getText();
			textField.setText(name);
		}
	}
	
	BL bl = new BL();
	public void init()
	{
		b1.addActionListener(bl);
		b2.addActionListener(bl);
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(b1);
		cp.add(b2);
		cp.add(textField);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Console.run(new Button2(), 200, 200);

	}

}

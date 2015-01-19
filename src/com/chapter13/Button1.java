package com.chapter13;

import java.awt.*;

import javax.swing.*;

import com.bruceeckel.swing.*;

public class Button1 extends JApplet
{

	JButton b1 = new JButton("button1");
	JButton b2 = new JButton("button2");
	
	public void init()
	{
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(b1);
		cp.add(b2);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Console.run(new Button1(), 200, 200);

	}

}

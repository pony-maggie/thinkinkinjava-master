package com.chapter13;

import java.awt.*;

import javax.swing.*;

import com.bruceeckel.swing.*;

public class FlowLayout1 extends JApplet
{

	public void init()
	{
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		for(int i = 0; i < 20; i++)
		{
			cp.add(new JButton("button"+i));
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Console.run(new FlowLayout1(), 300, 250);

	}

}

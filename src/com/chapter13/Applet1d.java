package com.chapter13;

import javax.swing.*;

import com.bruceeckel.swing.*;

public class Applet1d extends JApplet
{

	public void init()
	{
		getContentPane().add(new JLabel("Applent!"));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Console.run(new Applet1d(), 200, 300);

	}

}

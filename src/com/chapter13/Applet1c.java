package com.chapter13;

import java.util.logging.*;

import javax.swing.*;
import com.bruceeckel.swing.*;

public class Applet1c extends JApplet
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
		JApplet applet = new Applet1c();
		JFrame frame = new JFrame("Applet1c frame");
		Console.setupClosing(frame);
		frame.getContentPane().add(applet);
		frame.setSize(200, 200);
		applet.init();
		applet.start();
		frame.setVisible(true);

	}

}

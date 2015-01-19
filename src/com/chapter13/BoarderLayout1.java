package com.chapter13;

import java.awt.*;

import javax.swing.*;

import com.bruceeckel.swing.*;

public class BoarderLayout1 extends JApplet
{
	public void init()
	{
		Container cp = getContentPane();
		//borderlayout是默认的，所以不用专门指定setlayout
		cp.add(BorderLayout.NORTH, new JButton("north"));
		cp.add(BorderLayout.SOUTH, new JButton("south"));
		cp.add(BorderLayout.EAST, new JButton("east"));
		cp.add(BorderLayout.WEST, new JButton("west"));
		
		cp.add(BorderLayout.CENTER, new JButton("center"));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Console.run(new BoarderLayout1(), 300, 250);

	}

}

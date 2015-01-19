package com.chapter14;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.text.*;

import com.bruceeckel.swing.*;

class Blockable extends Thread
{
	private Peeker peeker;
	protected JTextField state = new JTextField(30);
	protected int i;
	public Blockable(Container c)
	{
		c.add(state);
		peeker = new Peeker(this, c);
	}
	
	public synchronized int read() {return i;}
	protected synchronized void update()
	{
		state.setText(getClass().getName() + " state:i = " +
				i);
		
	}
	
	public void stopPeeker()
	{
		peeker.terminate();
	}
}

class Peeker extends Thread
{
	private Blockable b;
	private int session;
	private JTextField status = new JTextField(30);
	private boolean stop = false;
	public Peeker(Blockable b, Container c)
	{
		c.add(status);
		this.b = b;
		start();
	}
	
	public void terminate()
	{
		stop = true;
	}
	public void run()
	{
		while(!stop)
		{
			status.setText(b.getClass().getName()+
					" Peeker " + (++session) +
					"; value = " + b.read());
			
			try 
			{
				sleep(100);
			} catch (InterruptedException e) 
			{
				System.err.println("Interrupted");
			}
		}
	}
}

class Sleeper1 extends Blockable
{
	public Sleeper1(Container c) {super(c);}
	public synchronized void run()
	{
		while(true)
		{
			i++;
			update();
			try 
			{
				sleep(1000);
			} catch (InterruptedException e) 
			{
				System.err.println("Interrupted");
			}
		}
		
	}
}

class Sleeper2 extends Blockable
{
	public Sleeper2(Container c) {super(c);}
	public void run()
	{
		while(true)
		{
			change();
			try 
			{
				sleep(1000);
			} catch (InterruptedException e) 
			{
				System.err.println("Interrupted");
			}
		}
	}
	public synchronized void change()
	{
		i++;
		update();
	}
}
public class Blocking extends JApplet
{

	private JButton start = new JButton("Start");
	private JButton stopPeekers = new JButton("Stop Peekers");
	
	private boolean started = false;
	private Blockable[] b;
	private PipedWriter out;
	private PipedReader in;
	
	class StartL implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(!started)
			{
				started = true;
				for(int i = 0; i < b.length; i++)
				{
					b[i].start();
				}
			}
		}
	}
	
	class StopPeekersL implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{

			for(int i = 0; i < b.length; i++)
			{
				b[i].stopPeeker();
			}
		}
	}
	
	public void init()
	{
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		out = new PipedWriter();
		
		try 
		{
			in = new PipedReader(out);
		} 
		catch (IOException e) 
		{
			System.err.println("pipedreader problem");
		}
		
		b = new Blockable[] {
			new Sleeper1(cp),
			new Sleeper2(cp)
		};
		
		start.addActionListener(new StartL());
		cp.add(start);
		
		stopPeekers.addActionListener(new StopPeekersL());
		cp.add(stopPeekers);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Console.run(new Blocking(), 350, 550);

	}

}

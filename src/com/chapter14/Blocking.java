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

//supsending and resuming
class SuspendResume extends Blockable
{
	public SuspendResume(Container c)
	{
		super(c);
		//new Resumer(this);
	}
}
class SuspendResume1 extends SuspendResume
{
	public SuspendResume1(Container c) {super(c);}
	public synchronized void run()
	{
		while(true)
		{
			i++;
			update();
			suspend();
		}
	}
}
class SuspendResume2 extends SuspendResume
{
	public SuspendResume2(Container c)
	{
		super(c);
	}
	public void run()
	{
		while(true)
		{
			change();
			suspend();
		}
	}
	
	public synchronized void change()
	{
		i++;
		update();
	}
}
class Resumer extends Thread
{
	private SuspendResume sr;
	public Resumer(SuspendResume sr)
	{
		this.sr = sr;
		start();
	}
	
	public void run()
	{
		while(true)
		{
			try 
			{
				sleep(1000);
			} 
			catch (InterruptedException e) 
			{
				// TODO: handle exception
				System.err.println("Interrupted");
			}
			sr.resume();
		}
	}
	
}

//wait and nofity
class WaitNotify1 extends Blockable
{
	public WaitNotify1(Container c)
	{
		super(c);
	}
	
	public synchronized void run()
	{
		while(true)
		{
			i++;
			update();
			try 
			{
				wait(100);
			} 
			catch (InterruptedException e) {
				System.err.println("interrupted");
			}
		}
	}
}

class WaitNotify2 extends Blockable
{
	public WaitNotify2(Container c)
	{
		super(c);
		new Notifier(this);
	}
	public synchronized void run()
	{
		while(true)
		{
			i++;
			update();
			try 
			{
				wait();
			} 
			catch (InterruptedException e) 
			{
				System.err.println("interrupted");
			}
		}
	}
}

class Notifier extends Thread
{
	private WaitNotify2 wn2;
	public Notifier(WaitNotify2 wn2)
	{
		this.wn2 = wn2;
		start();
	}
	
	public void run()
	{
		while(true)
		{
			try 
			{
				sleep(2000);
			} 
			catch (InterruptedException e) 
			{
				System.err.println("interrupted");
			}
			synchronized (wn2) 
			{
				wn2.notify();
			}
		}
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
			//new Sleeper1(cp),
			//new Sleeper2(cp),
			//new SuspendResume1(cp),
			//new SuspendResume2(cp),
			new WaitNotify1(cp),
			new WaitNotify2(cp)
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
		Console.run(new Blocking(), 550, 550);

	}

}

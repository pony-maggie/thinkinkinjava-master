package com.chapter4;

class Chair
{
	static boolean gcrun = false;
	static boolean f = false;
	static int created = 0;
	static int finalized = 0;
	
	int i;
	Chair() 
	{
		i = ++created;
		if(created == 47)
		{
			System.out.println("Created 47");
		}
	}
	
	public void finalize()
	{
		if(!gcrun)
		{
			gcrun = true;
			System.out.println("beginning to finalize after " +
					created + " chairs have been created");
		}
		if(i == 47)
		{
			System.out.println("finalizing chair #47, " +
					"setting flag to stop chair creation");
			f = true;
		}
		finalized++;
		if(finalized >= created)
		{
			System.out.println("all " + finalized + " finalized");
		}
	}
}
public class Garbage 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		while(!Chair.f)
		{
			new Chair();
			new String("to take up space");
		}
		
		System.out.println("after all chairs have been created:\n" +
				"total finalized = " + Chair.finalized);
		
		//optional arguments force garbage
		//collection & finalization
		if(args.length > 0)
		{
			if(args[0].equals("gc") ||
					args[0].equals("all"))
			{
				System.out.println("gc():");
				System.gc();
			}
			
			if(args[0].equals("finalize") ||
					args[0].equals("all"))
			{
				System.out.println("run finalization():");
				System.runFinalization();
			}
		}
		
		System.out.println("byte!");

	}

}

package citi.assignment;

import java.util.Random;

public class CheckThreadSafeQueue 
{
	private static final short THREAD_WORKING=10;
	private static final short THREAD_DELAY=1000;
	
	public static void main(String[] args) throws InterruptedException 
	{
		ThreadSafeQueue<Integer> tsq=new ThreadSafeQueue<>();
		Random random=new Random();
		
		for(int i=1;i<THREAD_WORKING;i++)
		{
			Thread.sleep(THREAD_DELAY);
			new Thread()
			{
				public void run()
				{
					boolean b=random.nextBoolean();
					if(b==true)
					{
						int val=random.nextInt();
						try {
							System.out.println("Inserted in Queue "+val);
							tsq.enqueue(val);
						} catch (InterruptedException e) 
						{
							e.printStackTrace();
						}
					}
					else
					{
						try {
							System.out.println("Taken from queue "+tsq.dequeue());
						} catch (InterruptedException e) 
						{
							e.printStackTrace();
						}
					}
				}
			}.start();
		}
	}

}

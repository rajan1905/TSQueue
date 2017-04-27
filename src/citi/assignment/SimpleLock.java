package citi.assignment;

public class SimpleLock
{
	  private boolean isLocked = false;

	  public synchronized void lock() throws InterruptedException
	  {
	    while(isLocked)
	    {
	      wait();
	    }
	    isLocked = true;
	  }

	  public synchronized void unlock()
	  {
	    isLocked = false;
	    notifyAll();
	  }
}
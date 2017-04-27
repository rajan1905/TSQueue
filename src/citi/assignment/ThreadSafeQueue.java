package citi.assignment;

import java.util.LinkedList;
import java.util.List;

public class ThreadSafeQueue<E> implements QueueInterface<E>
{
	private final static short SIZE=10;
	List<E> queue;
	SimpleLock monitor=new SimpleLock();
	
	public ThreadSafeQueue() 
	{
		queue=new LinkedList<E>();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void enqueue(Object e) throws InterruptedException 
	{
		if(isFull())
			return;
		
		monitor.lock();
		try
		{
			E entry=(E) e;
			queue.add(entry);
		}
		finally
		{
			monitor.unlock();
		}
		System.out.println(queue);
	}

	@Override
	public E dequeue() throws InterruptedException 
	{
		E e;
		if(queue.size()==0)
			return null;
		
		monitor.lock();
		try
		{
			e=queue.get(0);
			queue.remove(0);	
		}
		finally
		{
			monitor.unlock();
		}
		
		return e;
	}

	@Override
	public E peek() 
	{
		
		return null;
	}

	@Override
	public boolean isFull() 
	{
		if(queue.size()==SIZE)
		return true;
		
		return false;
	}

	@Override
	public boolean isEmpty() 
	{
		
		return false;
	}
	
	@Override
	public String toString()
	{
		return ""+queue.toString();
	}
}
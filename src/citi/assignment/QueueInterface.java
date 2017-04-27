package citi.assignment;

public interface QueueInterface<E> 
{
	public void enqueue(E e) throws InterruptedException;
	public E dequeue() throws InterruptedException;
	public E peek();
	public boolean isFull();
	public boolean isEmpty();
}

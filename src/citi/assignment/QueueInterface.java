package citi.assignment;

public interface QueueInterface<E> 
{
	public void enqueue(E e) throws InterruptedException;
	public E dequeue() throws InterruptedException;
	public E peek() throws InterruptedException;
	public boolean isFull() throws InterruptedException;
	public boolean isEmpty() throws InterruptedException;
}

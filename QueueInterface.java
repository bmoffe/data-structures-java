//Brianna Moffett
//QueueInterface.java
//CS 272
//10.24.19
public interface QueueInterface<E> {
	public void enqueue(E e);
	public E dequeue();
	public E front();
	public int size();
	public boolean isEmpty();
}

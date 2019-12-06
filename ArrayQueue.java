import java.util.*;
//Brianna Moffett
//ArrayQueue.java
//CS 272
//10.24.19
public class ArrayQueue<E> implements QueueInterface<E>{
	public int front;
	public int rear;
	public int manyItems;
	public E data[];
	public static void main(String[] args) {
		
	}
	public ArrayQueue() { //constructor
		final int initCap = 10;
		manyItems = 0;
		data = (E []) new Object[initCap];
	}
	public void enqueue(E e) { //adding elements to end of queue
		if (manyItems == data.length) {
			ensureCapacity(manyItems * 2 + 1);
		}
		if (manyItems == 0) {
			front = 0;
			rear = 0;
		}
		else {
			rear = nextIndex(rear);
		}
		data[rear] = e;
		manyItems++;
	}
	public E dequeue() { //removing elements from front of queue
		E x;
		if (manyItems == 0) {
			throw new NoSuchElementException("Queue underflow.");
		}
		x = (E) data[front];
		front = nextIndex(front);
		manyItems--;
		return x;
	}
	public E front() { //what's at the front?
		return data[front];
	}
	public int size() { //how large is the queue?
		return manyItems;
	}
	public boolean isEmpty() { //is it empty
		return (manyItems == 0);
	}
	private void ensureCapacity(int minimumCapacity) { //ensuring that the capacity is never too small; if we hit the cap, double the max capacity
		E [] largerArray;
		int n1, n2;
		if(manyItems == 0) {
			data = (E []) new Object[minimumCapacity];
		}
		else if (front <= rear) {
			largerArray = (E []) new Object[minimumCapacity];
			System.arraycopy(data, front, largerArray, front, manyItems);
			data = largerArray;
		}
		else {
			largerArray = (E []) new Object[minimumCapacity];
			n1 = data.length - front;
			n2 = rear + 1;
			System.arraycopy(data, front, largerArray, 0, n1);
			System.arraycopy(data, 0, largerArray, n1, n2);
			front = 0;
			rear = manyItems - 1;
			data = largerArray;
		}
	}
	public void displayQueue() { //printing the elements in the queue
		for (int i = front; i < data.length; i++) {
			System.out.print(data[i] + "->");
		}
	}
	private int nextIndex(int i) { //moving through the array with a seperate function
		if (++i == data.length) {
			return 0;
		}
		else {
			return i;
		}
	}
}

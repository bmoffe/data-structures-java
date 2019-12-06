import java.util.*;
//Brianna Moffett
//LinkedQueue.java
//CS 272
//10.24.19
public class LinkedQueue<E> implements QueueInterface<E> {
	public SNode<E> front;
	public SNode<E> rear;
	public int lineSize;
	public static void main(String[] args) {
		
	}
	public LinkedQueue() { //constructor
		front = null;
		rear = null;
	}
	public void enqueue(E e) { //adding a node to the end of the queue
		if (isEmpty()) {
			front = new SNode<E>(e, null);
			rear = front;
		}
		else {
			rear.addNodeAfterThis(e);
			rear = rear.getLink();
		}
		lineSize++;
	}
	public E dequeue() { //removing a node from the front of the queue
		E x;
		if (lineSize == 0) {
			throw new NoSuchElementException("Queue underflow.");
		}
		x = front.getData();
		front = front.getLink();
		lineSize--;
		if (lineSize == 0) {
			rear = null;
		}
		return x;
	}
	public E front() { //displaying the first value in the queue
		return front.getData();
	}
	public int size() { //how large is the queue?
		lineSize =  front.ListLength() - 1;
		return lineSize;
	}
	public boolean isEmpty() { //is the queue empty?
		return (lineSize == 0);
	}
	public String displayQueue() { //display contents of queue
		String string = "";
		SNode<E> cursor = front;
		while (cursor != null) {
			string += cursor.getData();
			if (cursor.getLink() != null) {
				string += "->";
			}
			cursor = cursor.getLink();
		}
		return string;
	}
}

//Brianna Moffett
//QueueTest.java
//CS 272
//10.24.19
public class QueueTest <E>{
	public static void main(String[] args) {
		//test cases
		LinkedQueue<Integer> queuetest1 = new LinkedQueue();
		ArrayQueue<Integer> arrayq = new ArrayQueue();
		for (int i = 0; i <= 10; i++) { //filling link queue with values
			queuetest1.enqueue(i);
		}
		System.out.println(queuetest1.displayQueue());
		queuetest1.dequeue();
		System.out.println("\n");
		System.out.println(queuetest1.displayQueue());
		System.out.println("\n");
		System.out.println("Is the list empty? Tests indicate " + queuetest1.isEmpty() + "."); //is it empty
		System.out.println("The amount of objects in the list is " + queuetest1.size() + " units."); //how large is it?
		System.out.println("The first object in the queue is " + queuetest1.front() + "."); //printing what's at the front of the queue
		
		System.out.println("\n");
		arrayq.enqueue(1); //adding values to queue
		arrayq.enqueue(2);
		arrayq.enqueue(3);
		arrayq.enqueue(3);
		arrayq.enqueue(3);
		arrayq.enqueue(3);
		arrayq.enqueue(3);
		arrayq.enqueue(3);
		arrayq.enqueue(3);
		arrayq.enqueue(3);
		arrayq.displayQueue(); //printing queue
		System.out.println("\n");
		System.out.println("The amount of objects in the list is " + arrayq.size() + " units."); //queue size
		arrayq.dequeue(); //removing from queue
		arrayq.dequeue();
		System.out.println("\n");
		arrayq.displayQueue(); //printing queue again
		System.out.println("\n");
		System.out.println("Is the list empty? Tests indicate " + arrayq.isEmpty() + "."); //is it empty?
		System.out.println("The amount of objects in the list is " + arrayq.size() + " units."); //how large is it?
		System.out.println("The first object in the queue is " + arrayq.front() + "."); //value at the front of the queue
	}
}

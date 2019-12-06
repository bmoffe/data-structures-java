import java.util.ArrayList;
//Brianna Moffett
//CS 272
//10.17.19
//lab 8
public class ArrayListStack<E> implements StackInterface<E>{
	private ArrayList<E> top;
	
	public static void main(String[] args) {
		
	}
	public ArrayListStack() { //constructor
		top = new ArrayList<E>(10);
	}
	public void push(E e) { //push
		top.add(e);
	}
	public E pop() { //pop
		if (top == null) {
			throw new NullPointerException("The list is empty");
		}
		else {
			return top.remove(top.size() - 1);
		}
	}
	public E top() { //top
		if (top == null) {
			throw new NullPointerException("The list is empty.");
		}
		else {
			E x = top.get(top.size() - 1);
			return x;
		}
	}
	public int size() {//size
		return top.size();
	}
	public void displayContents() { //display contents of stack
		if (this.isEmpty()) {
			return;
		}
		E x = this.top();
		this.pop();
		displayContents();
		System.out.print(x + "->");
		this.push(x);
	}
	public boolean isEmpty() { //isEmpty
		return top.size() == 0;
	}
}

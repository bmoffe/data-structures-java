//Brianna Moffett
//CS 272
//10.17.19
//lab 8
public class LinkStack<E> implements StackInterface<E>{
	public SNode<E> top;
	
	public static void main(String [] args) {
		
	}
	public void push(E e) { //push
		top = new SNode<E>(e, top);
	}
	public E pop() { //pop
		if (top == null) {
			throw new NullPointerException("Parameter must not be null");
		}
		E x = top.getData();
		top = top.getLink();
		return x;
	}
	public E top() { //top
		if (top == null) {
			throw new NullPointerException("Parameter points to null value.");
		}
		else {
			E x = top.getData();
			return x;
		}
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
		return top == null;
	}
	public int size() { //size
		return top.ListLength();
	}
}

import java.util.ArrayList;
//Brianna Moffett
//CS 272
//11.25.19
//MinHeap.java
import java.lang.Math;
public class MinHeap {
	ArrayList<Integer> data = new ArrayList<Integer>();
	public static void main(String[] args) {
		//expected output: 5 14 23 32 41 53 64 50 87 90 
        //                 23 32 53 50 41 87 64 90 
		MinHeap heap = new MinHeap();
		MinHeap heap2 = new MinHeap();
		MinHeap heap3 = new MinHeap();
		heap.add(5);
        heap.add(14);
        heap.add(23);
        heap.add(32);
        heap.add(41);
        heap.add(53);
        heap.add(64);
        heap.add(50);
        heap.add(87);
        heap.add(90);
        heap.printHeap();
        System.out.println();
        int r1 = heap.remove();
        int r2d2 = heap.remove();
        heap.printHeap();
        System.out.println();
        System.out.println();
        
        //expected output: 6 15 24 33 42 54 65 51 88 91 
        //                 24 33 54 51 42 88 65 91 
        heap2.add(6);
        heap2.add(15);
        heap2.add(24);
        heap2.add(33);
        heap2.add(42);
        heap2.add(54);
        heap2.add(65);
        heap2.add(51);
        heap2.add(88);
        heap2.add(91);
        heap2.printHeap();
        System.out.println();
        int removalone = heap2.remove();
        int removaltwo = heap2.remove();
        heap2.printHeap();
        System.out.println();
        System.out.println();
	}
	public void add(int e) { //adds an element specified by the user to the heap: if the heap is empty, return, else, add element to the heap and reheap upwards
		data.add(e);
		if (data.size() == 0) {
			return;
		}
		int p = data.lastIndexOf(e);
		reHeapUpward(p);
	}
	public int remove() { //removes an element from the heap: if the heap is empty, throw an exception, if the heap has only one element, remove the element, else, remove the last element in the heap
		if (data.size() == 0) {
			throw new NullPointerException("Queue underflow.");
		}
		if (data.size() == 1) {
			int answer = data.get(0);
			data.remove(0);
			return answer;
		}
		int answer = top();
		swap(data, 0, data.size() - 1);
		data.remove(data.size() - 1);
		reHeapDownward(0);
		return answer;
	}
	public int top() { //returns the element at the top of the heap
		return data.get(0);
	}
	private void reHeapUpward(int position) { //reheaps upward from specified position
		int mother3 = (position - 1) / 2;
		while (data.get(position) < data.get(mother3)) {
			swap(data, position, mother3);
			position = mother3;
			mother3 = (position - 1) / 2;
		}
	}
	private void reHeapDownward(int pos) { //reheaps downward from specified position
        int left = 1;
        int right = 2;
        while((left < data.size() && data.get(pos) > data.get(left)) || (right < data.size() && data.get(pos) > data.get(right)) ) {
        	if(data.get(left) < data.get(right)) {
                swap(data, left, pos);
                pos = left;
            }
            else {
                swap(data, right, pos);
                pos = right;
            }
            left = 2 * pos + 1;
            right = 2 * pos + 2;
        }
    }
	private void swap(ArrayList<Integer> data, int i, int k) { //swaps elements in heap
		Integer temp = data.get(i);
		data.set(i, data.get(k));
		data.set(k,  temp);
		return;
	}
	private void printHeap() { //prints contents of heap
		for (int i = 0; i < data.size(); i++) {
			System.out.print(data.get(i) + " ");
			if ((i + 1) % 10 == 0) {
				System.out.println();
			}
		}
	}
}

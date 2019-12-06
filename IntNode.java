package lab4;
//Brianna Moffett
//IntNode.java
//09.30.19
//CS 278
public class IntNode {

	private int data; 
	private IntNode link;
	private int head; 
	
	public static void main(String[] args) {
		
	}
	/**
	 * @param none
	 */
	public IntNode(){ 
		this.data = 0;
		this.link = null;
	}
	/**
	 * 
	 * @param _data
	 * @param _link
	 */
	public IntNode(int _data, IntNode _link) { 
		this.data = _data;
	    this.link = _link;
	}
	/**
	 * 
	 * @param data
	 */
	public void setNodeValue (int data) { 
		this.data = data;
	}
	/**
	 * 
	 * @return data
	 */
	public int getNodeValue () { 
		return data;
	}
	/**
	 * 
	 * @param link
	 */
	public void setLink (IntNode link) { 
		this.link = link;
	}
	/**
	 * 
	 * @return link
	 */
	public IntNode getLink () { 
		return link;
	}
	/**
	 * @return string
	 */
	public String toString() { 
		return data + "->" + link;
	}
	/**
	 * 
	 * @param newdata
	 */
	public void addNodeAfterThis(int newdata) { 
		this.setLink(new IntNode(newdata, this.link));
	}
	/**
	 * @param none
	 * @return none
	 */
	public void removeNodeAfterThis () { 
		this.link = this.link.link;
	}
	/**
	 * 
	 * @return int
	 */
	@SuppressWarnings("unused")
	public int ListLength() { 
		int count = 0;
		IntNode cursor = this;
		while (cursor != null) {
			if (cursor == null) {
				return count;
			}
			cursor = cursor.link;
			count++;
		}
		return count;
	}
	/**
	 * 
	 * @param head
	 * @param data
	 * @return boolean
	 * @precondition head is not null
	 */
	public static boolean search (IntNode head, int data) {
		IntNode cursor = head;
		while (cursor != null) {
			if (cursor.data == data) {
				return true;
			}
			data++;
			cursor = cursor.getLink();
		}
		return false;
	}
	
	/**
	 * 
	 * @param head
	 * @return int
	 */
	public static int listEvenNumber(IntNode head) { 
		IntNode cursor = head;
		if (cursor == null) {
			return 0;
		}
		while (cursor != null) {
			if (cursor.head % 2 == 0) {
				System.out.print(cursor.link + "->");
			}
			cursor = cursor.link;
		}
		return 1;
	}
	
	/**
	 * 
	 * @param newdata
	 * @return int
	 */
	public void addToEnd (int newdata) {
		this.setLink(new IntNode(newdata, this.link));
	}
	
	/**
	 * 
	 * @param head
	 * @param num
	 * @return num
	 */
	public static int sumLast(IntNode head, int num) { 
	    if (head == null) {
	        return 0; 
	    }
	    //generating sum
	    sumLast(head.link, num); 
	  
	    num = num + head.data; 
	    
	    return num;
	}
	
	/**
	 * 
	 * @param head
	 * @return newhead
	 * copies all odd elements to new linked list object
	 */
	@SuppressWarnings("unused")
	public static IntNode copyOdd (IntNode head) {
		IntNode cursor = head;
		IntNode cursor1 = cursor.getLink();
		IntNode newhead = new IntNode(head.getNodeValue(), null);
		if (head == null) {
			return null;
		}
		while (cursor1 != null) {
			if (cursor.data % 2 == 1) {
				newhead.addToEnd(cursor.getNodeValue());
			}
			cursor = cursor1.getLink();
			cursor.head++;
		}
		return newhead;
	}
	
	/**
	 * 
	 * @param head
	 * @param e
	 * @return list with specified elements deleted
	 */
	public static IntNode removeall (IntNode head, int e) {
		IntNode cursor = head;
		if (cursor == null) {
			return null;
		}
		while (cursor.link != null) {
			if (cursor.link.data == e) {
				cursor.removeNodeAfterThis();
			}
			cursor = cursor.link;
			cursor.head++;
		}
		return cursor.link;
	}
	
	/**
	 * 
	 * @param head
	 * @return linked list in reverse
	 * uses recursion to print linked list in reverse
	 */
	public static IntNode reverse (IntNode head) {
		if (head == null) {
			return null;
		}
		reverse(head.link);
		System.out.print(head.data + "->");
		return head;
	}
	public static boolean hasCycle(IntNode head) { 
	    IntNode cursor = head;
	    if (head == null) {
	    	return true; 
	    }
	    cursor = head.link; 
	    while (cursor != null && cursor != head) {
	    	cursor = cursor.link; 
	    }
	    return (cursor == head); 
	} 
}

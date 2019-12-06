public class DoublyLinkedListDummy{
  private DIntNode head; //variables
  private DIntNode tail;

public static void main(String[] args) {
    //test cases
    DoublyLinkedListDummy list = new DoublyLinkedListDummy();
		list.addEnd(15);
		list.addEnd(16);
		list.addEnd(17);
		list.addEnd(18);
		list.addEnd(15);
		System.out.println(list);
		list.removeFromHead();
    list.addEnd(16);
		System.out.println(list);
		System.out.println("The number of occurrences of element is " + list.countOccurences(16) + ".");
    list.removeAll(16);
    System.out.println(list);
    list.addEnd(19);
    list.addEnd(22);
    System.out.println("Sublist: " + list.subList(1, 3));
    list.addEnd(22);
    System.out.println(list.listLength());
    list.printStatistics();
  }

  public DoublyLinkedListDummy () { //list constructor
		head = new DIntNode(0);
		tail = new DIntNode(0);
		tail.setPrev(head);
		head.setNext(tail);	
	}
	public DIntNode getHead() { //returns head
		return head;
	}

	public void setHead(DIntNode head) { //sets head
		this.head = head;
	}

	public DIntNode getTail() { //returns tail
		return tail;
	}

	public void setTail(DIntNode tail) { //sets tail
		this.tail = tail;
	}
	public void addEnd(int element) {   //adds new element to the end of the list, complexity: O(1)
        DIntNode newnode = new DIntNode(element);
        	newnode.setNext(tail);      // set new.next to tail
            newnode.setPrev(tail.getPrev());  // set new.prev to prior last
            tail.getPrev().setNext(newnode);  // set prior last.next to new last
            tail.setPrev(newnode);       // set tail.prev to new last
  }
	public void removeFromHead() { //removes node from head, complexity: O(1)
		if (head.getNext() != tail) {
			DIntNode cursor = head;
			DIntNode cursor2 = head;
			cursor.setNext(cursor.getNext().getNext());
			cursor2.getNext().setPrev(head);
	    }
	}
	public String toString() { //prints string form of list, complexity: O(n)
		StringBuilder sb = new StringBuilder("");
		DIntNode cursor = head.getNext();
		DIntNode cursor2 = tail.getPrev();
		while (cursor != tail) {
			sb.append(cursor.getData() + "<->");
			cursor = cursor.getNext();
		}
		sb.append("\n");
		while (cursor2 != head) {
			sb.append(cursor2.getData() + "<->");
			cursor2 = cursor2.getPrev();
		}
		return sb.toString();
	}

	public int countOccurences(int e) { //counts occurences of specified element in the list, complexity: O(n)
		DIntNode cursor = head;
		int count = 0;
		while (cursor.getNext() != null) {
      cursor = cursor.getNext();
			if (cursor.getData() == e) {
				count++;
				// cursor = cursor.getNext();
			}
		}
		return count;
	}
	public boolean removeAll(int e) { //removes all occurences of specified element, complexity: O(n)
		DIntNode cursor = head;
		// DIntNode prev = null;
		while (cursor.getNext() != null) {
      cursor = cursor.getNext();
      if (cursor.getData() == e){
        cursor.getPrev().setNext(cursor.getNext());
        cursor.getNext().setPrev(cursor.getPrev());
      }
    }
		return true;
	}
	public DoublyLinkedListDummy subList(int beginIdx, int endIdx) { //creates sublist from specified indexes, complexity: O(n)
		DoublyLinkedListDummy newlist = new DoublyLinkedListDummy();
		// DIntNode sNode = new DIntNode();
		int counter = 0;
		DIntNode cursor = head;
		while (cursor.getNext() != null) {
      cursor = cursor.getNext();
			if(counter >= beginIdx && counter <= endIdx){
				newlist.addEnd(cursor.getData());
			}
			// sNode = sNode.getNext();
			counter++;
		}
		return newlist;
	}
  public int listLength(){ //length of the list, complexity: O(n)
    int count = 0;
    DIntNode cursor = head;
    while (cursor.getNext() != null){
      cursor = cursor.getNext();
      count++;
    }
    return count;
  }
	public void printStatistics() { //prints occurences of each element inside the list, complexity: O(n)
    DIntNode cursor = head;
    int i = 0;
    int a = 0;
    int [] listCopy = new int[listLength()];
    DoublyLinkedListDummy usedNumbers = new DoublyLinkedListDummy();
		while (cursor.getNext() != null){
      cursor = cursor.getNext();
      listCopy[i] = cursor.getData();
      i++;
    }
    while (listCopy.length > a){
      if (usedNumbers.countOccurences(listCopy[a]) == 0){
        System.out.println(listCopy[a] + " occurences: " + countOccurences(listCopy[a]));
      }
      usedNumbers.addEnd(listCopy[a]);
      a++;
    }
	}
}
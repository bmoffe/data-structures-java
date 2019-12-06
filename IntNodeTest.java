package lab4;

/**
 * 
 * @author Brianna Moffett
 *
 */

public class IntNodeTest {

	public static void main(String[] args) {
		IntNode list = new IntNode(1,null); //creating new linked list node
		/**
		 * @param none
		 * test cases
		 */
		list.addNodeAfterThis(4);
		list.addNodeAfterThis(3);
		list.addNodeAfterThis(2);
		System.out.println(list.toString());
		System.out.println("The length of the list is " + list.ListLength() + ".");
		list.removeNodeAfterThis();
		System.out.println(list.toString());
		System.out.println("The length of the list is " + list.ListLength() + ".");
		System.out.println("Searching for value: " + IntNode.search(list, 2));
		System.out.println("Searching for value: " + IntNode.search(list, 10));
	}
}
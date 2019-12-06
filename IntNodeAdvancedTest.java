import lab4.IntNode;

//Brianna Moffett
//IntNodeAdvancedTest.java
//09.30.19
//CS 278
public class IntNodeAdvancedTest {
	public static void main(String[] args) {
		IntNode list = new IntNode(1,null); //creating new linked list node
		IntNode list2 = new IntNode(1, null); //creating second linked list node (only used as test case for copyOdd method)
		/**
		 * @param IntNode objects, integers
		 * test cases
		 */
		list.addNodeAfterThis(4); //adding nodes to list
		list.addNodeAfterThis(3);
		list.addNodeAfterThis(2);
		System.out.println(list.toString()); //printing list
		System.out.println("The length of the list is " + list.ListLength() + "."); //printing the length of the list
		list.removeNodeAfterThis(); //removing a node
		System.out.println(list.toString()); //printing list again
		System.out.println("The length of the list is " + list.ListLength() + "."); //printing the length of the list again (to ensure remove method works properly)
		System.out.println("Searching for value: " + IntNode.search(list, 2)); //searching for value 2
		System.out.println("Searching for value: " + IntNode.search(list, 10)); //searching for value 10
		System.out.println(IntNode.hasCycle(list)); //checking if list is cyclical
		System.out.println(IntNode.reverse(list)); //printing list in reverse
		IntNode.removeall(list, 3); //removing all instances of 3
		System.out.println(list.toString()); //printing list again to check if removeall method works properly
		System.out.println(IntNode.sumLast(list, 1)); //testing sumLast
		System.out.println(IntNode.listEvenNumber(list)); //testing listEvenNumber
		System.out.println(IntNode.copyOdd(list2)); //testing copyOdd by copying odd values from old IntNode object to new IntNode object
	}
}

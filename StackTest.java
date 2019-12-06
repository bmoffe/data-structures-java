import java.util.Stack;
//Brianna Moffett
//CS 272
//10.17.19
//lab 8
public class StackTest<E> {

	public static void main(String[] args) {
		//each version of the created stacks (LinkedStack and ArrayStack) will have 2 test cases, one with integers, and one with strings
		LinkStack list = new LinkStack(); //linked list stack test cases
		list.push( "How are you doing today?");
		list.push( "I don't know, not too well.");
		list.push( "What happened?");
		list.push( "I didn't do too well on my exam...");
		list.push("Oh, that's too bad. You'll do better next time!");
		list.push("I sure hope so.");
		list.push("Do you want to study together for the next one?");
		list.push( "Maybe having someone to study with will help.");
		list.push( "Great. Let's meet up tomorrow after class.");
		list.push( "Sounds groovy!");
		System.out.println("First Case!");
		list.displayContents();
		System.out.println("\n");
		System.out.println("Testing size:" + list.size());
		System.out.println("");
		System.out.println(list.top());
		list.pop();
		System.out.println("\n");
		list.displayContents();
		System.out.println("\n");
		System.out.println("Testing size: " + list.size());
		System.out.println("The list is empty? " + list.isEmpty());
		
		LinkStack list2 = new LinkStack(); //linked list stack test cases
		list2.push(1);
		list2.push(2);
		list2.push(3);
		list2.push(4);
		list2.push(5);
		list2.push(6);
		list2.push(7);
		list2.push(8);
		list2.push(9);
		list2.push(10);
		list2.push(11);
		list2.push(12);
		list2.push(13);
		list2.push(14);
		list2.push(15);
		System.out.println("Second case!");
		list2.displayContents();
		System.out.println("\n");
		System.out.println("Testing size:" + list2.size());
		System.out.println("");
		System.out.println(list2.top());
		list2.pop();
		System.out.println("\n");
		list2.displayContents();
		System.out.println("\n");
		System.out.println("Testing size: " + list2.size());
		System.out.println("The list is empty? " + list2.isEmpty());
		
		//arraystack test
		ArrayListStack listArrayString = new ArrayListStack();
		listArrayString.push(1);
		listArrayString.push(2);
		listArrayString.push(3);
		listArrayString.push(4);
		listArrayString.push(5);
		listArrayString.push(6);
		listArrayString.push(7);
		listArrayString.push(8);
		listArrayString.push(9);
		listArrayString.push(10);
		listArrayString.push(11);
		listArrayString.push(12);
		listArrayString.push(13);
		listArrayString.push(14);
		listArrayString.push(15);
		System.out.println("Second arraystack case!");
		listArrayString.displayContents();
		System.out.println("\n");
		System.out.println("Testing size:" + listArrayString.size());
		System.out.println("");
		System.out.println(listArrayString.top());
		listArrayString.pop();
		System.out.println("\n");
		listArrayString.displayContents();
		System.out.println("\n");
		System.out.println("Testing size: " + listArrayString.size());
		System.out.println("The list is empty? " + listArrayString.isEmpty());
		
		ArrayListStack listArrayString2 = new ArrayListStack();
		listArrayString2.push("You seem happier than earlier!");
		listArrayString2.push("Yeah, I'm really ecstatic!");
		listArrayString2.push("Why for?");
		listArrayString2.push("I got my other exam grades back, and I passed both!");
		listArrayString2.push("Hey, congrats! I'm proud of you!");
		listArrayString2.push("Thanks.");
		listArrayString2.push("Well, I have to get going.");
		listArrayString2.push("Aaw, that's too bad. See you around!");
		listArrayString2.push("Goodbye!");
		listArrayString2.push("(This is a conversation ender.)");
		System.out.println("First arraystack case!");
		listArrayString2.displayContents();
		System.out.println("\n");
		System.out.println("Testing size:" + listArrayString2.size());
		System.out.println("");
		System.out.println(listArrayString2.top());
		listArrayString2.pop();
		System.out.println("\n");
		listArrayString2.displayContents();
		System.out.println("\n");
		System.out.println("Testing size: " + listArrayString2.size());
		System.out.println("The list is empty? " + listArrayString2.isEmpty());
	
	}
}

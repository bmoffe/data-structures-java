package lab10;
import java.util.Scanner;
import java.lang.Math;
//Brianna Moffett
//CS 272
//11.06.19
//RecursiveQuestion.java
public class RecursiveQuestion {

	public static void main(String[] args) {
		int n = 9;
		int patternvariable = 8;
		System.out.println("Testing fibonacci sequence: " + FibBinaryRecursion(n));
		int diskNo = 4;
		System.out.println("");
		System.out.println("Testing towers of Hanoi algorithm:");
		TowersOfHanoi(diskNo, 'A', 'B', 'C');
		Scanner scnr = new Scanner (System.in);
		System.out.println("Enter the number you wish to convert: ");
		int binTest = scnr.nextInt();
		System.out.println("The binary equivalent of " + binTest + " is: ");
		BinaryPrint(binTest);
		System.out.println("");
		System.out.println(showCallLevel(4, 1));
		Pattern(patternvariable);
	}
	public static int FibBinaryRecursion(int k) { //returns the nth Fibonacci number for a given number k, where k is > 1
		if (k <= 1) {
			return k;
		}
		return FibBinaryRecursion(k - 1) + FibBinaryRecursion(k - 2);
	}
	public static void TowersOfHanoi (int k, char beforePos, char afterPos, char auxiliaryPos) { //solves the Towers of Hanoi game with 3 disks and 3 pegs
		if (k <= 1) {
			System.out.println("Move disk 1 from " + beforePos + " to " + afterPos + "."); //moves disk 1 from its current position to a new position
			return;
		}
		TowersOfHanoi(k - 1, beforePos, afterPos, auxiliaryPos); //moving the disks around using recursive call
		System.out.println("Move disk from " + beforePos + " to " + afterPos + "."); //displaying the move
		TowersOfHanoi(k - 1, auxiliaryPos, afterPos, beforePos); //moving the disks around again using recursive call
	}
	public static String showCallLevel(int l, int currlvl) { //prints the call level of the function; i.e. where in the recursive function are we?
		String level1string = "";
		String level2string = "";
		for (int i = 0; i < currlvl; i++) { 
			level1string += " "; //used as a tab for the output
		}
		if (l <= 0 || currlvl <= 0) {
			return "";
		}
		if (currlvl <= l) { //printing the call level on the first round of calls
			level2string += level1string + "call level: " + currlvl + "x." + "\n" + showCallLevel(l, currlvl +1);
		}
		if (l >= currlvl) { //printing the call level on the last round of calls
			level2string += level1string + "call level: " + currlvl + "y." + "\n";
		}
		return level2string;
	}
	public static void BinaryPrint(int n) { //printing binary equivalent of a number gained from user input
		if (n < 0) {
			throw new IllegalArgumentException ("Positive numbers only."); //numbers must not be negative!
		}
		if (n == 0) { //if n is 0, print 0
			System.out.print(0);
		}
		if (n > 0) { //recursive call to print the bits
			BinaryPrint(n / 2);
			System.out.print(n % 2);
		}
	}
	//set of functions used to print the fractal pattern from the textbook
	public static boolean PowerOfTwo (int n) {
		if ((n &(n-1)) == 0 && n != 1) {
			return true;
		}
		else {
			return false;
		}
	}
	public static int Stars(int n) { //determines the number of stars we need to print
		int i = n;
		int answer = 0;
		while (i%2 == 0) {
			i/=2;
			answer++;
		}
		return (int) Math.pow(2, answer);
	}
	public static int Spaces(int n) { //determines the number of spaces we need to print
		if (PowerOfTwo(n) == true) {
			return 0;
		}
		else {
			return (n-1)/2;
		}
	}
	public static void Print(int n) { //prints the spaces and stars
		int sp;
		sp = Spaces(n);
		for (int i = 1; i <= sp; i++) {
			System.out.print(" ");
		}
		int st = Stars(n);
		for (int i = 1; i <= st; i++) {
			System.out.print("* ");
		}
	}
	public static void Pattern(int n) { //calls the Print function to print the fractal pattern
		int sp;
		for (int i = 1; i <= n; i++) {
			Print(i);
			System.out.print("\n");
		}
		sp = n/2;
		for (int i = 1; i <= n - 1; i++) {
			for (int j = 1; j <= sp; j++) {
				System.out.print(" ");
			}
			Print(i);
			System.out.print("\n");
		}
	}
}

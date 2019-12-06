import java.util.*;
//Brianna Moffett
//CS 272
//11.25.19
//search.java
public class search {
	public static void main(String[] args) {
		int [] array1 = new int [10];
		System.out.print("[");
		int val = 1;
		for(int i = 0; i < array1.length; i++) {
			array1[i] = val;
			System.out.print(val + ",");
			val++;
		}
		System.out.print("]");
		System.out.println();
		System.out.println(binarySearch(array1, 2));
	}
	public static int binarySearch(int[] A, int e) { //searches through the array for a specified key
        int low = 0;
        int high = A.length - 1;
        while(low < high) {
            int mid = (low + high) / 2;
            if(A[mid] == e) {
                return mid;
            }
            else if(A[mid] < e) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}

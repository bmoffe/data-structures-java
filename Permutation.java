package lab10;
//Brianna Moffett
//CS 272
//11.06.19
//Permutation.java
public class Permutation {

	public static void main(String[] args) {
		int [] testarr = new int [5];
		for (int i = 0; i < testarr.length; i++) {
			testarr[i] = i;
		}
		Permute(testarr);
	}
	public static void Permute(int [] arr) { //separate function that calls the function that performs the permutation; also serves as a way to test that permutation function is actually working as intended
		permutationFun(arr, 0);
	}
	private static void permutationFun(int [] arr, int index) { //performs the permutation of the numbers in the array
		if (index >= arr.length - 1) { //if index is larger than last element's index, print formatting characters
			System.out.print("[");
			for (int i = 0; i < arr.length - 1; i++) {
				System.out.print(arr[i] + ", ");
			}
			if (arr.length > 0) { //if length of array is greater than 0, print last element of array
				System.out.print(arr[arr.length - 1]);
			}
			System.out.println("]"); //print ending format character
		}
		for (int i = index; i < arr.length; i++) { //swaps the elements of the array around
			int temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
			
			permutationFun(arr, index + 1); //recursive call to perform the swap all over again
			
			temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
		}
	}
}

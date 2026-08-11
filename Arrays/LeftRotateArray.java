/*
Problem:
Left rotate an array by one position

Approach:
We will take the value at 0th index and keep it in an temp variable and will make all the elements to shift towards 1 position left and at last we add the temp value at the last position.

Time Complexity:
O(N)

Space Complexity:
O(1)
*/

package Arrays;

public class LeftRotateArray {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
		int size = arr.length;
		
		int [] answer = new int [size];
		
		answer = leftshift(arr);
		
		System.out.println();
		System.out.print("Array after Left rotate by one position :");
		
		for(int i = 0; i < size ; i++){
			System.out.print(" " + answer[i]);
		}
		
		System.out.println();
	}
  
	public static int[] leftshift(int[] arr) {
		
		int size = arr.length;
		int temp = arr[0];
		
		for(int i = 0; i < arr.length - 1; i++){
			arr[i] = arr[i + 1];
		}
		
		arr[size - 1] = temp;
		
		return arr;
	}
}
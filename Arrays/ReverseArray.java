/*
Problem:
Reverse the array

Approach:
Traverse the array and maintain the start and end variable and swap the array values until the Start < end 

Time Complexity:
O(N)

Space Complexity:
O(1)
*/

package Arrays;

public class ReverseArray {

    public static void main(String[] args) {

        int[] arr = {10, 5, 20, 8, 15, 18};

		int start = 0;
		int end = arr.length - 1;
		
		while(start < end ){
		
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		
		start++;
		end--;
		
		}
		
		System.out.print("Reversed Array is :");
		
		for(int i = 0; i < arr.length ; i++) {
		System.out.print(" " + arr[i]);
		}
        
    }
}
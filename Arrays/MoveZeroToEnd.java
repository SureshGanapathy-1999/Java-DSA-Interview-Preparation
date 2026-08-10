/*
Problem:
Move All zero's to end

Approach:
We will have two pointer approach to solve this and both will start from index = 0 and traverse till end and start variable will check for non-zero element and end for zero element while encountering the same we will make a swap and move the zero element to the right side.

Time Complexity:
O(N)

Space Complexity:
O(1)
*/

package Arrays;

public class MoveZeroToEnd {

    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 3, 12, 18};
		int size = arr.length;
		
		int [] answer = new int [size];
		
		answer = checkZero(arr);
		
		System.out.println();
		System.out.print("Array after moving all the zero to end :");
		
		for(int i = 0; i < size ; i++){
			System.out.print(" " + answer[i]);
		}
		
		System.out.println();
	}
  
	public static int[] checkZero(int[] arr) {
    
		int end = 0;

		for (int start = 0; start < arr.length; start++) {
			
			if(arr[start] != 0){
				
				if(start != end){
					int temp = arr[start];
					arr[start] = arr[end];
					arr[end] = temp;
				}
				
				end++;
			}
		}
		return arr;	
	}
}
/*
Problem:
Remove Duplicates from sorted Array

Approach:
Traverse the entire array and check if the current element and the next element is same, if same continue and dont count and if both are different add it to the count variable and return the count of unique element at the end.

Time Complexity:
O(N)

Space Complexity:
O(1)
*/

package Arrays;

public class RemoveDuplicateInArray {

    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 2, 3, 18};
		
		int answer = removeDuplicate(arr);
		
		System.out.println("Unique element in the array is :" + answer);
	}
  
	public static int removeDuplicate(int[] arr) {
    
		if (arr.length == 0) {
			return 0; 
		}
		int count = 1;
		
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[i -1]) {
				arr[count] = arr[i];
				count++;
			}
		}
		
		return count;
		}
}
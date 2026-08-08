/*
Problem:
Check if Array is sorted or not;

Approach:
Traverse the entire array and check if the previous element is smaller than the current element, if the complete array is satisfied with the condition then array is sorted 

Time Complexity:
O(N)

Space Complexity:
O(1)
*/

package Arrays;

public class SortCheck {

    public static void main(String[] args) {

        int[] arr = {1, 5, 20, 25, 35, 180};
		
		boolean status = isSorted(arr);
			
			if(status == false){
				System.out.println("Array is not Sorted");
			}else{
		System.out.println();
		System.out.println("Array is Sorted");
		}
		}
		
  
	
	public static boolean isSorted(int[] arr) {
    
		if (arr.length <= 1) {
			return true; 
		}
		
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] > arr[i]) {
				return false;
			}
		}
		
		return true;
		}
}
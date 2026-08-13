/*
Problem:
Check Consecutive One's

Approach:
We have traverse through the entire array and maintain two variable count and max so whenever we get one in the array we increment the count by 1 and do the same until we encounter an zero, movement we hit zero we have to add the count value to max and maintain checking whether the value of Max is always the maximum and make the count = 0.

Time Complexity:
O(N)

Space Complexity:
O(1)
*/

package Arrays;

public class CheckConsecutiveOne {

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0};
		
		int size = arr.length;
		
		int Answer = Check(arr);
		
		System.out.println();
		System.out.print("Maximum consecutive one is : " + Answer);
		System.out.println();
		
	}
	
	public static int Check(int arr []){
	
	int count = 0;
	int max = 0;
	
	int size = arr.length;
	
	if(size == 0){
	return 0;
	}
	
	for(int i = 0; i < size ; i++){
	
		if(arr[i] == 1){
		count++;
		}
		else{
		max = Math.max(count, max);
		count = 0;
		}
		
	}
  	max = Math.max(count, max);
	
	return max;
	}
}
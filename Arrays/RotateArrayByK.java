/*
Problem:
Left rotate an array by K position

Approach:
Here we will rotate the entire array and then we will rotate the array from 0 to k-1 and again rotate from k to N-1 of the array so that we can acheive the K rotation

Time Complexity:
O(N)

Space Complexity:
O(1)
*/

package Arrays;

public class RotateArrayByK {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
		int k = 8;
		
		int size = arr.length;
		
		if (k > size){
			k = k % size;
		}
		
		// System.out.println(k);
		
		int answer [] = new int [size] ;
		
		answer = reverse(arr,0,size-1);
		answer = reverse(answer,0, k-1);
		answer = reverse(answer,k , size -1);
		
		System.out.println();
		System.out.print("Array after rotate by K position :");
		
		for(int i = 0; i < size ; i++){
			System.out.print(" " + answer[i]);
		}
		
		System.out.println();
	}
  
	
	public static int[] reverse(int arr[], int start, int end){
		
		while(start < end ){
		
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		
		start++;
		end--;
		
		}
	
		return arr;
	}	
}
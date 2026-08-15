/*
Problem:
Build Prefix Sum array

Approach:
For creating the prefix sum array we need to start from the 2nd element in the array and need to add the previous element with the current element and do the same for the rest of the element too.

Time Complexity:
O(N)

Space Complexity:
O(1)
*/

package Arrays;

public class PrefixSumArray {

    public static void main(String[] args) {

	int [] Arr = {1,2,3,4,5};
	
	System.out.println();
	System.out.print("Array before Prefix Sum : ");
	for(int i = 0; i < Arr.length; i++){
		System.out.print(" "+Arr[i]);
	}
	
	System.out.println();
	for(int i = 1; i < Arr.length; i++){
		Arr[i] = Arr[i] + Arr[i - 1];
	}
	
	System.out.print("Array After Prefix Sum : ");
	for(int i = 0; i < Arr.length; i++){
		System.out.print(" " + Arr[i]);
	}
	
	System.out.println();
	
	}
}







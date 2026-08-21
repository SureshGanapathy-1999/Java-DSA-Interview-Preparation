/*
Problem Description

Given an integer array A of size N. You can remove any element from the array in one operation.
The cost of this operation is the sum of all elements in the array present before this operation.

Find the minimum cost to remove all elements from the array.

Problem Constraints

0 <= N <= 1000
1 <= A[i] <= 103

 Given array A = [2, 1]
 Remove 2 from the array => [1]. Cost of this operation is (2 + 1) = 3.
 Remove 1 from the array => []. Cost of this operation is (1) = 1.
 So, total cost is = 3 + 1 = 4.
 
 Approach
 
 1. First we will sort the array.
 2. Reverse the sorted array.
 3. Maintain the an variable Cost to add the cumulative sum. 
 4. Travere the entire array and add the value of A[i] * (i + 1) into the cost and return the cost for removing all the elements


TC: N * Log N
SC: O(1)
*/

package Sorting;
import java.util.*;

public class ElementsRemoval {

    public static void main(String[] args) {

			int [] Arr = {5,3,7,2,6,4}; 
			
			System.out.println();
			
			System.out.println("Array : " + Arrays.toString(Arr));
			
			int answer = solve(Arr);
			
			System.out.println();
			
			System.out.println("Total cost to remove the all the elements : " + answer);
	}
	
	// This method is used for calculating the total cost for removing all the elements
	
	public static int solve(int[] A) {
		
		Arrays.sort(A);
		
		int size = A.length;
		
		reverse(A);
		
		int CostofRemoval = 0;
		
		for(int i = 0 ; i < size ; i++){
			CostofRemoval += A[i] * (i + 1);
		}
		return CostofRemoval;	
	}
	
	// logic for returning the Reversed Array
	public static int[] reverse(int A []){
		
		int start = 0;
		int end = A.length - 1;
		
		while(start < end){
			int temp = A[start];
			A[start] = A[end];
			A[end] = temp;
			start++;
			end--;
		}
		
		System.out.println();
		System.out.println("Array After reversing: " + Arrays.toString(A));
		
		return A;
		
	}
 	
}

/*

Dry Run:

Arr = {5,3,7,2,6,4}; 

1. Arrays.sort

Arr = {2,3,4,5,6,7}

2. Reverse the array

Arr = {7,6,5,4,3,2}

3. for (i = 0 ; i < size; i++){
	cost += A[i] * (i + 1);
}

i		     cost		     condition(A[i] * (i + 1))	    Updated_cost

0         	  0   				7 * (0 + 1) -> 7				7
1			  7  				6 * (1 + 1) -> 12				19
2			  19				5 * (2 + 1) -> 15               34
3			  34 				4 * (3 + 1) -> 16 				50	
4			  50                3 * (4 + 1) -> 15				65
5			  65				2 * (5 + 1) -> 12				77

At the end we return the updated cost i.e = 77

*/
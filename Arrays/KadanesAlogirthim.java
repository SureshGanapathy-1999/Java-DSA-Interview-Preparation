
/*
Question: Maximum Possible SubArray sum

Approach:
1. Initialize sum and ans with the first element.
2. Traverse the array from index 1.
3. If sum becomes negative, reset it to 0.
4. Add the current element to sum.
5. Update ans with the maximum of ans and sum.
6. Return ans.

Logic:
A negative sum is discarded because it will reduce the sum of future subarrays.

TC: O(N)
SC: O(1)
*/

package Arrays;
import java.util.*;

public class KadanesAlogirthim {

    public static void main(String[] args) {
		int [] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		
		int ans = maxSubArray(A);
		
		System.out.println();
		
		System.out.println("Maximum Subarray sum is using kadane's Algorithim : " + ans);
	}

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int maxSubArray(final int[] A) {
			int sum = A[0];
			int ans = A[0];
			
			for(int i = 1; i < A.length; i++){
				
				if(sum < 0){
					sum = 0;
				}
				
				sum += A[i];
				
				if(sum > ans){
					ans = sum;
				}
			}
			return ans;
	}
}

/*

Dry Run
	  0, 1, 2, 3, 4
 A = [1, 2, 3, 4, -10]  output = 10
 
 i   sum   ans
 0    1     1
 1    3     3
 2    6     6
 3    10    10
 4    0     10
 
 return ans = 10
 
  0  1   2  3   4  5  6   7  8
[-2, 1, -3, 4, -1, 2, 1, -5, 4] 
 
i   sum   ans
if (sum < 0, sum =0)
0	0		 0
1	1		 1
2   0        1
3   4        4
4   3        4
5   5        5
6   6        6
7   1        6
8   5        6

 return ans = 6

 */
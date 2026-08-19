/*
Problem:
Subarray Sum Equals K

Approach:

We consider every possible starting index i.

For each i:
    1. Set sum = 0
    2. Extend the subarray from i to the right using j
    3. Add nums[j] to sum
    4. If sum == k, increment count

Time Complexity: O(N²)
Space Complexity: O(1)

*/

package Arrays;
import java.util.*;

public class SubarraySumEqualToK {

    public static void main(String[] args) {

			int [] Arr = {1,2,3,4};
			int k = 3;
			
			System.out.println();
			
			System.out.println("Array : " + Arrays.toString(Arr));
			
			int answer = solve(Arr, k);
			
			System.out.println();
			
			System.out.println("Total number of subarray who's sum equal to K : " + answer);
			}
	
public static int solve(int[] nums, int k) {

        int count = 0;

        for(int i = 0; i < nums.length; i++){
           int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if (sum == k){
                    count++;
                }
            }
        }
        return count;
    }
}



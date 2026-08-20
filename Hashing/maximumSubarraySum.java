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

package Hashing;
import java.util.*;

public class maximumSubarraySum {

    public static void main(String[] args) {

			int [] Arr = {1,5,4,2,9,9,9};
			int k = 3;
			
			System.out.println();
			
			System.out.println("Array : " + Arrays.toString(Arr));
			
			long answer = solve(Arr, k);
			
			System.out.println();
			
			System.out.println("Maximu sum of subarray who's length equal to K : " + answer);
	}


public static long solve(int[] nums, int k) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        long sum = 0;
        long maxSum = 0;

        // First window
        for (int i = 0; i < k; i++) {

            if (hm.containsKey(nums[i])) {
                int frequency = hm.get(nums[i]);
                hm.put(nums[i], frequency + 1);
            } else {
                hm.put(nums[i], 1);
            }

            sum += nums[i];
        }

        // Check first window
        if (hm.size() == k) {
            maxSum = sum;
        }

        // Move the window
        for (int i = k; i < nums.length; i++) {

            // Remove the element leaving the window
            int remove = nums[i - k];

            int frequency = hm.get(remove);

            if (frequency == 1) {
                hm.remove(remove);
            } else {
                hm.put(remove, frequency - 1);
            }

            sum -= remove;

            // Add the new element
            int add = nums[i];

            if (hm.containsKey(add)) {
                int addFrequency = hm.get(add);
                hm.put(add, addFrequency + 1);
            } else {
                hm.put(add, 1);
            }

            sum += add;

            // Check whether all k elements are distinct
            if (hm.size() == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}

/*

Question: find the majority element

Approach:

1. Use Boyer-Moore Voting Algorithm.
2. Keep a candidate element and its count.
3. If the current element matches the candidate, increase count.
4. Otherwise, decrease count.
5. When count becomes 0, choose a new candidate.
6. Finally, count the candidate's frequency to confirm
   whether it appears more than N/2 times.

TC: O(N)
SC: O(1)
*/


package Arrays;
import java.util.*;

public class MajorityElement {

    public static void main(String[] args) {
		int A [] = {2, 2, 1, 1, 1, 2, 2, 2};
		
		int ans = solve(A);
		
		System.out.println();
		System.out.println("Majority element is : " + ans );
		
	}

    public static int solve(final int[] A) {
		
		int n = A.length;
		int ans = n/2;
		int majority_element = A[0];
		int count = 1;
		
		for(int i = 1; i < n-1; i++){
			
			if(A[i] != majority_element){
				count--;
			}
			
			if(A[i] == majority_element){
				count++;
			}
			
			if(count == 0){
				majority_element = A[i+1];
				count = 1;
			}
			
		}
		
		int frequency = 0;
		
		for(int i = 0; i < n ; i++){
			if(A[i] == majority_element){
				frequency++;
			}
 		}
		
		if(frequency > ans){
			return majority_element;
		}
		
		return -1;
    }
}

/*

Dry run

A = [2, 2, 1, 1, 1, 2, 2]

Candidate = 2
Count = 1

2 → same as candidate
Count = 2

1 → different
Count = 1

1 → different
Count = 0

Count becomes 0 → choose new candidate

Candidate = 1
Count = 1

1 → same
Count = 2

2 → different
Count = 1

2 → different
Count = 0

atlast we have 2 in majority element so we check for the frequency for the same and compare whether it is more than n/2 times

*/

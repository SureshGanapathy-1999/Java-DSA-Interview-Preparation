
/*
Question: Beggars Outside Temple

Approach:

1. Create an answer array of size A initialized with 0.
2. For every query, convert start and end from 1-based to 0-based indexing.
3. Add value at the start index.
4. Subtract value at end + 1 index to stop its effect.
5. If end + 1 is outside the array, skip the subtraction.
6. Process all queries using the Difference Array technique.
7. Calculate the Prefix Sum of the answer array.
8. The final array represents the amount received by each beggar.

Logic:

Instead of updating every element in a range, mark where the value starts and where it stops using a Difference Array. Then use Prefix Sum to get the final values.

TC: O(N + A)

SC: O(A)

*/


package Arrays;
import java.util.*;

public class BeggarOutsideTemple {

    public static void main(String[] args) {
		int A = 5;
		int [][]B = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
		
		int ans [] = new int [A];
		ans = solve(A,B);
		
		System.out.println();
		System.out.println(Arrays.toString(ans));
		
	}
	
    public static int[] solve(int A, int[][] B) {
		
		int [] ans = new int [A];
		
		int n = B.length;
		
		for(int i = 0; i < n ; i++){
			int start = B[i][0] - 1;
			int end = B[i][1] - 1;
			int value = B[i][2];
			
			ans[start] += value;
			
			if(end + 1 < A){
				ans[end + 1] -= value;
			}
		}
		
		// generate prefix sum array to get cumulative sum
		
		for(int i = 1; i < A ; i++){
			ans[i] = ans[i] + ans[i-1];
		}
		
		return ans;
    }
}

/*
Dry RUN

A = 5
B = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]

A = {0 0 0 0 0} 

iteration i = 0

start -> B[0][0] -> 0
end   -> B[0][1] -> 1
value -> B[0][2] -> 10

After adding the value check if end + 1 < n if yes add the negative of value to end+1 index

A = { 10 0 -10 0 0}


iteration i = 1 
start -> B[1][0] -> 1
end   -> B[1][1] -> 2
value -> B[1][2] -> 20

After adding the value check if end + 1 < n if yes add the negative of value to end+1 index

A = { 10 20 -10 -20 0}

iteration i = 2
start -> B[2][0] -> 1
end   -> B[2][1] -> 4
value -> B[2][2] -> 25

After adding the value check if end + 1 < n if yes add the negative of value to end+1 index

A = { 10 45 -10 -20 0}

if we take the prefix sum of below array

A = {10 55 45 25 25}

*/
/*
Approach:
1. Consider each element A[i][j] as the top-left-to-bottom-right
   corner of all possible submatrices containing it.
2. Number of ways to choose the top-left corner = (i + 1) * (j + 1).
3. Number of ways to choose the bottom-right corner = (row - i) * (col - j).
4. Total contribution of A[i][j] = TL * BR.
5. Add the contribution of every element to get the final answer.
6. Time Complexity: O(N * M)
7. Space Complexity: O(1)
*/

package Arrays;
import java.util.*;

public class SumOfAllSubMatrix {

    public static void main(String[] args) {
		int[][] A = {
			{1, 2, 3, 4},
			{5, 6, 7, 8},
			{9, 10, 11, 12},
			{13, 14, 15, 16}
			};
		
		int ans;
		ans = solve(A);
		
		System.out.println();
		System.out.println("Total sum of all Sub Matrix : " + ans);
		
	}
    public static int solve(int[][] A) {
		
		int row = A.length;
		int col = A[0].length;
		int total_sum = 0;
		
		for(int i = 0; i < row ; i++){
			
			for(int j = 0 ; j < col ; j++){
				
				int TL = (i+1) * (j+1);
				int BR = (row - i) * (col - j);
				int contribution = TL * BR;
				total_sum += A[i][j] * contribution;
			}
		}
		
		return total_sum;
    }
}

/*

Step 1: Element = 1

i = 0, j = 0

TL = (0 + 1) * (0 + 1)
   = 1

BR = (2 - 0) * (2 - 0)
   = 4

Contribution count = 1 * 4 = 4

Element contribution = 1 * 4 = 4

total_sum = 4

Step 2: Element = 2

i = 0, j = 1

TL = (0 + 1) * (1 + 1)
   = 2

BR = (2 - 0) * (2 - 1)
   = 2

Contribution count = 2 * 2 = 4

Element contribution = 2 * 4 = 8

total_sum = 4 + 8 = 12

Step 3: Element = 3

i = 1, j = 0

TL = (1 + 1) * (0 + 1)
   = 2

BR = (2 - 1) * (2 - 0)
   = 2

Contribution count = 2 * 2 = 4

Element contribution = 3 * 4 = 12

total_sum = 12 + 12 = 24

Step 4: Element = 4

i = 1, j = 1

TL = (1 + 1) * (1 + 1)
   = 4

BR = (2 - 1) * (2 - 1)
   = 1

Contribution count = 4 * 1 = 4

Element contribution = 4 * 4 = 16

total_sum = 24 + 16 = 40

*/
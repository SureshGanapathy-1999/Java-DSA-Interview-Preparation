/*
Approach:
1. Create an A x A matrix and initialize count = 1.
2. Maintain four boundaries: row_start, row_end, col_start, col_end.
3. Fill the matrix layer by layer in 4 directions:
   - Left → Right (Top wall)
   - Top → Bottom (Right wall)
   - Right → Left (Bottom wall)
   - Bottom → Top (Left wall)
4. After completing each wall, move the corresponding boundary inward.
5. Continue until all A*A elements are filled.
6. Time Complexity: O(A²)
7. Space Complexity: O(A²) — for the output matrix.
*/

package Arrays;
import java.util.*;

public class GenerateMatrix {

    public static void main(String[] args) {
		int A = 5;
		
		int [][] ans = new int [A][A];
		ans = solve(A);
		
		System.out.println();
		System.out.println("Array after adding zero's : " + Arrays.deepToString(ans));
		
	}
	
    public static int[][] solve(int A) {
		
		int [][] ans = new int [A][A];
		int count = 1;
		
		int multiply = A*A;
		
		int row_start = 0;
		int row_end = A-1;
		int col_start = 0;
		int col_end = A-1;
		
		while(count <= multiply){
			
			
			// generating value for top wall
			for(int i = col_start ; i <= col_end; i++){
				ans[row_start][i] = count;
				count++;
			}
			row_start++;
			
			// generating value for right wall
			for(int i = row_start ; i <= row_end; i++){
				ans[i][col_end] = count;
				count++;
			}
			col_end--;
			
			//generating value for bottom wall
			for(int i = col_end; i >= col_start; i--){
				ans[row_end][i] = count;
				count++;
			}
			row_end--;
			
			
			// generating value for left wall
			for(int i = row_end; i >= row_start ; i--){
				ans[i][col_start] = count;
				count++;
			}
			col_start++;
		}
		
		return ans;
    }
}

/*

Step 1: Top wall
1  2  3
.  .  .
.  .  .

row_start = 1


Step 2: Right wall
1  2  3
.  .  4
.  .  5

col_end = 1


Step 3: Bottom wall
1  2  3
.  .  4
7  6  5

row_end = 1


Step 4: Left wall
1  2  3
8  .  4
7  6  5

col_start = 1


Step 5: Inner element
1  2  3
8  9  4
7  6  5

Final Answer:
1  2  3
8  9  4
7  6  5

*/
/*
Approach:
1. Traverse the matrix and whenever we find 0, mark all non-zero elements
   in its row and column as -1.
2. Use -1 as a temporary marker so newly marked cells are not treated as
   original zeros.
3. After traversal, convert all -1 values to 0.
4. Time Complexity: O((N * M) * (N + M))
5. Space Complexity: O(1) — no extra matrix/array used.
*/

package Arrays;
import java.util.*;

public class MakeRowColumnZero {

    public static void main(String[] args) {
		int[][] A = {
			{5, 12, 7, 9},
			{18, 3, 0, 6},
			{11, 20, 8, 14},
			{4, 0, 10, 2}
			};
			
		int r = A.length;
		int c = A[0].length;
		
		int [][] ans = new int [r][c];
		ans = solve(A);
		
		System.out.println();
		System.out.println("Array after adding zero's : " + Arrays.deepToString(ans));
		
	}
	
    public static int[][] solve(int[][] A) {
		int row = A.length;
		int column = A[0].length;
		
		for(int i = 0; i < row; i++){
			
			for(int j = 0; j < column; j++){
				
				if(A[i][j] == 0 ){
					
					// run a loop for making row as -1
					
					for(int r = i, c = 0; c < column; c++){
						if(A[r][c] != 0 ){
							A[r][c] = -1;
						}
					}
					
					// run a loop for making column as -1
					
					for( int c = j , r = 0; r < row; r++ ){
						if(A[r][c] != 0 ){
							A[r][c] = -1;
						}
					}
					
				}
				
			}
		}
		
		// make all the -1 to zero's
		
		for(int i = 0; i < row; i++){
			
			for(int j = 0 ; j < column; j++){
				
				if(A[i][j] == -1){
					A[i][j] = 0;
				}
				
			}
		}
		
		return A;
    }
}

/*
Step 1:
Find 0 at A[1][1]

Step 2:
Mark row 1 as -1:
1   2   3
-1  0  -1
7   8   9

Step 3:
Mark column 1 as -1:
1   -1  3
-1   0   -1
7   -1  9

Step 4:
Continue scanning the matrix.

Step 5:
Convert all -1 to 0:

1  0  3
0  0  0
7  0  9

Final Answer:
1  0  3
0  0  0
7  0  9
*/
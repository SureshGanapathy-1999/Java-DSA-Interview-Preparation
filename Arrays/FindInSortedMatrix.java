/*
Approach:
1. Start from the top-right corner of the matrix.
2. If the current element equals B, return its encoded position.
3. If current element is greater than B, move left.
4. If current element is smaller than B, move down.
5. Continue until B is found or we go outside the matrix.
6. Return -1 if B is not present.
7. Time Complexity: O(N)
8. Space Complexity: O(1)
*/

package Arrays;
import java.util.*;

public class FindInSortedMatrix {

    public static void main(String[] args) {
		int[][] A = {
			{1, 2, 3, 4},
			{5, 6, 7, 8},
			{9, 10, 11, 12},
			{13, 14, 15, 16}
			};
		
		int B = 10;
		
		int ans ;
		ans = solve(A, B);
		
		System.out.println();
		System.out.println("Check if element is found, if not found -1 : " + ans);
		
	}
    public static int solve(int[][] A, int B) {
		
		int row = A.length;
		int col = A[0].length;
		int i = 0;
		int j = col - 1;
		
		while( i < row && j >= 0){
			if(A[i][j] == B ){
				return ((i+1) * 1009 + (j+1));
			}else if (B < A[i][j]){
				j--;
			}else{
				i++;
			}
		}
		
		return -1;
    }
}

/*

Step 1:
Current = 7
7 > 6
Move left

i = 0
j = 1


Step 2:
Current = 4
4 < 6
Move down

i = 1
j = 1


Step 3:
Current = 5
5 < 6
Move down

i = 2
j = 1


Step 4:
Current = 6
6 == 6

Element found.


Step 5:
Return

(i + 1) * 1009 + (j + 1)

= (2 + 1) * 1009 + (1 + 1)
= 3 * 1009 + 2
= 3029

Final Answer:
3029

*/

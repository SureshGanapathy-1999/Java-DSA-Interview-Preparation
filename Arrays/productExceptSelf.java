/*
Problem:
Find productExceptSelf of the array

Approach:

For each index:

Answer[i] = Left Product × Right Product

First pass: Traverse left to right and store the product of elements on the left.
Second pass: Traverse right to left and multiply by the product of elements on the right.
This avoids using division.

Time Complexity: O(N)
Space Complexity: O(1) auxiliary space

*/

package Arrays;
import java.util.*;

public class productExceptSelf {

    public static void main(String[] args) {

			int [] Arr = {1,2,3,4};
			
			int size = Arr.length;
			
			int answer [] = new int [size];
			
			System.out.println();
			System.out.print("Array : ");
			for(int i = 0; i < Arr.length; i++){
				System.out.print(" "+Arr[i]);
			}
			
			System.out.println();
			
			answer = solve(Arr);
			
			System.out.println();
			
			System.out.println("Array after product itself : " + Arrays.toString(answer));
			}
	
	public static int[] solve(int[] nums) {
        int size = nums.length;
        int ans [] = new int [size];

        int prodL = 1;
        int prodR = 1;

        
        for(int i = 0; i < size ; i++ ){
            ans[i] = prodL;
            prodL = prodL * nums[i];
        }

        for(int i = size - 1; i >= 0; i-- ){
            ans[i] = prodR * ans[i];
            prodR = prodR * nums[i];
        }

        return ans;
    }
}







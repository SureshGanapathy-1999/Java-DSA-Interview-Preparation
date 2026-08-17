/*
Problem:
Find EquilibriumIndex of the array

Approach:

First, convert the array into a prefix sum array so that the sum of elements on the left can be calculated in O(1).
For each index, calculate:
Left Sum = prefix sum before the current index.
Right Sum = total sum − current prefix sum.
If leftSum == rightSum, that index is the Equilibrium Index.
Return the index; if no such index exists, return -1.

Time Complexity:
O(N)

Space Complexity:
O(1)
*/

package Arrays;

public class EquilibriumIndex {

    public static void main(String[] args) {

			int [] Arr = {2,3,-1,8,4};
			
			System.out.println();
			System.out.print("Array : ");
			for(int i = 0; i < Arr.length; i++){
				System.out.print(" "+Arr[i]);
			}
			
			System.out.println();
			
			int answer = findMiddleIndex(Arr);
			
			System.out.println();
			
			if(answer != -1){
				System.out.println("Middle index is : " + answer);
			}else{
				System.out.println("There is no Middle index" );
				}
			}
	
	public static int findMiddleIndex(int[] nums) {

        int size = nums.length;

        if(size == 0 ){
            return -1;
        }

        for(int i = 1; i < size; i++){
            nums[i] = nums[i] + nums[i-1];
        }
        
        for(int i = 0; i < size; i++){
            int leftsum = 0; 
            int rightsum = 0;

            if( i != 0){
                leftsum = nums[i-1];
            }

            rightsum = nums[size-1] - nums[i];

            if(leftsum == rightsum){
                return i;
            }

        }

        return -1;
    }
}







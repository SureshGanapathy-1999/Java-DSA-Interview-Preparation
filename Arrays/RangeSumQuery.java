/*
Problem:
Build Prefix Sum array

Approach:
For creating the prefix sum array we need to start from the 2nd element in the array and need to add the previous element with the current element and do the same for the rest of the element too.

Time Complexity:
O(N)

Space Complexity:
O(1)
*/

package Arrays;

public class RangeSumQuery {

    public static void main(String[] args) {

	int [] Arr = { 6, 3, 3, 6, 7, 8, 7, 3, 7 };
	int [][] B = {{2, 6}, {4, 7}, {6,7}};
	
	int size = B.length;

    int [] Answer = new int [size];
	
	System.out.println();
	System.out.print("Array before Prefix Sum : ");
	for(int i = 0; i < Arr.length; i++){
		System.out.print(" "+ Arr[i]);
	}
	System.out.println();
	
	Answer = solve(Arr, B);
	
	System.out.println();
	System.out.print("Prefix Sum Solution: ");
	for(int i = 0; i < Answer.length; i++){
		System.out.print(" " + Answer[i]);
	}
	
	System.out.println();
	
	}
	
    public static int[] solve(int[] A, int[][] B) {

        // checking whether the array element are divisible by 0 and making the value as 1 if divisible and 0 if not divisible
        
        for(int i = 0; i < A.length; i++){
            if(A[i] % 7 == 0){
                A[i] = 1;
            }else{
                A[i] = 0;
            }
        }

        //Now building prefix Sum array

        for(int i = 1; i < A.length; i++){
            A[i] = A[i]+ A[i-1];
        }
		
		System.out.println();
		System.out.print("Array After Prefix Sum : ");
		for(int i = 0; i < A.length; i++){
			System.out.print(" "+ A[i]);
		}
		
		System.out.println();
		
        int size = B.length;

        int [] Result = new int [size];

        for(int i = 0; i < size ; i++){
            if(B[i][0] > 0){
                Result[i] = A[B[i][1]] - A[B[i][0] - 1];
            }
            else{
                Result[i] = A[B[i][1]];
            }
        }

        return Result;
    }

}







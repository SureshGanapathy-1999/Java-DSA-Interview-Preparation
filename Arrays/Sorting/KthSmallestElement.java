/*
Problem Description

Find the Bth smallest element in given array A .

NOTE: Users should try to solve it in less than equal to B swaps.

Problem Constraints

1 <= |A| <= 100000

1 <= B <= min(|A|, 500)

1 <= A[i] <= 109

A = [2, 1, 4, 3, 2]
B = 3

Output = 2

3rd element after sorting is 2.
 
 Approach
 
Use Selection Sort logic.
Find the minimum element in the unsorted portion.
Swap it with the current position.
Repeat for B positions only.
Return A[B - 1] as the Bth smallest element.


TC: O(N * B)
SC: O(1)
*/

package Sorting;
import java.util.*;

public class KthSmallestElement {

    public static void main(String[] args) {

			int [] Arr = {5,3,7,2,6,4}; 
			int k =3;
			
			System.out.println();
			
			System.out.println("Array : " + Arrays.toString(Arr));
			
			int answer = kthsmallest(Arr, k);
			
			System.out.println();
			
			System.out.println(k + " element after sorting : " + answer);
	} 




   public static int kthsmallest(final int[] A, int B) {

        for(int i = 0; i < B ; i++){

            int minindex = i;
       
            for(int j = i + 1; j < A.length ; j++){
                if ( A[j] < A[minindex]){
                    minindex = j;
                }
			}
					int temp = A[i];
                    A[i] = A[minindex];
                    A[minindex] = temp;
            
        }
        return A[B - 1];
    }
	
}
/*
DRY RUN


     0  1  2  3  4
A = [2, 1, 4, 3, 2]

Note J = J + 1

i    j     minindex     A[j] < A[minindex]    minindex = j        Swap A[i] , A[minindex]   i++

0    1        0         1 < 2 -> yes               1                        1
	 2        1         4 < 1 -> No
	 3        1         3 < 1 -> No
	 4        1         2 < 1 -> No                           A[0], A[1]  (2,1)  -> (1,2)     i++ 

A = [1, 2, 4, 3, 2]   

1    2        1         4 < 2 -> Skip 
     3        1         4 < 3 ->  Skip              
     4        1         4 < 2 -> Skip    

A = [1, 2, 4, 3, 2]   

2    3        2         3 < 4 -> Yes              3                  
	 4        3         A[j] -> 2 A[3] -> 3       4                  A[2],A[4]   (4,2)  -> (2,4)

Here, element at 4th index is small so we have updated the minindex and made the swap
 
so final answer
	 
A = [1, 2, 2, 3, 4] 


*/
/*

Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals p.

Problem Constraints

1 <= |A| <= 2*105
-108 <= A[i] <= 108

 A = [3, 2, 1, 3]
 O/P : 1
 
 Return 1 if any such integer p is present else, return -1.
 
 Approach:
 
1. First we will sort the array
2. Whether element is occouring first time by checking 
 if(A[i] != A[i-1]){
 element = i;
  } 
3. if element == A[i] count++ and return the answer

Eg:

 A = [3, 2, 1, 3]

After sorting

						A = { 1 , 2 , 3 , 3 }
						i =   0   1   2   3
number less than element      0   1   2   


*/

package Sorting;
import java.util.*;

public class NobleInteger {

    public static void main(String[] args) {

			int [] Arr = {3, 2, 1, 3};
			
			
			System.out.println();
			
			System.out.println("Array : " + Arrays.toString(Arr));
			
			int answer = solve(Arr);
			
			System.out.println();
			
			System.out.println("Count of Noble integer : " + answer);
			}
			
    public static int solve(int[] A) {
        int n = A.length;
        Arrays.sort(A);
        reverse(A);

        int ans = 0;
        int element_less = 0;

        if(A[0] == 0){
            ans++;
        }

        for(int i = 1 ; i < n ; i++){
            if(A[i] != A[i -1]){
                element_less = i;
            }

            if(element_less == A[i]){
                ans++;
            }
        }
        if(ans == 0){
            return -1;
        }
        return 1;
    }

    public static int [] reverse(int [] A){
        int start = 0;
		int end = A.length - 1;
		
		while(start < end){
			int temp = A[start];
			A[start] = A[end];
			A[end] = temp;
			start++;
			end--;
		}
		
		return A;
    }
}



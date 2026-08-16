/*
Problem:
Check Leader in an Array

Approach:
Note: Last element is always an Leader element.
Here we have traversed from right to left by maintaining one max element and while traversing we check each element if it is greater than max, if condition satisfied then we add the element to an new array and finally return the array once traversed throuth the entire array

Time Complexity:
O(N)

Space Complexity:
O(N)
*/

package Arrays;

public class LeaderArray {

    public static void main(String[] args) {

	int[] A = {100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84, 83, 82, 81, 80, 79, 78, 77, 76, 75, 74, 73, 72, 71};
				
		int size = A.length; 

        int [] temp = new int [size];
    
        int count = 0;

        int max = A[size - 1];
        temp[count++] = max;

        for(int i = size - 2; i >= 0 ; i--){

            if(A[i] > max){
                max = A[i];
                temp[count++] = A[i];
            }
        }
		
		int answer [] = new int [count];

        int ans_size = answer.length;
		
		System.out.println();
		System.out.print("Leader in the array are : ");
		
        for(int i = ans_size - 1; i >= 0 ; i--){
            answer[i] = temp[i];
			System.out.print(answer[i] + " ");
        }
		
		System.out.println();
		
	}
	
}







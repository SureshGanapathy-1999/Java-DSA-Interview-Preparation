/*
Question:
maximum consecutive One's

Approach:

1. Count the total number of '1's.
2. If all characters are '1', return n.
3. For every '0':
   - Count consecutive '1's on the left.
   - Count consecutive '1's on the right.
   - Combine left + right.
   - Add 1 if another '1' is available for swapping.
4. Store the maximum possible length.

TC: O(N)
SC: O(1)
*/




package Arrays;
import java.util.*;

public class MaximunOnes {

    public static void main(String[] args) {
		String A = "110111011";
		
		int ans = solve(A);
		
		System.out.println();
		System.out.println("maximum no of 1's count is : " + ans );
		
	}
    public static int solve(String A) {
		
		int n = A.length();
		
		char [] arr = new char [n];
		int count = 0;
		int length = 0;
		int ans = -1;
		
		// getting all the elements to character array from string
		
		for(int i = 0; i < n ; i++){
			
			arr[i] = A.charAt(i);
			
			if(arr[i] == '1'){
			count++;
			}
		}
		
		if(count == n){
			return n;
		}
		
		// now we start iterating on main array
		
		for(int i = 0; i < n; i++){
			
			int left = 0;
			int right = 0;
			
			if(arr[i] == '0'){
				
				// loop for checking the left one's
				for(int j = i - 1; j >= 0 ; j--){
					if(arr[j] == '1'){
						left++;
					}else{
						break;
					}
				}
				
				// loop for checking the right one's
				
				for(int j = i + 1; j < n; j++){
					if(arr[j] == '1'){
						right++;
					}else{
						break;
					}
				}
				
				length = Math.max(length, right + left);
				
				if(length < count){
					ans = length + 1;
				}else{
					ans = length;
				}
				
			}
			
		}
		
		return ans;
    }
}

/*

Dry Run

A = "110111011"

count = 9

check for 0.

i=3 has 0

for left one and right ones

left = 2
right = 3

if(left+right < count){
	left+right+1
}else{
	left+right
}

*/

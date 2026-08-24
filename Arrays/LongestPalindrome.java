/*
Problem:
Longest Palindromic Substring

Approach:

We consider every index as the center of a palindrome.

For each index i:
    1. Check for an odd length palindrome
       - Set l = i and r = i
       - Expand left and right while characters are equal

    2. Check for an even length palindrome
       - Set l = i and r = i + 1
       - Expand left and right while characters are equal

    3. Calculate the length of the palindrome found

    4. If the current palindrome is longer than the previous
       maximum palindrome, update:
       - start index
       - maximum length

Finally:
    Return the substring using the start index and maximum length.

Time Complexity: O(N²)
Space Complexity: O(1)

*/



package Arrays;
import java.util.*;

public class LongestPalindrome {

    public static void main(String[] args) {
		String A = "caaaabaaada";
		String ans = checkPalindrome(A);
		System.out.println(ans);
	}
			
    public static String checkPalindrome(String A) {
        
        char s[] = A.toCharArray();
        int n = s.length;

        int Maxlength = Integer.MIN_VALUE;
        int start = 0;
        
		// checking for Odd length Palindrome
		
		for(int i = 0; i < n ; i++){
			int l = i;
			int r = i;
			
			while(l >= 0 && r < n && s[l] == s[r]){
				l--;
				r++;
			}
			l++;
			r--;
			if(r-l+1 > Maxlength){
				start = l;
				Maxlength = r-l+1;
			}
		}
		
		// Checking for Even length Palindrome
		
		for(int i = 0; i < n - 1; i++){
			int l = i;
			int r = i + 1;
			
			while(l >= 0 && r < n && s[l] == s[r]){
				l--;
				r++;
			}
			l++;
			r--;
			
			if(r-l+1 > Maxlength){
				start = l;
				Maxlength = r-l+1;
			}
		}
	
	return new String(s, start , Maxlength);
	}
}
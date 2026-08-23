public class Solution {
    public String longestPalindrome(String A) {
        
        char s[] = A.toCharArray();
        int n = s.length;

        int ans = 0;
        int start = 0;
        int end = 0;

        // Odd length palindrome
        for (int i = 0; i < n; i++) {
            int p1 = i;
            int p2 = i;

            int length = palindrome(s, p1, p2);

            if (length > ans) {
                ans = length;
                start = i - (length - 1) / 2;
                end = i + (length - 1) / 2;
            }
        }

        // Even length palindrome
        for (int i = 0; i < n - 1; i++) {
            int p1 = i;
            int p2 = i + 1;

            int length = palindrome(s, p1, p2);

            if (length > ans) {
                ans = length;
                start = i - length / 2 + 1;
                end = i + length / 2;
            }
        }

        return A.substring(start, end + 1);
    }

    public int palindrome(char[] c, int p1, int p2) {

        int n = c.length;

        while (p1 >= 0 && p2 < n && c[p1] == c[p2]) {
            p1--;
            p2++;
        }

        return p2 - p1 - 1;
    }
}
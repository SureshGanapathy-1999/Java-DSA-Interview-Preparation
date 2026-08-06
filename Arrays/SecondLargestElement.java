/*
Problem:
Find the Second largest element in an array

Approach:
Traverse the array and maintain the maximum value.

Traverse the array and maintain the second largest element in the array by comparing the current element value is less than the largest element.

Time Complexity:
O(N)

Space Complexity:
O(1)
*/

package Arrays;

public class SecondLargestElement {

    public static void main(String[] args) {

        int[] arr = {10, 5, 20, 8, 15};

        int secondMax = secondLargest(arr);

        System.out.println("Second Largest Element: " + secondMax);
    }

    public static int secondLargest(int[] arr) {

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // First pass: find the largest element
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        // Second pass: find the second largest element
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            return -1;
        }

        return secondLargest;
    }
}
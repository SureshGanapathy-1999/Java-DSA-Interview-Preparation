/*
Problem:
Find the largest element in an array

Approach:
Traverse the array and maintain the maximum value.

Time Complexity:
O(N)

Space Complexity:
O(1)
*/

package Arrays;

public class LargestElement {

    public static void main(String[] args) {

        int[] arr = {10, 5, 20, 8, 15};

        int largest = findLargest(arr);

        System.out.println("Largest Element: " + largest);
    }


    public static int findLargest(int[] arr) {

        int largest = arr[0];

        for(int i = 1; i < arr.length; i++) {

            if(arr[i] > largest) {
                largest = arr[i];
            }
        }

        return largest;
    }
}


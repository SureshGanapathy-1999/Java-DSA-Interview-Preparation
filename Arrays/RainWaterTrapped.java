
/*
Question: Trapping Rain Water

Approach:

1. Create two arrays, Leftmax and Rightmax, of size N.
2. Leftmax[i] stores the maximum height from index 0 to i.
3. Rightmax[i] stores the maximum height from index N - 1 to i.
4. Traverse from left to right and calculate the maximum height on the left for every index.
5. Traverse from right to left and calculate the maximum height on the right for every index.
6. For every index, find the minimum of Leftmax[i] and Rightmax[i].
7. Subtract the current height A[i] from this minimum value.
8. Add the calculated water at every index to the total water.

Logic:

Water can be trapped at an index only up to the height of the smaller boundary.
Therefore:

Water at index i = min(Leftmax[i], Rightmax[i]) - A[i]

Leftmax and Rightmax help us find the highest boundary on both sides of every index.

TC: O(N)

SC: O(N)

*/



package Arrays;
import java.util.*;

public class RainWaterTrapped {

    public static void main(String[] args) {
		int A [] = {5, 4, 1, 4, 3, 2, 7};
		
		int ans = trap(A);
		
		System.out.println();
		System.out.println("Total Rain water trapped is : " + ans + " units" );
		
	}

    public static int trap(final int[] A) {
		
		int n = A.length;
		
		int Leftmax [] = new int [n];
		int Righmax [] = new int [n];
		
		Leftmax[0] = A[0];
		Righmax[n-1] = A[n-1];
		
		int water = 0;
		
		//get Left max for each position
		
		for(int i = 1; i < n ; i++){
			Leftmax[i] = Math.max(A[i],Leftmax[i-1]);
		}
		
		//Get right max for each position
		
		for(int i = n - 2; i >= 0 ; i--){
			Righmax[i] = Math.max(A[i],Righmax[i+1]);
		}
		
		for(int i = 0; i < n ; i++){
			
			int lmax = Leftmax[i];
			int rmax = Righmax[i];
			int height = A[i];
			
			water = water + (Math.min(lmax, rmax) - height) * 1 ; // * 1 beacuse the width is 1, but in case of width is 2 we need to multiply by 2
			
		}
		
		return water;
    }
}


/*

A = [5, 4, 1, 4, 3, 2, 7]

Leftmax = {5 , 5 , 5 , 5 , 5 , 5 , 7 }
Righmax = {7 , 7 , 7 , 7 , 7 , 7 , 7 }

int i = 0

lmax = Leftmax[i] -> 5
rmax = Righmax[i] -> 7
height = A[i]     -> 5

water = water + (Math.min(lmax, rmax) - height) * 1

water = 0 + min(5,7) - 5 -> 0 + 5 - 5 -> 0

int i = 1

lmax = Leftmax[i] -> 5
rmax = Righmax[i] -> 7
height = A[i]     -> 4

water = water + (Math.min(lmax, rmax) - height) * 1

water = 0 + min(5,7) - 4 -> 0 + 5 - 4 -> 1

int i = 2

lmax = Leftmax[i] -> 5
rmax = Righmax[i] -> 7
height = A[i]     -> 1

water = water + (Math.min(lmax, rmax) - height) * 1

water = 1 + min(5,7) - 1 -> 1 + 5 - 1 -> 5

int i = 3

lmax = Leftmax[i] -> 5
rmax = Righmax[i] -> 7
height = A[i]     -> 4

water = water + (Math.min(lmax, rmax) - height) * 1

water = 5 + min(5,7) - 4 -> 5 + 5 - 4 -> 6

int i = 4

lmax = Leftmax[i] -> 5
rmax = Righmax[i] -> 7
height = A[i]     -> 3

water = water + (Math.min(lmax, rmax) - height) * 1

water = 6 + min(5,7) - 3 -> 6 + 5 - 3 -> 8

int i = 5

lmax = Leftmax[i] -> 5
rmax = Righmax[i] -> 7
height = A[i]     -> 2

water = water + (Math.min(lmax, rmax) - height) * 1

water = 8 + min(5,7) - 2 -> 8 + 5 - 2 -> 11

int i = 6

lmax = Leftmax[i] -> 7
rmax = Righmax[i] -> 7
height = A[i]     -> 7

water = water + (Math.min(lmax, rmax) - height) * 1

water = 11 + min(7,7) - 7 -> 11 + 7 - 7 -> 11

*/
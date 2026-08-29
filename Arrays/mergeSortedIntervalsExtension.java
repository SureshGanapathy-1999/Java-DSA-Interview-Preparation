/*
Approach:

/*
Approach:

1. Take the first interval as `current`.
2. Compare `current` with each next interval.
3. If they overlap, merge them by updating `current.end`.
4. If they don't overlap:
   - Add `current` to `ans`.
   - Make the next interval `current`.
5. After the loop, add the last `current` to `ans`.
6. Return `ans`.

Example:

Input:
[1,3], [2,6], [8,10], [9,12]  current = [1,3]

[1,3] & [2,6] → overlap  current = [1,6]

[1,6] & [8,10] → no overlap		ans.add([1,6]) 		current = [8,10]

[8,10] & [9,12] → overlap current = [8,12]

Loop ends
ans.add([8,12])

Output:
[1,6], [8,12]
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        ArrayList<Interval> ans = new ArrayList<>();
        int n = intervals.size();

        if(n == 0){
            return ans;
        }

        Interval current = intervals.get(0);

        for(int i = 1; i < n; i++){

            Interval next = intervals.get(i);

            if(current.end >= intervals.get(i).start ){
                current.end = Math.max(current.end , intervals.get(i).end);
            }else{
                ans.add(current);
                current = next;
            }
        }

        ans.add(current);

        return ans;

    }
}

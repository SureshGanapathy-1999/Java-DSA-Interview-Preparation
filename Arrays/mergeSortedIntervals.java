
/*
Problem:
Insert Interval

Approach:

We go through all existing intervals one by one.

For each interval:
    1. Check if the current interval is completely before
       the new interval.
       - If current.end < newInterval.start
       - Add the current interval to the answer.

    2. Check if the new interval is completely before
       the current interval.
       - If newInterval.end < current.start
       - Add the new interval to the answer.
       - Add all remaining intervals.
       - Return the answer.

    3. If neither of the above conditions is true,
       the intervals are overlapping.
       - Merge them by taking:
         - Smaller start value
         - Larger end value

After the loop:
    - If the new interval was not added yet,
      it belongs at the end.
    - Add it to the answer.

Time Complexity: O(N)
Space Complexity: O(N)

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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		
		ArrayList<Interval> ans = new ArrayList<>();
		int n = intervals.size();
		
		for(int i = 0; i < n ; i++){
			
			Interval current = intervals.get(i);
			
			// condition if the new interval appears before the start of the interval
			if(current.end < newInterval.start){
				ans.add(current);
			}else if( newInterval.end < current.start ){ // condition if the new interval appears after the end of the interval
				ans.add(newInterval);
				
				for(int j = i ; j < n ; j++){
					ans.add(intervals.get(j));
				}
				
				return ans;
			}else{
				newInterval.start = Math.min(current.start, newInterval.start);
				newInterval.end = Math.max(current.end, newInterval.end);
			}
			
		}
		//New interval belongs to the end.
		ans.add(newInterval);
		
		return ans;

    }
}

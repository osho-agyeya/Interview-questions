/*completedd
 * 
 * Give you one Ordered List of disjoint intervalsintervals And an interval to be deletedtoBeRemoved， intervals Each interval inintervals[i] = [a, b] All express satisfactiona <= x < b All real numbers ofx Collection.

We will intervals Any interval in andtoBeRemoved All overlapping parts are deleted.

Return after deleting all intersection intervals,intervals Remaining partOrderly List.

Example 1:

Input: intervals = [[0,2],[3,4],[5,7]], toBeRemoved = [1,6]
 Output: [[0,1],[6,7]]
1
2
Example 2:

Input: intervals = [[0,5]], toBeRemoved = [2,3]
 Output: [[0,2],[3,5]]
1
2
prompt:

1 <= intervals.length <= 10^4
-10^9 <= intervals[i][0] < intervals[i][1] <= 10^9
 * 
 */

package leetcodePremium;

public class Remove_Interval {
	
	 public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
		          List<List<Integer>> res = new ArrayList<>();
		          for (int[] i : intervals) {
		              // no overlap
		              if (i[1] <= toBeRemoved[0] || i[0] >= toBeRemoved[1]) {
		                  res.add(Arrays.asList(i[0], i[1]));
		              }
		              // i[1] > toBeRemoved[0] && i[0] < toBeRemoved[1]
		             else {
		                 // left end no overlap
		                 if (i[0] < toBeRemoved[0]) {
		                     res.add(Arrays.asList(i[0], toBeRemoved[0]));
		                 }
		                 // right end no overlap
		                 if (i[1] > toBeRemoved[1]) {
		                     res.add(Arrays.asList(toBeRemoved[1], i[1]));
		                 }
		             }
		         }
		         return res;
		     }

}

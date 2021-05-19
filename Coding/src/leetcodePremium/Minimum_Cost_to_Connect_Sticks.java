/*completed
 * 
 * You have some sticks with positive integer lengths.

You can connect any two sticks of lengths X and Y into one stick by paying a cost of X + Y.  You perform this action until there is one stick remaining.

Return the minimum cost of connecting all the given sticks into one stick in this way.

Example 1:

Input: sticks = [2,4,3]
Output: 14
Example 2:

Input: sticks = [1,8,3,5]
Output: 30
 * 
 */

package leetcodePremium;

public class Minimum_Cost_to_Connect_Sticks {
	
	 public int connectSticks(int[] sticks) {
	        PriorityQueue<Integer> pq = PriorityQueue<Integer>();

	    for (int i = 0; i < n; i++) {
	      pq.add(arr[i]);
	    }

	    int res = 0;

	    while (pq.size() > 1) {
	      int first = pq.poll();
	      int second = pq.poll();

	      res += first + second;
	      pq.add(first + second);
	    }

	    return res;
	    }

}

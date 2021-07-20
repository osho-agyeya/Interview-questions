/*completedd
 * 
 * Given m arrays, and each array is sorted in ascending order. Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance. We define the distance between two integers a and b to be their absolute difference |a-b|. Your task is to find the maximum distance.

Example 1:
Input: 
[[1,2,3],
 [4,5],
 [1,2,3]]
Output: 4
Explanation: 
One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
Note:
Each given array will have at least 1 number. There will be at least two non-empty arrays.
The total number of the integers in all the m arrays will be in the range of [2, 10000].
The integers in the m arrays will be in the range of [-10000, 10000].
 */

package leetcodePremium;

public class Maximum_Distance_in_Arrays {
	
	public int maxDistance(List<List<Integer>> arrays) {
        if (arrays == null || arrays.size() < 2) return 0;
        int min = arrays.get(0).get(0), max = arrays.get(0).get(arrays.get(0).size() - 1);
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < arrays.size(); i++) {
            int curMin = arrays.get(i).get(0), curMax = arrays.get(i).get(arrays.get(i).size() - 1);
            res = Math.max(res, Math.abs(min - curMax));
            res = Math.max(res, Math.abs(max - curMin));
            max = Math.max(max, curMax);
            min = Math.min(min, curMin);
        }
        return res;
    }

}

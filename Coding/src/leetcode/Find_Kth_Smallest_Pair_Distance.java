//completed
/*
You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u, v) which consists of one element from the first array and one element from the second array.

Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.

 

Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:

Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [[1,1],[1,1]]
Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:

Input: nums1 = [1,2], nums2 = [3], k = 3
Output: [[1,3],[2,3]]
Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 

Constraints:

1 <= nums1.length, nums2.length <= 104
-109 <= nums1[i], nums2[i] <= 109
nums1 and nums2 both are sorted in ascending order.
1 <= k <= 1000
 * 
 */
package leetcode;


import java.util.List;
import java.util.Stack;

public class Find_Kth_Smallest_Pair_Distance {
	
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> list = new ArrayList();
        int m = nums1.length;
        int n = nums2.length;
        if(m == 0 || n == 0 || k < 1) return list;
        
        PriorityQueue<Data> heap = new PriorityQueue<Data>((a, b) -> (a.val - b.val));
        
        heap.offer(new Data(0, 0, nums1[0] + nums2[0]));
        
        while(!heap.isEmpty() && k > 0){
            Data d = heap.poll();
            
            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[d.i]);
            pair.add(nums2[d.j]);
            list.add(pair);
            k--;
            
            //add the next column item
            if(d.j < n - 1){
                heap.offer(new Data(d.i, d.j + 1, nums1[d.i] + nums2[d.j + 1]));
            }
            // always store the next row (smallest) 
            if(d.j == 0 && d.i < m - 1){
                heap.offer(new Data(d.i + 1, 0, nums1[d.i + 1] + nums2[0]));
            }
        }
        return list;
    }
        
        class Data{
            int i; 
            int j;
            int val;
            public Data(int i, int j, int val){
                this.i = i;
                this.j = j;
                this.val = val;
            }
        }
}

/*completedd
 * 
 * 
 * Given two binary search trees, return True if and only if there is a node in the first tree and a node in the second tree whose values sum up to a given integer target.

 

Example 1:



Input: root1 = [2,1,4], root2 = [1,0,3], target = 5
Output: true
Explanation: 2 and 3 sum up to 5.
Example 2:



Input: root1 = [0,-10,10], root2 = [5,1,7,0,2], target = 18
Output: false
 

Constraints:

Each tree has at most 5000 nodes.
-10^9 <= target, node.val <= 10^9
 * 
 */

package leetcodePremium;

public class Two_Sum_BSTs {
	
	// Time: O(M+N)
    // Space: O(logmax(M,N)) in the best case; O(max(M,N)) in the worst case.
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {

        // Convert to list
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        listByInorder(root1, list1);
        listByInorder(root2, list2);

        // Two Pointers
        int lo = 0, hi = list2.size() - 1;
        while (lo < list1.size() && hi >= 0) { // notice the condition here
            int sum = list1.get(lo) + list2.get(hi);
            if (sum == target) {
                return true;
            } else if (sum < target) {
                ++lo;
            } else {
                --hi;
            }
        }
        return false;
    }

    private void listByInorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        listByInorder(root.left, list);
        list.add(root.val);
        listByInorder(root.right, list);
    }

}

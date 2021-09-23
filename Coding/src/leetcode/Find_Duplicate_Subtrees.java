/* over, n, n
 * Given the root of a binary tree, return all duplicate subtrees.

For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with the same node values.

 

Example 1:


Input: root = [1,2,3,4,null,2,4,null,null,4]
Output: [[2,4],[4]]
Example 2:


Input: root = [2,1,1]
Output: [[1]]
Example 3:


Input: root = [2,2,2,3,null,3,null]
Output: [[2,3],[3]]
 

Constraints:

The number of the nodes in the tree will be in the range [1, 10^4]
-200 <= Node.val <= 200
 */

package leetcode;

public class Find_Duplicate_Subtrees {
	
	/*
	 * 
	 * serialisation and compare
	 * 
	 */

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> set = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();
        helper(root, res, set);
        return res;
    }
    public String helper(TreeNode root, List<TreeNode> res, Map<String, Integer> map) {
        if (root == null) return "";
        String s = "(" + helper(root.left, res, map) + root.val + helper(root.right, res, map) + ")";
        if (map.getOrDefault(s, 0) == 1) res.add(root);
        map.put(s, map.getOrDefault(s, 0) + 1);
        return s;
    }
	
}

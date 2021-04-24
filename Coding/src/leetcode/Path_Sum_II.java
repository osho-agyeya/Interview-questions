//completed
/*
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.

A leaf is a node with no children.

 

Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: []
Example 3:

Input: root = [1,2], targetSum = 0
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
 */

package leetcode;

import java.util.ArrayList;
import java.util.List;

import main_solution.TreeNode;

public class Path_Sum_II {
	
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>>ret = new ArrayList<List<Integer>>(); 
    List<Integer> cur = new ArrayList<Integer>(); 
    pathSum(root, sum, cur, ret);
    return ret;
}

public void pathSum(TreeNode root, int sum, List<Integer>cur, List<List<Integer>>ret){
    if (root == null){
        return; 
    }
    cur.add(root.val);
    if (root.left == null && root.right == null && root.val == sum){
        ret.add(new ArrayList<>(cur));
    }else{
        pathSum(root.left, sum - root.val, cur, ret);
        pathSum(root.right, sum - root.val, cur, ret);
    }
    cur.remove(cur.size()-1);
}

}

//completed

//t=O(N)
//s=

/*
 * 
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
 * 
 * 
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main_solution.TreeNode;

public class Binary_Tree_Zigzag_Level_Order_Traversal {
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
if(root == null) return res;

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    boolean order = true;
    int size = 1;

    while(!q.isEmpty()) {
        List<Integer> tmp = new ArrayList<>();
        for(int i = 0; i < size; ++i) {
            TreeNode n = q.poll();
            if(order) {
                tmp.add(n.val);
            } else {
                tmp.add(0, n.val);
            }
            if(n.left != null) q.add(n.left);
            if(n.right != null) q.add(n.right);
        }
        res.add(tmp);
        size = q.size();
        order = order ? false : true;
    }
    return res;
    }

}

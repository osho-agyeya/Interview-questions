//completed

//t=O(N)
//s=

/*
 * 
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
 * 
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main_solution.TreeNode;

public class Binary_Tree_Level_Order_Traversal {
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) return ans;
        queue.add(root);
        list.add(root.val);
        ans.add(list);
        while(queue.size()>0){
            list = new ArrayList<Integer>();
            int s = queue.size();
            for(int i = 0; i<s; i++){
                TreeNode node = queue.remove();
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                if(node.left!=null) list.add(node.left.val);
                if(node.right!=null) list.add(node.right.val);
            }
            if(list.size()>0) ans.add(list);
        }
       return ans; 
    }

}

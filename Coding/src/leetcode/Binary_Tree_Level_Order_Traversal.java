//done

//t=O(N)
//s=

/*
 * 
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
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

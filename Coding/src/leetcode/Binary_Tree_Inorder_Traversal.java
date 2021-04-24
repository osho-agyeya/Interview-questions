//completed

//t=O(N)
//s=


/**
 * 
 * 
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.

 

Example 1:


Input: root = [1,null,2,3]
Output: [1,3,2]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
Example 4:


Input: root = [1,2]
Output: [2,1]
Example 5:


Input: root = [1,null,2]
Output: [1,2]
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 

Follow up:

Recursive solution is trivial, could you do it iteratively?
 * 
 * 
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

import main_solution.TreeNode;

public class Binary_Tree_Inorder_Traversal {
	
public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> res=new ArrayList<Integer>();
        
        inorder(res, root);
        
        return res;
    }
    
    public void inorder(List<Integer> res, TreeNode root){
        if(root!=null){
            inorder(res,root.left);
            res.add(root.val);
            inorder(res, root.right);
        }else{
            return;
        }
    }

}

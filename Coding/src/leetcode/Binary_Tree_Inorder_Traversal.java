//done

//t=O(N)
//s=
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

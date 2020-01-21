//ddoe
/*
 *Inorder Traversal of Cartesian Tree
Asked in:  
Amazon
Given an inorder traversal of a cartesian tree, construct the tree.

 Cartesian tree : is a heap ordered binary tree, where the root is greater than all the elements in the subtree. 
 Note: You may assume that duplicates do not exist in the tree. 
Example :

Input : [1 2 3]

Return :   
          3
         /
        2
       /
      1 
 */
package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import main_solution.TreeNode;

public class Inorder_Traversal_of_Cartesian_Tree {
	
	
 public TreeNode buildTree(ArrayList<Integer> a) {
        if (a.isEmpty()) { return null; }
        List<Integer> list = getMax(a);
        TreeNode root = new TreeNode(list.get(0));
        root.left = buildTree(new ArrayList<>(a.subList(0, list.get(1))));
        root.right = buildTree(new ArrayList<>(a.subList(list.get(1) + 1, a.size())));
        return root;
    }

    private List<Integer> getMax(ArrayList<Integer> a) {
        int max = Collections.max(a);
        int idx = a.indexOf(max);
        return Arrays.asList(max, idx);
    }
}

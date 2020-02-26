//ddoe
/*
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * 
*/
package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import main_solution.TreeNode;

public class Unique_Binary_Search_Trees_II {
	
	public List<TreeNode> generateTrees(int n) {
		 if(n==0) return new LinkedList();
		 
    return genTreeList(1,n);
}

private List<TreeNode> genTreeList (int start, int end) {
    List<TreeNode> list = new ArrayList<TreeNode>(); 
    if (start > end) {
        list.add(null);
    }
    for(int idx = start; idx <= end; idx++) {
        List<TreeNode> leftList = genTreeList(start, idx - 1);
        List<TreeNode> rightList = genTreeList(idx + 1, end);
        for (TreeNode left : leftList) {
            for(TreeNode right: rightList) {
                TreeNode root = new TreeNode(idx);
                root.left = left;
                root.right = right;
                list.add(root);
            }
        }
    }
    return list;
}

}

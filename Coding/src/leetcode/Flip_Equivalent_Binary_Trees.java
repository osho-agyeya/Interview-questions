/* over, min(n1,n2), min(h1,h2) 
 * 
 * For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child subtrees.

A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations.

Given the roots of two binary trees root1 and root2, return true if the two trees are flip equivelent or false otherwise.

 

Example 1:

Flipped Trees Diagram
Input: root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
Output: true
Explanation: We flipped at nodes with values 1, 3, and 5.
Example 2:

Input: root1 = [], root2 = []
Output: true
Example 3:

Input: root1 = [], root2 = [1]
Output: false
Example 4:

Input: root1 = [0,null,1], root2 = []
Output: false
Example 5:

Input: root1 = [0,null,1], root2 = [0,1]
Output: true
 

Constraints:

The number of nodes in each tree is in the range [0, 100].
Each tree will have unique node values in the range [0, 99].
 */

package leetcode;

public class Flip_Equivalent_Binary_Trees {
	
	/*
	 * Approach 1: Recursion
Intuition

If root1 and root2 have the same root value, then we only need to check if their children are equal (up to ordering.)

Algorithm

There are 3 cases:

If root1 or root2 is null, then they are equivalent if and only if they are both null.

Else, if root1 and root2 have different values, they aren't equivalent.

Else, let's check whether the children of root1 are equivalent to the children of root2. There are two different ways to pair these children.


Complexity Analysis

Time Complexity: O(min(N_1, N_2))O(min(N 
1
​
 ,N 
2
​
 )), where N_1, N_2N 
1
​
 ,N 
2
​
  are the lengths of root1 and root2.

Space Complexity: O(min(H_1, H_2))O(min(H 
1
​
 ,H 
2
​
 )), where H_1, H_2H 
1
​
 ,H 
2
​
  are the heights of the trees of root1 and root2.

	 * 
	 * 
	 */
	
	
	
	public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == root2)
            return true;
        if (root1 == null || root2 == null || root1.val != root2.val)
            return false;

        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
                flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }

}

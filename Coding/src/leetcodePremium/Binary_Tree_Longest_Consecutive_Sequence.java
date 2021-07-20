/*completedd
 * Given a binary tree, find the length of the longest consecutive sequence path. 

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse). 
For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3. 
   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2. 
 */


package leetcodePremium;

public class Binary_Tree_Longest_Consecutive_Sequence {
	
	int res=0;

    public int longestConsecutive(TreeNode root) {
        // write your code here
    if (root == null)
            return 0;
          
        // call utility method with current length 0 
        longestConsecutiveUtil(root, 0, root.val);
          
        return this.res;
    }
  
    // Utility method to return length of longest 
    // consecutive sequence of tree 
    private void longestConsecutiveUtil(TreeNode root, int curlength, 
                                        int expected)
    {
        if (root == null)
            return;
  
        // if root data has one more than its parent 
        // then increase current length 
        if (root.val == expected)
            curlength++;
        else
            curlength = 1;
  
        // update the maximum by current length 
        this.res = Math.max(this.res, curlength);
  
        // recursively call left and right subtree with 
        // expected value 1 more than root data 
        longestConsecutiveUtil(root.left, curlength, root.val + 1);
        longestConsecutiveUtil(root.right, curlength, root.val + 1);
    }
  

}

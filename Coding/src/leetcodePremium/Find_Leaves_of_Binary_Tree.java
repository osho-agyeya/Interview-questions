/*completedd
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

Example:
Given binary tree
          1
         / \
        2   3
       / \     
      4   5    
Returns [4, 5, 3], [2], [1].

Explanation:
1. Removing the leaves [4, 5, 3] would result in this tree:

          1
         / 
        2          
2. Now removing the leaf [2] would result in this tree:

          1          
3. Now removing the leaf [1] would result in the empty tree:

          []         
Returns [4, 5, 3], [2], [1].

Credits:
Special thanks to @elmirap for adding this problem and creating all test cases.
 */

package leetcodePremium;

public class Find_Leaves_of_Binary_Tree {

	public List<List<Integer>> findLeaves(TreeNode root) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    helper(result, root);
	    return result;
	}
	 
	// traverse the tree bottom-up recursively
	private int helper(List<List<Integer>> list, TreeNode root){
	    if(root==null)
	        return -1;
	 
	    int left = helper(list, root.left);
	    int right = helper(list, root.right);
	    int curr = Math.max(left, right)+1;
	 
	    // the first time this code is reached is when curr==0,
	    //since the tree is bottom-up processed.
	    if(list.size()<=curr){
	        list.add(new ArrayList<Integer>());
	    }
	 
	    list.get(curr).add(root.val);
	 
	    return curr;
	}
	
}

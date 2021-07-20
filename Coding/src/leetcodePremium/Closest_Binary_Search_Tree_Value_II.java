/*completedd
 * 
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target. 
Note:
Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.

Follow up:
Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?  */


package leetcodePremium;

public class Closest_Binary_Search_Tree_Value_II {

	 public List<Integer> closestKValues(TreeNode root, double target, int k) {
	        LinkedList<Integer> list = new LinkedList<Integer>();
	        closestKValuesHelper(list, root, target, k);
	        return list;
	    }

	    /**
	     * @return <code>true</code> if result is already found.
	     */
	    private boolean closestKValuesHelper(LinkedList<Integer> list, TreeNode root, double target, int k) {
	        if (root == null) {
	            return false;
	        }

	        if (closestKValuesHelper(list, root.left, target, k)) {
	            return true;
	        }

	        if (list.size() == k) {
	            if (Math.abs(list.getFirst() - target) < Math.abs(root.val - target)) {
	                return true;
	            } else {
	                list.removeFirst();
	            }
	        }

	        list.addLast(root.val);
	        return closestKValuesHelper(list, root.right, target, k);
	    }
	
}

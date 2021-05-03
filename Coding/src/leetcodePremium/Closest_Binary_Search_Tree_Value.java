/*completed
 * 
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target. 
Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
 */


package leetcodePremium;

public class Closest_Binary_Search_Tree_Value {

	int goal;
    double min = Double.MAX_VALUE;
 
    public int closestValue(TreeNode root, double target) {
        helper(root, target);
        return goal;
    }
 
    public void helper(TreeNode root, double target){
        if(root==null)
            return;
 
        if(Math.abs(root.val - target) < min){
            min = Math.abs(root.val-target);
            goal = root.val;
        } 
 
        if(target < root.val){
            helper(root.left, target);
        }else{
            helper(root.right, target);
        }
    }
	
}

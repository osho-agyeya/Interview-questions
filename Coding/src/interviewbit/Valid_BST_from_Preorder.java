/*completed
 * You are given a preorder traversal A, of a Binary Search Tree.

Find if it is a valid preorder traversal of a BST.



Problem Constraints
1 <= A[i] <= 106

1 <= |A| <= 105



Input Format
First and only argument is an integer array A denoting the pre-order traversal.



Output Format
Return an integer:

0 : Impossible preorder traversal of a BST
1 : Possible preorder traversal of a BST


Example Input
Input 1:

A = [7, 7, 10, 10, 9, 5, 2, 8]


Example Output
Output 1:

 1
 */

package interviewbit;

public class Valid_BST_from_Preorder {
    public int solve(int[] pre) {
        int n=pre.length;
        Stack<Integer> s = new Stack<Integer>();
  
        // Initialize current root as minimum possible
        // value
        int root = Integer.MIN_VALUE;
  
        // Traverse given array
        for (int i = 0; i < n; i++) {
            // If we find a node who is on right side
            // and smaller than root, return false
            if (pre[i] < root) {
                return 0;
            }
  
            // If pre[i] is in right subtree of stack top,
            // Keep removing items smaller than pre[i]
            // and make the last removed item as new
            // root.
            while (!s.empty() && s.peek() < pre[i]) {
                root = s.peek();
                s.pop();
            }
  
            // At this point either stack is empty or
            // pre[i] is smaller than root, push pre[i]
            s.push(pre[i]);
        }
        return 1;
    }
}

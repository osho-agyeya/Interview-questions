/*completed
 * Given a binary tree denoted by root node A and a leaf node B from this tree.

It is known that all nodes connected to a given node (left child, right child and parent) get burned in 1 second. Then all the nodes which are connected through one intermediate get burned in 2 seconds, and so on.

You need to find the minimum time required to burn the complete binary tree.



Problem Constraints
2 <= number of nodes <= 105

1 <= node value, B <= 105

node value will be distinct



Input Format
First argument is a root node of the binary tree, A.

Second argument is an integer B denoting the node value of leaf node.



Output Format
Return an integer denoting the minimum time required to burn the complete binary tree.



Example Input
Input 1:

 Tree :      1 
            / \ 
           2   3 
          /   / \
         4   5   6
 B = 4
Input 2:

 Tree :      1
            / \
           2   3
          /     \
         4       5 
 B = 5 


Example Output
Output 1:

 4
Output 2:

 4


Example Explanation
Explanation 1:

 After 1 sec: Node 4 and 2 will be burnt. 
 After 2 sec: Node 4, 2, 1 will be burnt.
 After 3 sec: Node 4, 2, 1, 3 will be burnt.
 After 4 sec: Node 4, 2, 1, 3, 5, 6(whole tree) will be burnt.
 
Explanation 2:

 After 1 sec: Node 5 and 3 will be burnt. 
 After 2 sec: Node 5, 3, 1 will be burnt.
 After 3 sec: Node 5, 3, 1, 2 will be burnt.
 After 4 sec: Node 5, 3, 1, 2, 4(whole tree) will be burnt.
 
 */

package interviewbit;

public class Burn_a_Tree {
	
	class Data {
        int leftDepth, rightDepth, time;
        boolean contains;
  
        Data()
        {
            contains = false;
            leftDepth = rightDepth = 0;
            time = -1;
        }
    }
    
    int res;
    
    public int solve(TreeNode node, int target) {
        
        res=0;
        getResult(node, new Data(), target);
        return res;
        
    }
    
    public void getResult(TreeNode node, Data data, int target){
         // Base case: if root is null
        if (node == null) {
            return;
        }
  
        // If current node is leaf
        if (node.left == null && node.right == null) {
  
            // If current node is the first burnt node
            if (node.val == target) {
                data.contains = true;
                data.time = 0;
            }
            return;
        }
  
        // Information about left child
        Data leftData = new Data();
        getResult(node.left, leftData, target);
  
        // Information about right child
        Data rightData = new Data();
        getResult(node.right, rightData, target);
  
        // If left subtree contains the fired node then
        // time required to reach fire to current node
        // will be (1 + time required for left child)
        data.time = (leftData.contains) ? (leftData.time + 1) : -1;
  
        // If right subtree contains the fired node then
        // time required to reach fire to current node
        // will be (1 + time required for right child)
        if (data.time == -1)
            data.time = (rightData.contains) ? (rightData.time + 1) : -1;
  
        // Storing(true or false) if the tree rooted at
        // current node contains the fired node
        data.contains = (leftData.contains || rightData.contains);
  
        // Calculate the maximum depth of left subtree
        data.leftDepth = (node.left == null) ? 0 : (1 + Math.max(leftData.leftDepth, leftData.rightDepth));
  
        // Calculate the maximum depth of right subtree
        data.rightDepth = (node.right == null) ? 0 : (1 + Math.max(rightData.leftDepth, rightData.rightDepth));
  
        // Calculating answer
        if (data.contains) {
  
            // If left subtree exists and
            // it contains the fired node
            if (leftData.contains) {
  
                // calculate result
                res = Math.max(res, data.time + data.rightDepth);
            }
  
            // If right subtree exists and it
            // contains the fired node
            if (rightData.contains) {
  
                // calculate result
                res = Math.max(res, data.time + data.leftDepth);
            }
        }
    }

}

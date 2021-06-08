/*completed
 * Given a Binary Tree A consisting of N nodes.

You need to find all the cousins of node B.

NOTE:

Siblings should not be considered as cousins.
Try to do it in single traversal.
You can assume that Node B is there in the tree A.
Order doesn't matter in the output.


Problem Constraints
1 <= N <= 105

1 <= B <= N



Input Format
First Argument represents the root of binary tree A.

Second Argument is an integer B denoting the node number.



Output Format
Return an integer array denoting the cousins of node B.

NOTE: Order doesn't matter.



Example Input
Input 1:

 A =

           1
         /   \
        2     3
       / \   / \
      4   5 6   7 


B = 5

Input 2:

 A = 
            1
          /   \
         2     3
        / \ .   \
       4   5 .   6


B = 1




Example Output
Output 1:

 [6, 7]
Output 2:

 []


Example Explanation
Explanation 1:

 Cousins of Node 5 are Node 6 and 7 so we will return [6, 7]
 Remember Node 4 is sibling of Node 5 and do not need to return this.
Explanation 2:

 Since Node 1 is the root so it doesn't have any cousin so we will return an empty array.
 */

package interviewbit;

public class Cousins_in_Binary_Tree {
	
	 public ArrayList<Integer> solve(TreeNode root, int node_to_find) {
		    ArrayList<Integer> r=new ArrayList<>();
		    if (root.val == node_to_find || root==null)   return r;
		 
		    Queue<TreeNode> q = new LinkedList<>();
		    boolean found = false;
		    int size_ = 0;
		    TreeNode p = null;
		    q.add(root);
		    while (q.isEmpty() == false &&
		                 found == false)
		    {
		 
		        size_ = q.size();
		        while (size_-- > 0)
		        {
		            p = q.peek();
		            q.remove();
		            if ((p.left!=null && p.left.val == node_to_find) ||
		                 (p.right!=null &&p.right.val == node_to_find))
		            {
		                found = true;
		            }
		            else
		            {
		                if (p.left != null)
		                    q.add(p.left);
		                if (p.right!= null)
		                    q.add(p.right);
		            }
		 
		        }
		    }
		    size_ = q.size();
		    for (int i = 0; i < size_; i++)
		    {
		        p = q.peek();
		        q.poll();
		         
		        r.add(p.val);
		    }
		    return r;
		    }
}

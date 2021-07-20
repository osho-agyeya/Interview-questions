/* over, n, n
 * 
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [1,2], p = 1, q = 2
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the tree.
 */

package leetcode;

import main_solution.TreeNode;

public class Lowest_Common_Ancestor_of_a_Binary_Tree {
	
	/*
	 * 
	 * Solution
First the given nodes p and q are to be searched in a binary tree and then their lowest common ancestor is to be found. We can resort to a normal tree traversal to search for the two nodes. Once we reach the desired nodes p and q, we can backtrack and find the lowest common ancestor.


Approach 1: Recursive Approach
Intuition

The approach is pretty intuitive. Traverse the tree in a depth first manner. The moment you encounter either of the nodes p or q, return some boolean flag. The flag helps to determine if we found the required nodes in any of the paths. The least common ancestor would then be the node for which both the subtree recursions return a True flag. It can also be the node which itself is one of p or q and for which one of the subtree recursions returns a True flag.

Let us look at the formal algorithm based on this idea.

Algorithm

Start traversing the tree from the root node.
If the current node itself is one of p or q, we would mark a variable mid as True and continue the search for the other node in the left and right branches.
If either of the left or the right branch returns True, this means one of the two nodes was found below.
If at any point in the traversal, any two of the three flags left, right or mid become True, this means we have found the lowest common ancestor for the nodes p and q.
Let us look at a sample tree and we search for the lowest common ancestor of two nodes 9 and 11 in the tree.

Current
1 / 9
Following is the sequence of nodes that are followed in the recursion:

1 --> 2 --> 4 --> 8
BACKTRACK 8 --> 4
4 --> 9 (ONE NODE FOUND, return True)
BACKTRACK 9 --> 4 --> 2
2 --> 5 --> 10
BACKTRACK 10 --> 5
5 --> 11 (ANOTHER NODE FOUND, return True)
BACKTRACK 11 --> 5 --> 2

2 is the node where we have left = True and right = True and hence it is the lowest common ancestor.

Complexity Analysis

Time Complexity: O(N)O(N), where NN is the number of nodes in the binary tree. In the worst case we might be visiting all the nodes of the binary tree.

Space Complexity: O(N)O(N). This is because the maximum amount of space utilized by the recursion stack would be NN since the height of a skewed binary tree could be NN.


Approach 2: Iterative using parent pointers
Intuition

If we have parent pointers for each node we can traverse back from p and q to get their ancestors. The first common node we get during this traversal would be the LCA node. We can save the parent pointers in a dictionary as we traverse the tree.

Algorithm

Start from the root node and traverse the tree.
Until we find p and q both, keep storing the parent pointers in a dictionary.
Once we have found both p and q, we get all the ancestors for p using the parent dictionary and add to a set called ancestors.
Similarly, we traverse through ancestors for node q. If the ancestor is present in the ancestors set for p, this means this is the first ancestor common between p and q (while traversing upwards) and hence this is the LCA node.

Complexity Analysis

Time Complexity : O(N)O(N), where NN is the number of nodes in the binary tree. In the worst case we might be visiting all the nodes of the binary tree.

Space Complexity : O(N)O(N). In the worst case space utilized by the stack, the parent pointer dictionary and the ancestor set, would be NN each, since the height of a skewed binary tree could be NN.


Approach 3: Iterative without parent pointers
Intuition

In the previous approach, we come across the LCA during the backtracking process. We can get rid of the backtracking process itself. In this approach we always have a pointer to the probable LCA and the moment we find both the nodes we return the pointer as the answer.

Algorithm

Start with root node.
Put the (root, root_state) on to the stack. root_state defines whether one of the children or both children of root are left for traversal.
While the stack is not empty, peek into the top element of the stack represented as (parent_node, parent_state).
Before traversing any of the child nodes of parent_node we check if the parent_node itself is one of p or q.
First time we find either of p or q, set a boolean flag called one_node_found to True. Also start keeping track of the lowest common ancestors by keeping a note of the top index of the stack in the variable LCA_index. Since all the current elements of the stack are ancestors of the node we just found.
The second time parent_node == p or parent_node == q it means we have found both the nodes and we can return the LCA node.
Whenever we visit a child of a parent_node we push the (parent_node, updated_parent_state) onto the stack. We update the state of the parent since a child/branch has been visited/processed and accordingly the state changes.
A node finally gets popped off from the stack when the state becomes BOTH_DONE implying both left and right subtrees have been pushed onto the stack and processed. If one_node_found is True then we need to check if the top node being popped could be one of the ancestors of the found node. In that case we need to reduce LCA_index by one. Since one of the ancestors was popped off.
Whenever both p and q are found, LCA_index would be pointing to an index in the stack which would contain all the common ancestors between p and q. And the LCA_index element has the lowest ancestor common between p and q.

Current
1 / 21
The animation above shows how a stack is used to traverse the binary tree and keep track of the common ancestors between nodes p and q.


Complexity Analysis

Time Complexity : O(N)O(N), where NN is the number of nodes in the binary tree. In the worst case we might be visiting all the nodes of the binary tree. The advantage of this approach is that we can prune backtracking. We simply return once both the nodes are found.

Space Complexity : O(N)O(N). In the worst case the space utilized by stack would be NN since the height of a skewed binary tree could be NN.
	 * 
	 */
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    return left == null ? right : right == null ? left : root;
    }

}

/* over, n, 1
 * 
Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 

Example 1:


Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [0]
Output: [0]
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
 

Follow up: Can you flatten the tree in-place (with O(1) extra space)?
 * 
 */

package leetcode;

import main_solution.TreeNode;

public class Flatten_Binary_Tree_to_Linked_List {
	
	
	/*
	 * 
	 * Approach 3: O(1) Iterative Solution
Intuition

We'll get to the intuition for this approach in a bit, but first let's talk about the motivation. For any kind of tree traversal, we always have the easiest of solutions which is based on recursion. Next, we have a custom stack based iterative version of the same solution. Finally, we want a tree traversal that doesn't use any kind of additional space at all. There is a well known tree traversal out there that doesn't use any additional space at all. It's known as Morris Traversal. Our solution is based off of the same ideology, but Morris Traversal is not a pre-requisite here.

To understand what's difference between the nodes processing of this approach and basic recursion, let's look at a sample tree.


With recursion, we only re-wire the connections for the "current node" once we are already done processing the left and the right subtrees completely. Let's see what that looks like in a figure.


However, the postponing of rewiring of connections on the current node until the left subtree is done, is basically what recursion is. Recursion is all about postponing decisions until something else is completed. In order for us to be able to postpone stuff, we need to use the stack. However, in our current approach we want to get rid of the stack altogether. So, we will have to come up with a greedy way that will be costlier in terms of time, but will be space efficient in achieving the same results.

For a current node, we will check if it has a left child or not. If it does, we will find the last node in the rightmost branch of the subtree rooted at this left child. Once we find this "rightmost" node, we will hook it up with the right child of the current node.

Let's look at this idea on our current sample tree.


This might not make a lot of sense just yet. But, bear with me and read on. Let's see what connections we need to establish or shuffle once we find that "rightmost node". We are highlighting "rightmost" here because technically, even without knowing this approach, the node 23 would have made much more sense here, right? Instead, we are doing some vodoo with the node 6. God knows why!


As mentioned in the previous paragraph, this figure would make much more sense if we had just found out the node 23, and set its right child to 1 instead of doing all this with 6. Why did we do that you might ask? Well, it's an optimization of sorts. To find the actual "rightmost" node of subtree, we might have to potentially traverse most of that subtree. Like in our example. To actually get to the node 23, we would have had to traverse all of the nodes: 2, 6, 44, 23. Instead, we simply stop at the node 6. We'll see why that also achieves our final purpose. For now, let's move on.

By doing the following operation for every node, we are simply try ing to move stuff to the right hand side one step at a time. The reason we used the node 6 in the above example and not 23 is the very reason we called this approach somewhat greedy.

Processing of the node 2 is simple since it doesn't have a left child at all. So we have nothing to do here. Let's come over to the node 6 since this is where things get interesting and start to make sense. We'll again use the same logic as before.

For a current node, we will check if it has a left child or not. If it does, we will find the last node in the rightmost branch of the subtree rooted at this left child. Once we find this "rightmost" node, we will hook it up with the right child of the current node.

As we can clearly see from the previous figures, the rightmost node here would be 23. So, let's look at the tree after we are done rewiring the connections.


Now this looks just like the tree after the recursion would have completed on the left subtree and we rewired the connections, right? Exactly!. The reason we stopped at the first rightmost node with no right child was because we would eventually end up rightyfying all the subtrees through that connection. Even though before we didn't hook up the node 23, we were able to do it when we arrived at the node 6 here.

Algorithm

So basically, this is going to be a super short algorithm and a short-er implementation :)

We use a pointer for traversing the nodes of our tree starting from the root. We have a loop that keeps going until the node pointer becomes null which is when we would be done processing the entire tree.

For every node we check if it has a left child or not. If it doesn't we simply move on to the right hand side i.e.

 node = node.right
If the node does have a left child, we find the first node on the rightmost branch of the left subtree which doesn't have a right child i.e. the almost rightmost node.

 rightmost = node.left
 while rightmost != null:
 rightmost = rightmost.right
Once we find this rightmost node, we rewire the connections as explained in the intuition section.

 rightmost.right = node.right
 node.right = node.left
 node.left = null
And we move on to the right node to continue processing of our tree.


Complexity Analysis

Time Complexity: O(N)O(N) since we process each node of the tree at most twice. If you think about it, we process the nodes once when we actually run our algorithm on them as the currentNode. The second time when we come across the nodes is when we are trying to find our rightmost node. Sure, this algorithm is slower than the previous two approaches but it doesn't use any additional space which is a big win.
Space Complexity: O(1)O(1) boom!.
	 * 
	 */
	
public void flatten(TreeNode root) {
        
        // Handle the null scenario
        if (root == null) {
            return;
        }
        
        TreeNode node = root;
        
        while (node != null) {
            
            // If the node has a left child
            if (node.left != null) {
                
                // Find the rightmost node
                TreeNode rightmost = node.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }
                
                // rewire the connections
                rightmost.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            
            // move on to the right side of the tree
            node = node.right;
        }
    }
	
	

}

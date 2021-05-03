/*completed
 * Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes. 
Left boundary is defined as the path from root to the left-most node. Right boundary is defined as the path from root to the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.
The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.
The right-most node is also defined by the same way with left and right exchanged.
Example 1
Input:
  1
   \
    2
   / \
  3   4

Ouput:
[1, 3, 4, 2]

Explanation:
The root doesn't have left subtree, so the root itself is left boundary.
The leaves are node 3 and 4.
The right boundary are node 1,2,4. Note the anti-clockwise direction means you should output reversed right boundary.
So order them in anti-clockwise without duplicates and we have [1,3,4,2].

Example 2
Input:
    ____1_____
   /          \
  2            3
 / \          / 
4   5        6   
   / \      / \
  7   8    9  10  
       
Ouput:
[1,2,4,7,8,9,10,6,3]

Explanation:
The left boundary are node 1,2,4. (4 is the left-most node according to definition)
The leaves are node 4,7,8,9,10.
The right boundary are node 1,3,6,10. (10 is the right-most node).
So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].
 * 
 */

package leetcodePremium;

public class Boundary_of_Binary_Tree {
	
	
	
    // Recursive function to print the left boundary of the given binary tree
    // in a top-down fashion, except for the leaf nodes
    public static void printLeftBoundary(Node root)
    {
        Node node = root;
 
        // do for all non-leaf nodes
        while (!node.isLeaf())
        {
            // print the current node
            System.out.print(node.data + " ");
 
            // next process, the left child of `root` if it exists;
            // otherwise, move to the right child
            node = (node.left != null) ? node.left: node.right;
        }
    }
 
    // Recursive function to print the right boundary of the given binary tree
    // in a bottom-up fashion, except for the leaf nodes
    public static void printRightBoundary(Node root)
    {
        // base case: root is empty, or root is a leaf node
        if (root == null || root.isLeaf()) {
            return;
        }
 
        // recur for the right child of `root` if it exists;
        // otherwise, recur for the left child
        printRightBoundary(root.right != null ? root.right: root.left);
 
        // To ensure bottom-up order, print the value of the nodes
        // after recursion unfolds
        System.out.print(root.data + " ");
    }
 
    // Recursive function to print the leaf nodes of the given
    // binary tree in an inorder fashion
    public static void printLeafNodes(Node root)
    {
        // base case
        if (root == null) {
            return;
        }
 
        // recur for the left subtree
        printLeafNodes(root.left);
 
        // print only leaf nodes
        if (root.isLeaf()) {
            System.out.print(root.data + " ");
        }
 
        // recur for the right subtree
        printLeafNodes(root.right);
    }
 
    // Function to perform the boundary traversal on a given tree
    public static void performBoundaryTraversal(Node root)
    {
        // base case
        if (root == null) {
            return;
        }
 
        // print the root node
        System.out.print(root.data + " ");
 
        // print the left boundary (except leaf nodes)
        printLeftBoundary(root.left);
 
        // print all leaf nodes
        if (!root.isLeaf()) {
            printLeafNodes(root);
        }
 
        // print the right boundary (except leaf nodes)
        printRightBoundary(root.right);
    }
	
	
	
	

}

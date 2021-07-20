/*completedd
 * Given a binary tree where every node has a unique value, and a target key k, find the value of the nearest leaf node to target k in the tree.

Here, nearest to a leaf means the least number of edges travelled on the binary tree to reach any leaf of the tree. Also, a node is called a leaf if it has no children.

In the following examples, the input tree is represented in flattened form row by row. The actual root tree given will be a TreeNode object.

Example 1:

Input:
root = [1, 3, 2], k = 1
Diagram of binary tree:
          1
         / \
        3   2

Output: 2 (or 3)

Explanation: Either 2 or 3 is the nearest leaf node to the target of 1.
Example 2:

Input:
root = [1], k = 1
Output: 1

Explanation: The nearest leaf node is the root node itself.
Example 3:

Input:
root = [1,2,3,4,null,null,null,5,null,6], k = 2
Diagram of binary tree:
             1
            / \
           2   3
          /
         4
        /
       5
      /
     6

Output: 3
Explanation: The leaf node with value 3 (and not the leaf node with value 6) is nearest to the node with value 2.
Note:
root represents a binary tree with at least 1 node and at most 1000 nodes.
Every node has a unique node.val in range [1, 1000].
There exists some node in the given binary tree for which node.val == k.
 */

package leetcodePremium;

public class Closest_Leaf_in_a_Binary_Tree {

	Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
    TreeNode startNode = null;

    /**
     * @param root: the root
     * @param k: an integer
     * @return: the value of the nearest leaf node to target k in the tree
     */
    public int findClosestLeaf(TreeNode root, int k) {
        buildTreeGraph(null, root, k);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(startNode);
        visited.add(startNode);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.left == null && curr.right == null) {
                return curr.val;
            }
            if (graph.containsKey(curr)) {
                for (TreeNode neigh : graph.get(curr)) {
                    if (visited.contains(neigh)) {
                        continue;
                    }
                    queue.offer(neigh);
                    visited.add(neigh);
                }
            }
        }

        return -1;
    }

    private void buildTreeGraph(TreeNode parent, TreeNode child, int k) {
        if (parent != null) {
            graph.computeIfAbsent(parent, x -> new ArrayList<>()).add(child);
            graph.computeIfAbsent(child, x -> new ArrayList<>()).add(parent);
        }
        // 记录起始节点
        if (child.val == k) {
            startNode = child;
        }

        if (child.left != null) {
            buildTreeGraph(child, child.left, k);
        }
        if (child.right != null) {
            buildTreeGraph(child, child.right, k);
        }
    }
	
}

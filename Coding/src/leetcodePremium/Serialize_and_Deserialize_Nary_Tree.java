/*completedd
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
Design an algorithm to serialize and deserialize an N-ary tree. An N-ary tree is a rooted tree in which each node has no more than N children. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that an N-ary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 */

package leetcodePremium;

public class Serialize_and_Deserialize_Nary_Tree {

	// Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();

        serial(sb, root);

        // System.out.println(sb.toString());
        return sb.toString();
    }

    private void serial(StringBuilder sb, Node root) {
        if (root == null) {
            sb.append("#");
            sb.append(",");
        } else {
            sb.append(root.val);
            sb.append(",");
            if (root.children != null) {
                sb.append(root.children.size());
                sb.append(",");
                for (Node child: root.children) {
                    serial(sb, child);
                }
            }
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        Queue<String> queue = new LinkedList<String>(Arrays.asList(data.split(",")));

        return buildTree(queue);
    }

    private Node buildTree(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("#")) {
            return null;
        }

        Node root = new Node(Integer.parseInt(val));
        int childrenCount = Integer.parseInt(queue.poll());

        root.children = new ArrayList<Node>();
        for (int i = 0; i <  childrenCount; i++) {
            root.children.add(buildTree(queue));
        }
        return root;
    }
	
	
}

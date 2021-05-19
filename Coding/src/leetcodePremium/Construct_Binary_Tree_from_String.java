/*completed
 * You need to construct a binary tree from a string consisting of parenthesis and integers. 
The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure. 
You always start to construct the left child node of the parent first if it exists.
Example:
Input: "4(2(3)(1))(6(5))"
Output: return the tree root node representing the following tree:

       4
     /   \
    2     6
   / \   / 
  3   1 5   

Note:
There will only be '(', ')', '-' and '0' ~ '9' in the input string.
An empty tree is represented by "" instead of "()".
 */

package leetcodePremium;

public class Construct_Binary_Tree_from_String {
	
	public TreeNode str2tree(String s) {
        TreeNode root = null;

        int p = i;
        while (i < s.length() && s.charAt(i) != '(' && s.charAt(i) != ')') i++; // get root value
        String tmp = s.substring(p, i);
        if (tmp.length() != 0) { // some empty value like "()"
            int val = Integer.parseInt(tmp);
            root = new TreeNode(val);
        }

        if (i < s.length() && s.charAt(i++) == '(') { // '(' means the start of a child node, careful about boundary
            root.left = str2tree(s);

            if (i < s.length() && s.charAt(i++) == '(') {
                root.right = str2tree(s);
                i++; // when right child finish (not leaf), it's always like "))"
            }
        }

        return root;
    }

}

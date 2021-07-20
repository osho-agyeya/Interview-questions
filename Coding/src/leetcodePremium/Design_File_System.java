/* completedd
 * You are asked to design a file system which provides two functions:

createPath(path, value): Creates a new path and associates a value to it if possible and returns True. Returns False if the path already exists or its parent path doesn't exist.
get(path): Returns the value associated with a path or returns -1 if the path doesn't exist.
The format of a path is one or more concatenated strings of the form: / followed by one or more lowercase English letters. For example, /leetcode and /leetcode/problems are valid paths while an empty string and / are not.

Implement the two functions.

Please refer to the examples for clarifications.

 

Example 1:

Input:
["FileSystem","createPath","get"]
[[],["/a",1],["/a"]]
Output:
[null,true,1]
Explanation:
FileSystem fileSystem = new FileSystem();

fileSystem.createPath("/a", 1); // return true
fileSystem.get("/a"); // return 1
Example 2:

Input:
["FileSystem","createPath","createPath","get","createPath","get"]
[[],["/leet",1],["/leet/code",2],["/leet/code"],["/c/d",1],["/c"]]
Output:
[null,true,true,2,false,-1]
Explanation:
FileSystem fileSystem = new FileSystem();

fileSystem.createPath("/leet", 1); // return true
fileSystem.createPath("/leet/code", 2); // return true
fileSystem.get("/leet/code"); // return 2
fileSystem.createPath("/c/d", 1); // return false because the parent path "/c" doesn't exist.
fileSystem.get("/c"); // return -1 because this path doesn't exist.
 

Constraints:

The number of calls to the two functions is less than or equal to 10^4 in total.
2 <= path.length <= 100
1 <= value <= 10^9
 * 
 */

package leetcodePremium;

public class Design_File_System {
	
	class FileSystem {
	    List<TreeNode> roots;

	    public FileSystem() {
	        roots = new ArrayList<TreeNode>();
	    }

	    public boolean createPath(String path, int value) {
	        if (path.charAt(0) == '/')
	            path = path.substring(1);
	        String[] array = path.split("/");
	        int length = array.length;
	        TreeNode tempNode = null;
	        List<TreeNode> tempList = roots;
	        for (int i = 0; i < length; i++) {
	            String subPath = array[i];
	            int index = binarySearch(tempList, subPath);
	            if (index < 0 && i < length - 1 || index >= 0 && i == length - 1)
	                return false;
	            if (index >= 0) {
	                tempNode = tempList.get(index);
	                tempList = tempNode.getChildren();
	            } else {
	                TreeNode newNode = new TreeNode(subPath, value);
	                if (tempNode == null) {
	                    roots.add(newNode);
	                    Collections.sort(roots);
	                } else
	                    tempNode.addChild(newNode);
	            }
	        }
	        return true;
	    }

	    public int get(String path) {
	        if (path.charAt(0) == '/')
	            path = path.substring(1);
	        String[] array = path.split("/");
	        int length = array.length;
	        TreeNode tempNode = null;
	        List<TreeNode> tempList = roots;
	        for (int i = 0; i < length; i++) {
	            String subPath = array[i];
	            int index = binarySearch(tempList, subPath);
	            if (index < 0)
	                return -1;
	            else {
	                tempNode = tempList.get(index);
	                tempList = tempNode.getChildren();
	            }
	        }
	        return tempNode.getValue();
	    }

	    public int binarySearch(List<TreeNode> list, String subPath) {
	        int low = 0, high = list.size() - 1;
	        while (low <= high) {
	            int mid = (high - low) / 2 + low;
	            TreeNode temp = list.get(mid);
	            String tempPath = temp.getPath();
	            if (tempPath.compareTo(subPath) == 0)
	                return mid;
	            else if (tempPath.compareTo(subPath) < 0)
	                low = mid + 1;
	            else
	                high = mid - 1;
	        }
	        return -low - 1;
	    }
	}

	class TreeNode implements Comparable<TreeNode> {
	    private String path;
	    private int value;
	    private List<TreeNode> children;

	    public TreeNode() {
	        children = new ArrayList<TreeNode>();
	    }

	    public TreeNode(String path, int value) {
	        this.path = path;
	        this.value = value;
	        children = new ArrayList<TreeNode>();
	    }

	    public String getPath() {
	        return path;
	    }

	    public int getValue() {
	        return value;
	    }

	    public List<TreeNode> getChildren() {
	        return children;
	    }

	    public void addChild(TreeNode child) {
	        children.add(child);
	        Collections.sort(children);
	    }

		public int compareTo(TreeNode node) {
			return this.path.compareTo(node.path);
		}
	}

}

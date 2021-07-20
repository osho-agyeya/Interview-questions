/*completedd
 * 
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.

Example 1:
Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at depth 2)

Example 2:
Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17) */

package leetcodePremium;

public class Nested_List_Weight_Sum_II {
	
	 public int depthSumInverse(List<NestedInteger> nestedList) {
	        int height = getHeight(nestedList);
	        return ds(nestedList, height);
	    }
	    private int getHeight(List<NestedInteger> nestedList) {
	        int height = 1;
	        for (NestedInteger ni:nestedList) {
	            if (!ni.isInteger()) {
	                int tmp = getHeight(ni.getList());
	                height = Math.max(height, tmp + 1);
	            }
	        }
	        return height;
	    }
	    private int ds(List<NestedInteger> nestedList, int level) {
	        int sum = 0;
	        for (NestedInteger ni:nestedList) {
	            if (ni.isInteger()) {
	                sum += level * ni.getInteger();
	            }
	            else {
	                sum += ds(ni.getList(), level - 1);
	            }
	        }
	        return sum;
	    }

}

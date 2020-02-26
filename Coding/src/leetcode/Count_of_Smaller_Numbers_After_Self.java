//ddoe
/*t=n^2
 * 
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Input: [5,2,6,1]
Output: [2,1,1,0] 
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class  
	Count_of_Smaller_Numbers_After_Self{
	public List<Integer> countSmaller(int[] nums) {
        int[] res = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        for(int i = nums.length - 1; i >= 0; i--) {
            res[i] = insert(list, nums[i]);
        }
        list.clear();
        for(int i = 0 ; i < nums.length; i++) {
            list.add(res[i]);
        }
        return list;
    }
    
    // binary insert
    private int insert(List<Integer> list, int num) {
        int l = 0;
        int r = list.size() - 1;
        while(l <= r) {
            int mid = l + (r - l)/2;
            int M = list.get(mid);
            if(M >= num) {
                r = mid - 1;
            }else if(M < num) {
                l = mid + 1;
            }
        }
        list.add(l, num);
        return l;
    }

}

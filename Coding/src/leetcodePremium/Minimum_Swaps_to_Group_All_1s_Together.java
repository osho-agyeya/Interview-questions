/*completedd
 * 
 * 
 * Given a binary array data, return the minimum number of swaps required to group all 1’s present in the array together in any place in the array.

 

Example 1:

Input: [1,0,1,0,1]
Output: 1
Explanation: 
There are 3 ways to group all 1's together:
[1,1,1,0,0] using 1 swap.
[0,1,1,1,0] using 2 swaps.
[0,0,1,1,1] using 1 swap.
The minimum is 1.
Example 2:

Input: [0,0,0,1,0]
Output: 0
Explanation: 
Since there is only one 1 in the array, no swaps needed.
Example 3:

Input: [1,0,1,0,1,0,0,1,1,0,1]
Output: 3
Explanation: 
One possible solution that uses 3 swaps is [0,0,0,0,0,1,1,1,1,1,1].
 

Note:

1 <= data.length <= 10^5
0 <= data[i] <= 1
 * 
 */

package leetcodePremium;

public class Minimum_Swaps_to_Group_All_1s_Together {

	public int minSwaps(int[] data) {
        // The variable represents the amount of 1 in the array,
        // it also represents the fixed window length.
        int oneCount = 0;
        for(int i = 0; i < data.length; i++) {
            oneCount += data[i];
        }
    
        int maxWinOneCount = 0;
        int winOneCount = 0;
        
        for(int i = 0; i < data.length; i++) {
            // Increase the value of the element entering the window.
            winOneCount += data[i];
            // Decrease the value of the element leaving the window.
            int left = i - oneCount;
            if(left >= 0) {
                winOneCount -= data[left];
            }
            // If the whole window is in the array, then compare the winOneCount with maxWinOneCount.
            if(left+1 >= 0) {
                maxWinOneCount = Math.max(maxWinOneCount, winOneCount);
            }
        }
        return oneCount - maxWinOneCount;
    }
	
}

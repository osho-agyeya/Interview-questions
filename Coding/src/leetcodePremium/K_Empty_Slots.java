/* completed
 * 
 * 
There is a garden with N slots. In each slot, there is a flower. The N flowers will bloom one by one in N days. In each day, there will be exactly one flower blooming and it will be in the status of blooming since then. 
Given an array flowers consists of number from 1 to N. Each number in the array represents the place where the flower will open in that day. 
For example, flowers[i] = x means that the unique flower that blooms at day i will be at position x, where i and x will be in the range from 1 to N. 
Also given an integer k, you need to output in which day there exists two flowers in the status of blooming, and also the number of flowers between them is k and these flowers are not blooming. 
If there isn't such day, output -1. 
Example 1:
Input: 
flowers: [1,3,2]
k: 1
Output: 2
Explanation: In the second day, the first and the third flower have become blooming.

Example 2:
Input: 
flowers: [1,2,3]
k: 1
Output: -1

Note:
The given array will be in the range [1, 20000].
 * 
 * 
 */



package leetcodePremium;

public class K_Empty_Slots {
	
    static int kSlots(int[] a, int k) {
        int[] days = new int[a.length + 1];
        
        for(int i=0; i<a.length; i++) {
            days[a[i]] = i+1;
        }
        
        int res = Integer.MAX_VALUE;
        
        for(int i=1; i< days.length-k-1; i++){
            int l = days[i];
            int r = days[i+k+1];
            
            int max = Math.max(l, r);
            int min = Math.min(l, r);
            
            boolean flag = true;
            for(int j=1; j<=k; j++){
                if(days[i + j]<max){
                    flag = false;
                    break;
                }
            }
        
            if(flag && max<res){
                res = max;
            }
        }
    
        return res == Integer.MAX_VALUE ? -1 : res;
    }

}

//done
/*
 * Largest Continuous Sequence Zero Sum
Asked in:  
Microsoft
Find the largest continuous sequence in a array which sums to zero.

Example:


Input:  {1 ,2 ,-2 ,4 ,-4}
Output: {2 ,-2 ,4 ,-4}

 NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.
 */

package interviewbit;

import java.util.ArrayList;
import java.util.HashMap;

public class Largest_Continuous_Sequence_Zero_Sum {
	
    public ArrayList<Integer> lszero(ArrayList<Integer> a) {
    	 int start = 0, end = 0;
         HashMap<Integer, Integer> map = new HashMap<>();
         map.put(0, -1);
         int sum = 0;
         for(int i = 0; i < a.size(); i++) {
             sum += a.get(i);
             if(map.containsKey(sum)) {
                 int currStart = map.get(sum),
                     currEnd = i;
                 if(currEnd - currStart + 1 > end - start + 1) {
                     start = currStart;
                     end = currEnd;
                 }
             }
             if(!map.containsKey(sum)) {
                 map.put(sum, i);
             }
         }
         //System.out.println(map);
         
         ArrayList<Integer> result = new ArrayList<>();
         for(int i = start + 1; i <= end; i++) {
             result.add(a.get(i));
         }
         return result;
    }

}

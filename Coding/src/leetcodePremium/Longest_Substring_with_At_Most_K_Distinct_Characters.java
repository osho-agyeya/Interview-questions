/* over, nk, k
 * 
 * this can be done for k=2(Question no. 159 leetcode premium)
 * 
Given a string, find the length of the longest substring T that contains at most k distinct characters. 
For example, Given s = �eceba� and k = 2, 
T is "ece" which its length is 3. 
 * 
 * 
 * 
 */
package leetcodePremium;

import java.util.HashMap;

public class Longest_Substring_with_At_Most_K_Distinct_Characters {
	
	
	/*
	 * 
	 * 
	 */
	
	
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
	    int result = 0;
	    int i=0;
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	 
	    for(int j=0; j<s.length(); j++){
	        char c = s.charAt(j);
	        if(map.containsKey(c)){
	            map.put(c, map.get(c)+1);
	        }else{
	            map.put(c, 1);
	        }
	 
	        if(map.size()<=k){
	            result = Math.max(result, j-i+1);
	        }else{
	            while(map.size()>k){
	                char l = s.charAt(i);
	                int count = map.get(l);
	                if(count==1){
	                    map.remove(l);
	                }else{
	                    map.put(l, map.get(l)-1);
	                }
	                i++;
	            }
	        }
	 
	    }
	 
	    return result;
	}

}

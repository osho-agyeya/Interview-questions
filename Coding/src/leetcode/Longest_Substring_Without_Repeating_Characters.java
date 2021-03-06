//done

/*
 * 
 * Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
//this is good. remember you can use maps to store whatever you want,even indices

package leetcode;

import java.util.*;

public class Longest_Substring_Without_Repeating_Characters {
	
	public int lengthOfLongestSubstring(String s) {
        int size=s.length();
        if(size<=1)
            return size;
        int start=0;
        int stop=1;
        int ans=1;

        Map<Character, Integer> freq=new HashMap<>();
                freq.put(s.charAt(0),1);
        while(start<size && stop<size && start<=stop){  
            char startC=s.charAt(start);
            char stopC=s.charAt(stop);
            int freqStop=freq.getOrDefault(stopC,0);
            if(freqStop==0){                
                freq.put(stopC,1);
                ans=Math.max(ans,stop-start+1);
                stop++;
            }else {
                freq.put(startC,freq.get(startC)-1);
                start++;      
            }
        }
        return ans;    
    }

}

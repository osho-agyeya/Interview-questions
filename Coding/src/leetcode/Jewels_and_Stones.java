//completed

/*
 * 
You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".

 

Example 1:

Input: jewels = "aA", stones = "aAAbbbb"
Output: 3
Example 2:

Input: jewels = "z", stones = "ZZ"
Output: 0
 

Constraints:

1 <= jewels.length, stones.length <= 50
jewels and stones consist of only English letters.
All the characters of jewels are unique.
 * 
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Jewels_and_Stones {

	public int numJewelsInStones(String J, String S) {
        Map<Character,Integer> map = new HashMap<>();
       for(int i = 0; i < S.length(); i++){
           char c = S.charAt(i);
           if(!map.containsKey(c)){
               map.put(c,1);
           }else{
               map.put(c,map.get(c) + 1);
           }
       }
       int total = 0;
       for(int i = 0; i < J.length(); i++){
           char c = J.charAt(i);
           if(map.containsKey(c)){
               total += map.get(c);
           }
       }
       return total;
       
   }
	
}

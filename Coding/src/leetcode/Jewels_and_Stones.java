//done

/*
 * 
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.
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

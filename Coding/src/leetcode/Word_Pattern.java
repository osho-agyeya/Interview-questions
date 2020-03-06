//done
/*
 * Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
 */
package leetcode;

import java.util.HashMap;

public class Word_Pattern {
	
	public boolean wordPattern(String pattern, String str) {
		String[] strs = str.split(" ");
	    
	    if(pattern.length() != strs.length) return false;
	    
	    HashMap<Character, String> hm1 = new HashMap<Character, String>();
	    HashMap<String, Character> hm2 = new HashMap<String, Character>();
	    for(int i=0; i<pattern.length(); ++i) {
	        if(hm1.containsKey(pattern.charAt(i))) {
	        	
	            if(!hm1.get(pattern.charAt(i)).equals(strs[i])) return false;
	        }
	        else {
	            if(hm2.containsKey(strs[i])) return false;
	            else {
	                hm1.put(pattern.charAt(i), strs[i]);
	                hm2.put(strs[i], pattern.charAt(i));
	            }
	        }
	    }
	    
	    return true;
	}


}

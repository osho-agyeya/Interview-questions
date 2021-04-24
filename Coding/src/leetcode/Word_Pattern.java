//completed
/*
 * Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

 

Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", s = "dog dog dog dog"
Output: false
 

Constraints:

1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lower-case English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space. */
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

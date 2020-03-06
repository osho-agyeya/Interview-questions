//done
/*
 * This is the extension problem of Word Pattern I.

Given a pattern and a string str, find if str follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.

Examples:
pattern = "abab", str = "redblueredblue" should return true.
pattern = "aaaa", str = "asdasdasdasd" should return true.
pattern = "aabb", str = "xyzabcxzyabc" should return false.
 */
package leetcode;

import java.util.HashMap;

public class Word_Pattern_II {
	
	public boolean wordPatternMatch(String pattern, String str) {
	    if(pattern.length()==0 && str.length()==0)
	        return true;
	    if(pattern.length()==0)
	        return false;
	 
	    HashMap<Character, String> map = new HashMap<Character, String>();
	 
	    return helper(pattern, str, 0, 0, map);
	}
	 
	public boolean helper(String pattern, String str, int i, int j, HashMap<Character, String> map){
	    if(i==pattern.length() && j==str.length()){
	        return true;
	    }
	 
	    if(i>=pattern.length() || j>=str.length())
	        return false;
	 
	    char c = pattern.charAt(i);
	    for(int k=j+1; k<=str.length(); k++){
	        String sub = str.substring(j, k);
	        if(!map.containsKey(c) && !map.containsValue(sub)){
	            map.put(c, sub);
	            if(helper(pattern, str, i+1, k, map))
	                return true;
	            map.remove(c);
	        }else if(map.containsKey(c) && map.get(c).equals(sub)){
	            if(helper(pattern, str, i+1, k, map))
	                return true;
	        }
	    }
	 
	    return false;
	}

}

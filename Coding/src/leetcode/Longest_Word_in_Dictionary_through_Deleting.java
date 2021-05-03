//completed


/*
 * 
 * 
 * Given a string s and a string array dictionary, return the longest string in the dictionary that can be formed by deleting some of the given string characters. If there is more than one possible result, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

 

Example 1:

Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
Output: "apple"
Example 2:

Input: s = "abpcplea", dictionary = ["a","b","c"]
Output: "a"
 

Constraints:

1 <= s.length <= 1000
1 <= dictionary.length <= 1000
1 <= dictionary[i].length <= 1000
s and dictionary[i] consist of lowercase English letters.
 */
package leetcode;

public class Longest_Word_in_Dictionary_through_Deleting {

public String findLongestWord(String s, List<String> d) {
       String res = "";
       for(String w: d){
         if(isSubsequence(w, s)){
           if(w.length() > res.length()) res = w; 
           if(w.length() == res.length() && w.compareTo(res) < 0) res = w;  
         }  
       }    
       return res;
    }
    
    boolean isSubsequence(String w, String s){
      char[] wc = w.toCharArray();
      char[] sc = s.toCharArray();
      int i = 0, j = 0;
      while(i < wc.length && j < sc.length){
        if(wc[i] == sc[j]) i++;
        j++;    
      }  
      return i == wc.length;  
    }
	
}

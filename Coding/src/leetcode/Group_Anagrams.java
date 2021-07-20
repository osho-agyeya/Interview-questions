/* over, nk, nk
 * 
 *Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lower-case English letters.
 * 
 */
package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Group_Anagrams {
	
	public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            int[] arr = new int[26];
            for(int i = 0;i<s.length();i++){
                arr[s.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(arr);
            List<String> tempList = map.getOrDefault(key, new LinkedList<String>());
            tempList.add(s);
            map.put(key,tempList);
        }
        return new LinkedList<>(map.values()); //nice way
    }
	
	

}

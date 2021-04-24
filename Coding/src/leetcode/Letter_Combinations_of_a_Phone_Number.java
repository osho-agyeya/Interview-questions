//completed

/*
 * 
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */

package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Letter_Combinations_of_a_Phone_Number {

	 public List<String> letterCombinations(String digits) {
	        if(digits.equals(""))
	            return new ArrayList<String>();
	        ArrayList<String> ans = new ArrayList<String>();
	    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	    ans.add("");
	    for(int i =0; i<digits.length();i++){
	        int x = Character.getNumericValue(digits.charAt(i));
	        while(ans.get(0).length()==i){
	            String t = ans.remove(0);
	            for(char s : mapping[x].toCharArray())
	                ans.add(t+s);
	        }
	    }
	    return ans;
	    }
	
}

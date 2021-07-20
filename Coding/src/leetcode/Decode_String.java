/* over, maxKxn, n
 * 
 * 
 * 
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
Example 4:

Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"
 

Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].
 */
package leetcode;

public class Decode_String {
	
	
	/*
	 * Approach 3: Using Recursion
Intuition

In the previous approach, we implemented an external stack to keep the track of each character traversed. Ideally, a stack is required when we have nested encoded string in the form k[string k[string]].

Using this intuition, we could start by building k and string and recursively decode for each nested substring. The recursion uses an internal call stack to store the previous state. Let's understand the algorithm in detail.

Algorithm

Build result while next character is letter (a-z) and build the number k while next character is a digit (0-9) by iterating over string s.
Ignore the next [ character and recursively find the nested decodedString.
Decode the current pattern k[decodedString] and append it to the result.
Return the current result.
The above steps are repeated recursively for each pattern until the entire string s is traversed.

Base Condition: We must define a base condition that must be satisfied to backtrack from the recursive call. In this case, we would backtrack and return the result when we have traversed the string s or the next character is ] and there is no nested substring.

Thanks to @bluedawnstar for suggesting the solution.

Implementation


Complexity Analysis

Assume, nn is the length of the string ss.

Time Complexity: \mathcal{O}(\text{maxK} \cdot n)O(maxK⋅n) as in Approach 2

Space Complexity: \mathcal{O}(n)O(n). This is the space used to store the internal call stack used for recursion. As we are recursively decoding each nested pattern, the maximum depth of recursive call stack would not be more than nn
	 * 
	 * 
	 */
	
private int i = 0;
    
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '[') {
                i++;
                String str = decodeString(s);
                for (int k = 0; k < num; k++) {
                    sb.append(str);
                }
                num = 0;
            } else if (c == ']') {
                return sb.toString();
            } else if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }

}

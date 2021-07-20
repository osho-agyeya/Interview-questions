/* over, n, 1
 * Given a string num which represents an integer, return true if num is a strobogrammatic number.

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 

Example 1:

Input: num = "69"
Output: true
Example 2:

Input: num = "88"
Output: true
Example 3:

Input: num = "962"
Output: false
Example 4:

Input: num = "1"
Output: true
 

Constraints:

1 <= num.length <= 50
num consists of only digits.
num does not contain any leading zeros except for zero itself.
 */

package leetcodePremium;

public class Strobogrammatic_Number {
	
	/*
	 * 
	 * Approach 2: Two Pointers
Intuition

You might have observed a pattern in how digits move in the rotation: the first and last swap, the second and the second-to-last swap, etc.

Going from outside to in, pairs of numbers are swapped.

For the number to be strobogrammatic, we have to write the same number back into each index. As we deduced earlier, there are only five valid pairs of numbers for this to work.

0 and 0.
1 and 1.
6 and 9.
8 and 8.
9 and 6.
Therefore, we can check each pair that would swap in the reversal for whether or not it is one of the five pairs listed above. If all pairs are on the list, then the number is strobogrammatic. For odd-lengthed numbers, the middle digit has to be 0, 1, or 8.

Current
1 / 6
Algorithm

We initialize two pointers; left and right. We then iterate both pointers towards the middle at each step, ensuring that the digits at left and right correspond to one of the five valid pairs. An elegant way of doing this is to define a hash map of valid left -> right mappings (like what we did in the hash map variant of approach 1).

define function isStrobogrammatic(num):
    rotations = a new hash map
    add to rotations: '0' -> '0', '1' -> '1', '8' -> '8', '6' -> '9', and '9' -> '6'
    left = 0
    right = num.length - 1
    while left <= right:
        if left is not in rotations:
            return false
        expected_rotation = get rotation for character at position left in num
        if expected_rotation is not the same as the character at right in num:
            return false
        add 1 to left
        subtract 1 from right
    return true
If no invalid pairs are found, then the number must be strobogrammatic. Note that the middle-digit-of-an-odd-number case is handled correctly; the final iteration will have left = right. If they are both pointing to the same 0, 1, or 8, then the condition will be false, and true returned at the end. If they are both pointing at a 6, then the condition will be true, and false will be returned, as expected_rotation will be 9, and num[right] will be 6.

Be careful of that middle value in an odd-lengthed number. While the number 8 9 0 6 8 is strobogrammatic, the number 8 9 4 6 8 is not. And nor is 8 9 9 6 8 (this last example is one that is particularly likely to catch some people out, as the middle digit is rotatable, but it doesn't become itself).

Code


Complexity Analysis

Let NN be the length of the input string.

Time complexity : O(N)O(N).

For each of the NN digits in the string, we're doing a single lookup and comparison.

Space complexity : O(1)O(1).

We are only using constant extra space. This is an in-place algorithm.
	 * 
	 */

    public boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> dict = new HashMap<>();
        dict.put('0','0');
        dict.put('1','1');
        dict.put('8','8');
        dict.put('6','9');
        dict.put('9','6');
        int i=0; 
        int j = num.length()-1;
        while(i<=j){
            char f = num.charAt(i);
            char b = num.charAt(j);
            if(dict.containsKey(f) && dict.containsKey(b) && dict.get(f) == b){
                i++;j--;
            }else{
                return false;
            }
        }
        return true;

    }
}

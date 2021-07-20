/* completedd
 * 
 * There is a special keyboard with all keys in a single row.

Given a string keyboard of length 26 indicating the layout of the keyboard (indexed from 0 to 25), initially your finger is at index 0. To type a character, you have to move your finger to the index of the desired character. The time taken to move your finger from index i to index j is |i - j|.

You want to type a string word. Write a function to calculate how much time it takes to type it with one finger.

Example 1:

Input: keyboard = "abcdefghijklmnopqrstuvwxyz", word = "cba"
Output: 4
Explanation: The index moves from 0 to 2 to write 'c' then to 1 to write 'b' then to 0 again to write 'a'.
Total time = 2 + 1 + 1 = 4. 
1
2
3
4
Example 2:

Input: keyboard = "pqrstuvwxyzabcdefghijklmno", word = "leetcode"
Output: 73
1
2
Constraints:

keyboard.length == 26
keyboard contains each English lowercase letter exactly once in some order.
1 <= word.length <= 10^4
word[i] is an English lowercase letter.
 */


package leetcodePremium;

public class Single_Row_Keyboard {
	
	/* Solution */
    public int calculateTime(String keyboard, String word) {
         
        char[] chars = keyboard.toCharArray();      
        int[] countArray = new int[26];
        for(int i=0; i<countArray.length; i++) {
            countArray[chars[i] - 'a'] = i;
        }
         
        int result = 0, position = 0;       
        char[] charsWord = word.toCharArray();
        for(int i=0; i<charsWord.length; i++) {
            result = result +  Math.abs(countArray[charsWord[i] - 'a'] - position);
            position = countArray[charsWord[i] - 'a'];
        }
        return result;
    }

}

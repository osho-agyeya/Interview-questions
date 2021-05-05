package leetcode;
/*completed
 *Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.

 

Example 1:

Input: s = "hello"
Output: "holle"
Example 2:

Input: s = "leetcode"
Output: "leotcede"
 

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.
 */
public class Reverse_Vowels_of_a_String {
	
	static final String vowels = "aeiouAEIOU";
	public String reverseVowels(String s) {
	    int first = 0, last = s.length() - 1;
	    char[] array = s.toCharArray();
	    while(first < last){
	        while(first < last && vowels.indexOf(array[first]) == -1){
	            first++;
	        }
	        while(first < last && vowels.indexOf(array[last]) == -1){
	            last--;
	        }
	        char temp = array[first];
	        array[first] = array[last];
	        array[last] = temp;
	        first++;
	        last--;
	    }
	    return new String(array);
	}
}

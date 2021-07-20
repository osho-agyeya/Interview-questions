/* over, n, 26
 * Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
 

Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.
 */

package leetcode;

public class Isomorphic_Strings {
	
	/*
	 * Overview
This is one of those problems where we can come up with a whole suite of different solutions, with similar time and space complexities. The discussion section is filled with various tricks to solve this problem, however, we will stick to a couple of approaches that have the optimal time and space complexity and are reasonably easy to come up with during an interview. Regardless of which approach we use, three conditions must be met for the two strings to be isomorphic:

We can map a character only to itself or to one other character.
No two character should map to same character.
Replacing each character in string s with the character it is mapped to results in string t.
Matching the order will be easy. Since we will iterate over the two strings and do some sort of comparison from left to right, the task of ensuring that the character order is the same in both strings will take care of itself. Next, we need to somehow maintain a mapping of characters (hint: dictionary) or come up with a way to "convert" both of the strings to a common format (think integer assignment to characters) and then check if the converted strings are the same.

These are the two solutions that we will explore. Again, many other tricks can be used to solve this problem, and thus there are a variety of different solutions. A compilation of other solutions can be found here, however, some of these solutions would be difficult to come up with during an interview. So, in this article, we will focus on solutions that are both intuitive and have optimal complexity.


Approach 1: Character Mapping with Dictionary
Intuition

The first solution is based on the approach indicated in the problem statement itself. We will process both of the strings from left to right. At each step, we take one character at a time from the two strings and compare them. There are three cases we need to handle here:

If the characters don't have a mapping, we add one in the dictionary and move on.

Example for when we don't have a mapping

Figure 1. The first encounter for a new character in both strings which are not yet mapped.

The characters already have a mapping in the dictionary. If that is the case, then we're good to go.

Example for when we have a mapping

Figure 2. Example for when we already had a mapping between the corresponding characters.

The final case is when a mapping already exists for one of the characters but it doesn't map to the other character at hand. In this case, we can safely conclude that the given strings are not isomorphic and we can return.

If at this point you're ready to move on to the algorithm, take a step back and think about the correctness of this solution. The above three cases only care about one-way-mapping i.e. mapping characters from the first string to the second one only. Don't we need the mapping from the other side as well?

Breaking example using our existing 3 cases

Figure 3. Example for when a single dictionary implementation breaks.

We will need two dictionaries instead of one since we need one-to-one mapping from the string s to string t and vice versa. Let's look at the algorithm to see the modified cases.

Algorithm

We define a dictionary mapping_s_t which will be used to map characters in string s to characters in string t and another dictionary mapping_t_s which will be used to map characters in string t to characters in string s.
Next, we iterate over the two strings one character at a time.
Let's assume the character in the first string is c1 and the corresponding character in the second string is c2.
If c1 does not have a mapping in mapping_s_t and c2 does not have a mapping in mapping_t_s, we add the corresponding mappings in both the dictionaries and move on to the next character.
At this point, we expect both the character mappings to exist in the dictionaries and their values should be mapping_s_t[c1] = c2 and mapping_t_s[c2] = c1. If either of these conditions fails (c1 is not in the dictionary, c2 is not in the dictionary, unexpected mapping), we return false.
Return true once both the strings have been exhausted.
Implementation


Complexity Analysis

Here NN is the length of each string (if the strings are not the same length, then they cannot be isomorphic).

Time Complexity: O(N)O(N). We process each character in both the strings exactly once to determine if the strings are isomorphic.
Space Complexity: O(1)O(1) since the size of the ASCII character set is fixed and the keys in our dictionary are all valid ASCII characters according to the problem statement.

	 * 
	 * 
	 */
	
	public boolean isIsomorphic (String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }

}

//completed

//t=O(B)
//s=O(UNIQUE)

/*
 * 
Given two strings a and b, return true if you can swap two letters in a so the result is equal to b, otherwise, return false.

Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at a[i] and a[j].

For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
 

Example 1:

Input: a = "ab", b = "ba"
Output: true
Explanation: You can swap a[0] = 'a' and a[1] = 'b' to get "ba", which is equal to b.
Example 2:

Input: a = "ab", b = "ab"
Output: false
Explanation: The only letters you can swap are a[0] = 'a' and a[1] = 'b', which results in "ba" != b.
Example 3:

Input: a = "aa", b = "aa"
Output: true
Explanation: You can swap a[0] = 'a' and a[1] = 'a' to get "aa", which is equal to b.
Example 4:

Input: a = "aaaaaaabc", b = "aaaaaaacb"
Output: true
 

Constraints:

1 <= a.length, b.length <= 2 * 104
a and b consist of lowercase letters.
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Buddy_Strings {
	
	public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            Set<Character> s = new HashSet<Character>();
            for (char c : A.toCharArray()) s.add(c);
            return s.size() < A.length();
        }
        List<Integer> dif = new ArrayList<>();
        for (int i = 0; i < A.length(); ++i) if (A.charAt(i) != B.charAt(i)) dif.add(i);
        return dif.size() == 2 && A.charAt(dif.get(0)) == B.charAt(dif.get(1)) && A.charAt(dif.get(1)) == B.charAt(dif.get(0));
    }

}

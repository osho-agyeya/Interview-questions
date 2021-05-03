/*completed
 * Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to wrap the substrings in s that exist in dict. If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag. Also, if two substrings wrapped by bold tags are consecutive, you need to combine them. 
Example 1:
Input: 
s = "abcxyz123"
dict = ["abc","123"]
Output:
"<b>abc</b>xyz<b>123</b>"

Example 2:
Input: 
s = "aaabbcc"
dict = ["aaa","aab","bc"]
Output:
"<b>aaabbc</b>c"

Note:
The given dict won't contain duplicates, and its length won't exceed 100.
All the strings in input have length in range [1, 1000]. 
 */

package leetcodePremium;

public class Add_Bold_Tag_in_String {
	
	public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for (String str : dict) {
            int len = str.length();
            for (int i = 0; i < s.length()-len+1; i++) {
                String sub = s.substring(i, i+len);
                if (str.equals(sub)) {
                    for (int j = i; j < i+len; j++) {
                        bold[j] = true;
                    }
                }
            }
        }
        int start = -1;
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < s.length(); k++) {
            if (start == 0 && bold[k] == false) {
                sb.append("</b>").append(s.charAt(k));
                start = -1;
            } else if (start == -1 && bold[k] == true) {
                sb.append("<b>").append(s.charAt(k));
                start = 0;
            } else {
                sb.append(s.charAt(k));
            }
        }
        if (bold[s.length()-1]) {
            sb.append("</b>");
        }
        return sb.toString();
    }
	
	

}

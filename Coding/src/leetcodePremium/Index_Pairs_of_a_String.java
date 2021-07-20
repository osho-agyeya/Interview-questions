/*completedd
 *
 * Given a text string and words (a list of strings), return all index pairs [i, j] so that the substring text[i]...text[j] 
is in the list of words.
Input: text = "thestoryofleetcodeandme", words = ["story","fleet","leetcode"]
Output: [[3,7],[9,13],[10,17]]
Input: text = "ababa", words = ["aba","ab"]
Output: [[0,1],[0,2],[2,3],[2,4]]
Note:
All strings contains only lowercase English letters.
It's guaranteed that all strings in words are different.
1 <= text.length <= 100
1 <= words.length <= 20
1 <= words[i].length <= 50
Return the pairs [i,j] in sorted order (i.e. sort them by their first coordinate in case of ties sort them 
by their second coordinate).
 * 
 */

package leetcodePremium;

public class Index_Pairs_of_a_String {

	public int[][] indexPairs(String text, String[] words) {
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < text.length(); i++){
            for(String s : words){
                if(i + s.length() > text.length()) continue;
                if(text.substring(i, i+s.length()).equals(s)){
                    res.add(new int[]{i, i + s.length()-1});
                }
            }
        }
        int[][] ans = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        Arrays.sort(ans, (a,b)-> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        return ans;
    }
	
}

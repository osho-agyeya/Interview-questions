/*completed
 * Write a function to generate the generalized abbreviations of a word.
Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 */

package leetcodePremium;

public class Generalized_Abbreviation {
	
	public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();

        getAbbreviations(word, 0, 0, "", res);
        return res;
    }

    public void getAbbreviations(String word, int pos, int count, String curStr, List<String> res) {
        if (pos == word.length()) {
            if (count > 0) {
                curStr += count;
            }
            res.add(curStr);
            return;
        }

        // Abbreviate the current character
        getAbbreviations(word, pos + 1, count + 1, curStr, res);
        // Keep the current character
        getAbbreviations(word, pos + 1, 0, curStr + (count > 0 ? count : "") + word.charAt(pos), res);
    }

}

/*completed
 * An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations: 
a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
Example: 
Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true
 */

package leetcodePremium;

public class Unique_Word_Abbreviation {

    Map<String, String> dict;
    public Unique_Word_Abbreviation(String[] dictionary) {
        dict = new HashMap<>();
        String abbr;
        for (String word : dictionary) {
            abbr = getAbbr(word);
            if (!dict.containsKey(abbr)) //first time to encounter the new abbr
                dict.put(abbr, word);
            else if (!dict.get(abbr).equals(word)) // next time, original word is different
                dict.put(abbr, "-1"); // -1: not unique
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        if (!dict.containsKey(abbr))
            return true;
        else
            return dict.get(abbr).equals(word) ? true : false;
    }

    private String getAbbr(String word) {
        int n = word.length();
        if (n < 3)
            return word;
        return "" + word.charAt(0) + (n - 2) + word.charAt(n - 1);
    }
	
}

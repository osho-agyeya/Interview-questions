/*completed
 * 
Given a set of words (without duplicates), find all word squares you can build from them.
A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).
For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.
b a l l
a r e a
l e a d
l a d y
Note:
There are at least 1 and at most 1000 words.
All words will have the exact same length.
Word length is at least 1 and at most 5.
Each word contains only lowercase English alphabet a-z.

Example 1: 
Input:
["area","lead","wall","lady","ball"]

Output:
[
  [ "wall",
    "area",
    "lead",
    "lady"
  ],
  [ "ball",
    "area",
    "lead",
    "lady"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).

Example 2: 
Input:
["abat","baba","atan","atal"]

Output:
[
  [ "baba",
    "abat",
    "baba",
    "atan"
  ],
  [ "baba",
    "abat",
    "baba",
    "atal"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters)
 */

package leetcodePremium;

public class Word_Squares {

	public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        // edge cases
        if (words == null || words.length == 0) return res;

        // build trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            build(root, word);
            root.candidates.add(word);
        }

        // backtracking
        search(root, new ArrayList<String>(), res);

        return res;
    }
    private void search(TrieNode root, List<String> note, List<List<String>> res) {
        // exit
        if (note.size() > 0 && note.size() == note.get(0).length()) {
            res.add(new ArrayList<>(note));
            return;
        }

        String prefix = buildPrefix(note);
        List<String> candidates = getCandidates(root, prefix);
        for (String candi : candidates) {
            note.add(candi);
            search(root, note, res);
            note.remove(note.size() - 1);
        }
    }
    private List<String> getCandidates(TrieNode root, String prefix) {
        TrieNode r = root;
        for (int i = 0; i < prefix.length(); i++) {
            int pos = prefix.charAt(i) - 'a';
            if (r.next[pos] == null) return new ArrayList<>();
            r = r.next[pos];
        }
        return r.candidates;
    }
    private String buildPrefix(List<String> note) {
        StringBuilder sb = new StringBuilder();
        int col = note.size();
        for (String s : note) {
            if(col < s.length()) sb.append(s.charAt(col));
        }
        return sb.toString();
    }
    private void build(TrieNode root, String word) {
        TrieNode r = root;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (r.next[pos] == null) r.next[pos] = new TrieNode();
            r = r.next[pos];
            r.candidates.add(word);
        }
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    List<String> candidates = new ArrayList<>();
}
	

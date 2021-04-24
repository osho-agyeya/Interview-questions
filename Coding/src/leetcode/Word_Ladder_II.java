//completed
/*
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
Explanation: There are 2 shortest transformation sequences:
"hit" -> "hot" -> "dot" -> "dog" -> "cog"
"hit" -> "hot" -> "lot" -> "log" -> "cog"
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: []
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 5
endWord.length == beginWord.length
1 <= wordList.length <= 1000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.*/

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Word_Ladder_II {
	
	 public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
         List<List<String>> res = new ArrayList<>();
        Queue<List<String>> queue = new LinkedList<>();
        queue.offer(new ArrayList<>(Arrays.asList(beginWord)));
        Set<String> visited = new HashSet<>();
        Set<String> word_list = new HashSet<>(wordList);
        boolean found = false;
        if (!word_list.contains(endWord)) return res;
        while (!queue.isEmpty() && !word_list.isEmpty()) {
            for (int i = queue.size(); i > 0; --i) {
                List<String> path = queue.poll();
                String back_word = path.get(path.size() - 1);
                for (int j = 0; j < back_word.length(); j++) {
                    char[] chs = back_word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (chs[j] == c) continue;
                        chs[j] = c;
                        String next_word = String.valueOf(chs);
                        if (next_word.equals(endWord)) {
                            path.add(next_word);
                            res.add(path);
                            found = true;
                        }
                        if (word_list.contains(next_word)) {
                            visited.add(next_word);
                            List<String> new_path = new ArrayList<>(path);
                            new_path.add(next_word);
                            queue.offer(new_path);
                        }
                    }
                }
            }
            if (found) break;
            word_list.removeAll(visited);
            visited.clear();
        }
        return res;
    }

}

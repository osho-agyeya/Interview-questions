//done
/*
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: []

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

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

//completed
/*
Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, determine if two sentences are similar. 
For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are similar, if the similar word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]]. 
Note that the similarity relation is transitive. For example, if "great" and "good" are similar, and "fine" and "good" are similar, then "great" and "fine" are similar. 
Similarity is also symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar. 
Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, even though there are no specified similar word pairs. 
Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"]. 
Note: 
The length of words1 and words2 will not exceed 1000.
The length of pairs will not exceed 2000.
The length of each pairs[i] will be 2.
The length of each words[i] and pairs[i][j] will be in the range [1, 20].
 */

package leetcodePremium;

public class Sentence_Similarity_II {
	
	public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }

        Map<String, Set<String>> graph = new HashMap<>();

        for (String[] pair : pairs) {
            graph.putIfAbsent(pair[0], new HashSet<>());
            graph.putIfAbsent(pair[1], new HashSet<>());

            graph.get(pair[0]).add(pair[1]);
            graph.get(pair[1]).add(pair[0]);
        }

        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) {
                continue;
            }

            if (!graph.containsKey(words1[i]) || !graph.containsKey(words2[i])) {
                return false;
            }
            Set<String> visited = new HashSet<>();

            if (!dfs(words1[i], words2[i], graph, visited)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(String startWord, String endWord, Map<String, Set<String>> graph, Set<String> visited) {
        if (graph.get(startWord).contains(endWord)) {
            return true;
        }

        if (visited.contains(startWord)) {
            return false;
        }

        visited.add(startWord);
        for (String nextWord : graph.get(startWord)) {
            if (dfs(nextWord, endWord, graph, visited)) {
                return true;
            }
        }
        return false;
    }
	
}

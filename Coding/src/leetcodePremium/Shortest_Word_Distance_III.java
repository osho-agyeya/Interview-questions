/*completedd
 *This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = �makes�, word2 = �coding�, return 1.
Given word1 = "makes", word2 = "makes", return 3.

Note:
You may assume word1 and word2 are both in the list. */

package leetcodePremium;

public class Shortest_Word_Distance_III {

	public int shortestWordDistance(String[] words, String word1, String word2) {
		   if(words==null || words.length<1 || word1==null || word2==null)
		        return 0;
		 
		   int m=-1;
		   int n=-1;
		 
		   int min = Integer.MAX_VALUE;
		   int turn=0;
		   if(word1.equals(word2))
		        turn = 1;
		 
		   for(int i=0; i<words.length; i++){
		        String s = words[i];
		        if(word1.equals(s) && (turn ==1 || turn==0)){
		            m = i;
		            if(turn==1) turn=2;
		            if(n!=-1)
		                min = Math.min(min, m-n);
		        }else if(word2.equals(s) && (turn==2 || turn==0)){
		            n = i;
		            if(turn==2) turn =1;
		            if(m!=-1)
		                min = Math.min(min, n-m);
		        }
		   }
		 
		   return min;
		}
	
}

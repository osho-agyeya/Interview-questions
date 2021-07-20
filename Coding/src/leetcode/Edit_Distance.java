/* over, mn, mn
 * 
 * 
 * 
 * 
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 

Constraints:

0 <= word1.length, word2.length <= 500
word1 and word2 consist of lowercase English letters.
 * 
 * 
 * 
 */


package leetcode;

public class Edit_Distance {
	
	
	/*
	 * 
	 * Intuition
The edit distance algorithm is very popular among the data scientists. It's one of the basic algorithms used for evaluation of machine translation and speech recognition.

The naive approach would be to check for all possible edit sequences and choose the shortest one in-between. That would result in an exponential complexity and it's an overkill since we actually don't need to have all possible edit sequences but just the shortest one.


Approach 1: Dynamic Programming
The idea would be to reduce the problem to simple ones. For example, there are two words, horse and ros and we want to compute an edit distance D for them. One could notice that it seems to be more simple for short words and so it would be logical to relate an edit distance D[n][m] with the lengths n and m of input words.

Let's go further and introduce an edit distance D[i][j] which is an edit distance between the first i characters of word1 and the first j characters of word2.

edit_distance

It turns out that one could compute D[i][j], knowing D[i - 1][j], D[i][j - 1] and D[i - 1][j - 1].

There is just one more character to add into one or both strings and the formula is quite obvious.

If the last character is the same, i.e. word1[i] = word2[j] then

D[i][j] = 1 + \min(D[i - 1][j], D[i][j - 1], D[i - 1][j - 1] - 1)D[i][j]=1+min(D[i−1][j],D[i][j−1],D[i−1][j−1]−1)

and if not, i.e. word1[i] != word2[j] we have to take into account the replacement of the last character during the conversion.

D[i][j] = 1 + \min(D[i - 1][j], D[i][j - 1], D[i - 1][j - 1])D[i][j]=1+min(D[i−1][j],D[i][j−1],D[i−1][j−1])

So each step of the computation would be done based on the previous computation, as follows:

compute

The obvious base case is an edit distance between the empty string and non-empty string that means D[i][0] = i and D[0][j] = j.

Now we have everything to actually proceed to the computations

Current
1 / 19

Complexity Analysis

Time complexity : \mathcal{O}(m n)O(mn) as it follows quite straightforward for the inserted loops.
Space complexity : \mathcal{O}(m n)O(mn) since at each step we keep the results of all previous computations.
	 * 
	 * 
	 */
	
	public int minDistance(String word1, String word2) {
        int size1= word1.length();
        int size2= word2.length();
        
        if(size1 == 0)
            return size2;
        if(size2 == 0)
            return size1;
        int[][] mat = new int[size1+1][size2+1];
        
        for(int i=0;i<=size1;i++)
        {
            mat[i][0]=i;
        }
        
        for(int i=0;i<=size2;i++)
        {
            mat[0][i]=i;
        }
        
        for(int i=1;i<=size1;i++)
            for(int j=1;j<=size2;j++)
            {
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    mat[i][j] = mat[i-1][j-1];
                else
                    mat[i][j] = Math.min(Math.min(mat[i-1][j-1] +1,mat[i-1][j]+1),mat[i][j-1]+1) ;
            }
        return mat[size1][size2];
    }

}

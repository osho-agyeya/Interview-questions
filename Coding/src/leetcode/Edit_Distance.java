//done

/*
 * 
 * 
 * t=word1 x word2
 * 
 * 
 * 
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

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
 * 
 * 
 * 
 * 
 * 
 * 
 */


package leetcode;

public class Edit_Distance {
	
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

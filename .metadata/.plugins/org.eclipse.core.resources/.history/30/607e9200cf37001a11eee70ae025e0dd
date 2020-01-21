//ddone
/*
 * Arrange II
Asked in:  
Amazon
You are given a sequence of black and white horses, and a set of K stables numbered 1 to K. You have to accommodate the horses into the stables in such a way that the following conditions are satisfied:

You fill the horses into the stables preserving the relative order of horses. For instance, you cannot put horse 1 into stable 2 and horse 2 into stable 1. You have to preserve the ordering of the horses.
No stable should be empty and no horse should be left unaccommodated.
Take the product (number of white horses * number of black horses) for each stable and take the sum of all these products. This value should be the minimum among all possible accommodation arrangements
Example:


Input: {WWWB} , K = 2
Output: 0

Explanation:
We have 3 choices {W, WWB}, {WW, WB}, {WWW, B}
for first choice we will get 1*0 + 2*1 = 2.
for second choice we will get 2*0 + 1*1 = 1.
for third choice we will get 3*0 + 0*1 = 0.

Of the 3 choices, the third choice is the best option. 

If a solution is not possible, then return -1
 */

package interviewbit;

public class Arrange_II {
	
	
	public int arrange(int start, int stables, String horses, int K, int [][] table) {
        int N = horses.length();
        if(start >= N) {
            if(stables == K) 
                return 0;
            else // reach the end but did not allocate all stables
                return Integer.MAX_VALUE; //no solution, 
        } else {
            if(stables == K) {
                // have not finish allocating all the horses...
                return Integer.MAX_VALUE;
            }
            if(table[start][stables] != -1)
                return table[start][stables];
        }
        
        int W=0;
        int B=0;
        int min=Integer.MAX_VALUE;
        for(int i=start; i<N; i++) {
            if(horses.charAt(i)=='W')
                W++;
            else
                B++;
            if(W*B > min) break;
            
            int result = arrange(i+1, stables+1, horses, K, table);
            if(result != Integer.MAX_VALUE)
                min = Math.min(min, result+(W*B));
            table[start][stables] = min;
        }
        return min;
    }
    
    public int arrange(String horses, int K) {
        int N = horses.length();
        int [][] table = new int[N][K];
        for(int n=0;n<N;n++) {
            for(int k=0;k<K;k++) {
                table[n][k] = -1;
            }
        }
        int tmp = arrange(0, 0, horses, K, table);
        return tmp == Integer.MAX_VALUE ? -1 : tmp;
    }

}

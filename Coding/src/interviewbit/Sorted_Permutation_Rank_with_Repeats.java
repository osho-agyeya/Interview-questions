//not done
/*
 * Sorted Permutation Rank with Repeats
Asked in:  
Housing
Zenefits
Given a string, find the rank of the string amongst its permutations sorted lexicographically.
Note that the characters might be repeated. If the characters are repeated, we need to look at the rank in unique permutations.
Look at the example for more details.

Example :

Input : 'aba'
Output : 2

The order permutations with letters 'a', 'a', and 'b' : 
aab
aba
baa
The answer might not fit in an integer, so return your answer % 1000003

 NOTE: 1000003 is a prime number
NOTE: Assume the number of characters in string < 1000003
 */

package interviewbit;

public class Sorted_Permutation_Rank_with_Repeats {

	private static final int M = 1000003;
	@SuppressWarnings("deprecation")
	public int findRank(String a) {
	    int n = a.length();
	    long[] facts = new long[n + 1];
	    long[] infacts = new long[n + 1];
	    facts[0] = infacts[0] = 1;
        for (int i = 1; i <= n; i++) {
            facts[i] = (facts[i - 1] * i) % M;
            infacts[i] = modExp(facts[i], M - 2);
            //System.out.println(i + " " + facts[i] + " " + infacts[i]);
        }
        
        int[] c = new int[52];
        for (char ch : a.toCharArray()) {
            c[o(ch)]++;
        }
        
        long rank = 0;
        int count = a.length();
        for (char ch : a.toCharArray()) {
            count--;
            for (int t = 0; t < o(ch); t++) {
                if (c[t] > 0) {
                    c[t]--;
                    long trank = facts[count];
                    //System.out.println("t" + trank);
                    for (int i = 0; i < 52; i++) {
                        if (c[i] > 0) {
                            trank = (trank * infacts[c[i]]) % M;
                            //System.out.println("t" + trank);
                        }
                    }
                    rank = (rank + trank) % M;
                    //System.out.println("r" + rank);
                    c[t]++;
                }
            }
            c[o(ch)]--;
        }
	    return new Long((rank + 1) % M).intValue();
	}
	
	private int o(char ch) {
	    if (ch <= 'Z') return ch - 'A';
	    return ch - 'a' + 26;
	}
	
	public long modExp(long xint, long yint) {
	    long res = 1;
	    long x = xint;
	    long y = yint;
	    //System.out.println("Exp " + x + " " + y + " " + res);
	    while (y > 0) {
	        if ((y & 1) == 1) {
	            res = (res * x) % M;
	        }
	        x = (x * x) % M;
	        y >>= 1;
	    //System.out.println("Exp " + x + " " + y + " " + res);
	    }
	    //return new Long(res).intValue();
	    return res;
	}
	
	
}

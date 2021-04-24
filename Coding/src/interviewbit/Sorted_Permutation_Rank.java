//completed
/*
 * Sorted Permutation Rank
Asked in:  
Housing
Zenefits
Microsoft
Given a string, find the rank of the string amongst its permutations sorted lexicographically.
Assume that no characters are repeated.

Example :

Input : 'acb'
Output : 2

The order permutations with letters 'a', 'c', and 'b' : 
abc
acb
bac
bca
cab
cba
The answer might not fit in an integer, so return your answer % 1000003
 */

package interviewbit;

public class Sorted_Permutation_Rank {
	
	 private final int DIVISOR = 1000003;
    
//    public static void main(String[] args) {
//        System.out.println(new SortedPermutationRank().findRank("zabcdegflkpotqsr"));
//    }
    
    public int findRank(String a) {
        if (a.length() == 1) {
            return 1;
        }
        int sortedPosition = getSortedPosition(a);
        int posRank = (sortedPosition * factorial(a.length()-1)) % DIVISOR;
        return (posRank + findRank(a.substring(1))) % DIVISOR;
    }
    
    /**
     * Sorted position is the rank in ascending order of the first character.
     * input string should always be of length greater than 1. 
     * @param a
     * @return
     */
    private int getSortedPosition(String a) {
        int rank = 0;
        for (int i = 1; i < a.length(); i++) {
            if (a.charAt(i) < a.charAt(0)) {
                rank++;
            }
        }
        return rank;
    }

    /**
     * Method to return factorial of a number with mod of 1000003
     * @param n
     * @return
     */
    public int factorial (int n) {
        int prod = 1; 
        for (int i = 1; i <= n; i++) {
            prod *= i; 
            prod %= DIVISOR;
        }
        return prod;
    }

}

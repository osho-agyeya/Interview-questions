//not done
/*
 * Stringoholics
You are given an array A consisting of strings made up of the letters ‘a’ and ‘b’ only.
Each string goes through a number of operations, where:

1.	At time 1, you circularly rotate each string by 1 letter.
2.	At time 2, you circularly rotate the new rotated strings by 2 letters.
3.	At time 3, you circularly rotate the new rotated strings by 3 letters.
4.	At time i, you circularly rotate the new rotated strings by i % length(string) letters.

Eg: String is "abaa"

1.	At time 1, string is "baaa", as 1 letter is circularly rotated to the back
2.	At time 2, string is "aaba", as 2 letters of the string "baaa" is circularly rotated to the back
3.	At time 3, string is "aaab", as 3 letters of the string "aaba" is circularly rotated to the back
4.	At time 4, string is again "aaab", as 4 letters of the string "aaab" is circularly rotated to the back
5.	At time 5, string is "aaba", as 1 letters of the string "aaab" is circularly rotated to the back
After some units of time, a string becomes equal to it’s original self.
Once a string becomes equal to itself, it’s letters start to rotate from the first letter again (process resets). So, if a string takes t time to get back to the original, at time t+1 one letter will be rotated and the string will be it’s original self at 2t time.
You have to find the minimum time, where maximum number of strings are equal to their original self.
As this time can be very large, give the answer modulo 109+7.

Note: Your solution will run on multiple test cases so do clear global variables after using them.

Input:

A: Array of strings.
Output:

Minimum time, where maximum number of strings are equal to their original self.
Constraints:

1 <= size(A) <= 10^5
1 <= size of each string in A <= 10^5
Each string consists of only characters 'a' and 'b'
Summation of length of all strings <= 10^7
Example:

Input

A: [a,ababa,aba]
Output

4

String 'a' is it's original self at time 1, 2, 3 and 4.
String 'ababa' is it's original self only at time 4. (ababa => babaa => baaba => babaa => ababa)
String 'aba' is it's original self at time 2 and 4. (aba => baa => aba)

Hence, 3 strings are their original self at time 4.
 */

package interviewbit;

import java.util.ArrayList;

public class Stringoholics {
	
	private final static long base = (long) (1e9 + 7);
    
    public int solve(ArrayList<String> A) {
        int[] primeCnt = new int[300000];
        for (String a : A) {
            long c = minCycle(a);
            if (c <= 1) continue;
            int d = 2;
            do {
                int cnt = 0;
                while (c % d == 0) {
                    c /= d;
                    ++cnt;
                }
                if (cnt > 0 && cnt > primeCnt[d]) primeCnt[d] = cnt;
                ++d;
            } while (c > 1);
        }
        long res = 1L;
        for (int i = 2; i < primeCnt.length; ++i) {
            int cnt = primeCnt[i];
            if (cnt <= 0) continue;
            for (int j = 0; j < cnt; ++j)
                res = (res * i) % base;
        }
        return (int) (res);
    }
    
    private int minCycle(String a) {
        int l = a.length();
        boolean[] ok = foundPos(a);
        for (int t = 1; t <= 2 * l; ++t) {
            int r = (int) ((t * (t + 1L) / 2L) % l);
            if (ok[r]) return t;
        }
        return -1; // impossible
    }
    
    boolean [] foundPos(String a) {
        int l = a.length();
        boolean [] res = new boolean[l];
        res[0] = true;
        long aHash = rhash(a);
        long bHash = aHash;
        long pow = twoPow(l);
        for (int r = 1; r < l; ++r) {
            bHash = uphash(bHash, a.charAt(r - 1), pow);
            if (aHash == bHash &&
                a.substring(0, r).equals(a.substring(l - r, l)) &&
                a.substring(r, l).equals(a.substring(0, l - r)))
                res[r] = true;
        }
        return res;
    }
    
    long uphash(long hash, char a, long pow) {
        hash -= (a * pow) % base;
        if (hash < 0) hash += base;
        hash += a;
        return hash % base;
    }
    
    long twoPow(int pow) {
        long r = 1L;
        while (pow-- > 0)
            r = (r * 2L) % base;
        return r;
    }
    
    long rhash(String a) {
        long r = 0L;
        for (char c : a.toCharArray()) {
            r = ((r * 2L) + c) % base;
        }
        return r;
    }

}

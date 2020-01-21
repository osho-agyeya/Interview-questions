//ddoe
/*
 * Largest Coprime Divisor
You are given two positive numbers A and B. You need to find the maximum valued integer X such that:

X divides A i.e. A % X = 0
X and B are co-prime i.e. gcd(X, B) = 1
For example,

A = 30
B = 12
We return
X = 5
 */
package interviewbit;

public class Largest_Coprime_Divisor {
	
	public int cpFact(int A, int B) {
        while (gcd(A,B) != 1) {
            A = A/gcd(A,B);
        }
        return A;
    }
    public int gcd(int A, int B) {
        if (B == 0) {
            return A;
        } else {
            return gcd(B, A%B);
        }
    }

}

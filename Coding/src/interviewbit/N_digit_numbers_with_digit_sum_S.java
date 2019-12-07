//done
/*
 * N digit numbers with digit sum S
Find out the number of N digit numbers, whose digits on being added equals to a given number S. Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.

Since the answer can be large, output answer modulo 1000000007

**

N = 2, S = 4
Valid numbers are {22, 31, 13, 40}
Hence output 4.
 */

package interviewbit;

public class N_digit_numbers_with_digit_sum_S {

	public int solve(int A, int B) {
		int[][] l = new int[A + 1][B + 1];
		for (int j = 1; j <= 9 && j <= B; j++) {
			l[1][j] = 1;
		}
		for (int i = 2; i <= A; i++) {
			for (int j = 1; j <= B; j++) {
				int x = j - 10;
				long val = (long) l[i][j - 1] + (long) l[i - 1][j];
				if (x > 0)
					val -= (long) l[i - 1][x];
				if (val < 0)
					val += 1000000007;
				l[i][j] = (int) (val % (long) 1000000007);
			}
		}
		return l[A][B];
	}
}

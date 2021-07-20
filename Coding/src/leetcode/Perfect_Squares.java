/* over, sqrt(n), 1
Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

 

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 

Constraints:

1 <= n <= 104
 */

package leetcode;

import java.util.Arrays;

public class Perfect_Squares {
	
	/*
	 * 
	 * Approach 5: Mathematics
Intuition

The problem can be solved with the mathematical theorems that have been proposed and proved over time. We will break down the problem into several cases in this section.

In 1770, Joseph Louis Lagrange proved a theorem, called Lagrange's four-square theorem, also known as Bachet's conjecture, which states that every natural number can be represented as the sum of four integer squares: p=a_{0}^{2}+a_{1}^{2}+a_{2}^{2}+a_{3}^{2}p=a 
0
2
​
 +a 
1
2
​
 +a 
2
2
​
 +a 
3
2
​
  where the four numbers a_{0},a_{1},a_{2},a_{3}a 
0
​
 ,a 
1
​
 ,a 
2
​
 ,a 
3
​
  are integers.

For example, 3, 31 can be represented as the sum of four squares as follows: 3=1^{2}+1^{2}+1^{2}+0^{2} \qquad 31=5^{2}+2^{2}+1^{2}+1^{2}3=1 
2
 +1 
2
 +1 
2
 +0 
2
 31=5 
2
 +2 
2
 +1 
2
 +1 
2
 

Case 1). The Lagrange's four-square theorem sets the upper bound for the results of the problem, i.e. if the number n cannot be decomposed into a fewer number of squares, at least it can be decomposed into the sum of 4 square numbers, i.e. \text{numSquares}(n) \le 4numSquares(n)≤4.

As one might notice in the above example, the number zero is also considered as a square number, so we can consider that the number 3 can either be decomposed into 3 or 4 square numbers.

However, Lagrange's four-square theorem does not tell us directly the least numbers of square to decompose a natural number.

Later, in 1797, Adrien-Marie Legendre completed the four-square theorem with his three-square theorem, by proving a particular condition that a positive integer can be expressed as the sum of three squares: n \ne 4^{k}(8m+7) \iff n = a_{0}^{2}+a_{1}^{2}+a_{2}^{2}n 

​
 =4 
k
 (8m+7)⟺n=a 
0
2
​
 +a 
1
2
​
 +a 
2
2
​
  where kk and mm are integers.

Case 2). Unlike the four-square theorem, Adrien-Marie Legendre's three-square theorem gives us a necessary and sufficient condition to check if the number can ONLY be decomposed into 4 squares, not fewer.

It might be tricky to see the conclusion that we made in the case (2) from the three-square theorem. Let us elaborate the deduction procedure a bit. First of all, the three-square theorem tells us that if the number n is of the form n = 4^{k}(8m+7)n=4 
k
 (8m+7), then the number n cannot be decomposed into the sum of 3 numbers of squares. Further, we can also assert that the number n cannot be decomposed into the sum of two squares, neither the number itself is a square. Because suppose the number n can be decomposed as n = a_{0}^{2}+a_{1}^{2}n=a 
0
2
​
 +a 
1
2
​
 , then by adding the square number zero into the expression, i.e. n = a_{0}^{2}+a_{1}^{2} + 0^2n=a 
0
2
​
 +a 
1
2
​
 +0 
2
 , we obtain the conclusion that the number n can be decomposed into 3 squares, which is contradicted to the three-square theorem. Therefore, together with the four-square theorem, we can assert that if the number does not meet the condition of the three-square theorem, it can ONLY be decomposed into the sum of 4 squares, not fewer.

If the number meets the condition of the three-square theorem, we know that if can be decomposed into 3 squares. But what we don't know is that whether the number can be decomposed into fewer squares, i.e. one or two squares. So before we attribute the number to the bottom case (three-square theorem), here are the two cases remained to check, namely:

Case 3.1). if the number is a square number itself, which is easy to check e.g. n == int(sqrt(n)) ^ 2.

Case 3.2). if the number can be decomposed into the sum of two squares. Unfortunately, there is no mathematical weapon that can help us to check this case in one shot. We need to resort to the enumeration approach.

Algorithm

One can literally follow the above cases to implement the solution.

First, we check if the number n is of the form n = 4^{k}(8m+7)n=4 
k
 (8m+7), if so we return 4 directly.
Otherwise, we further check if the number is of a square number itself or the number can be decomposed the sum of two squares.
In the bottom case, the number can be decomposed into the sum of 3 squares, though we can also consider it decomposable by 4 squares by adding zero according to the four-square theorem. But we are asked to find the least number of squares.
We give some sample implementations here. The solution is inspired from the posts of TCarmic and StefanPochmann in the Discussion forum.


Complexity

Time complexity: \mathcal{O}(\sqrt{n})O( 
n
​
 ). In the main loop, we check if the number can be decomposed into the sum of two squares, which takes \mathcal{O}(\sqrt{n})O( 
n
​
 ) iterations. In the rest of cases, we do the check in constant time.

Space complexity: \mathcal{O}(1)O(1). The algorithm consumes a constant space, regardless the size of the input number.
	 * 
	 */
	
	protected boolean isSquare(int n) {
	    int sq = (int) Math.sqrt(n);
	    return n == sq * sq;
	  }

	  public int numSquares(int n) {
	    // four-square and three-square theorems.
	    while (n % 4 == 0)
	      n /= 4;
	    if (n % 8 == 7)
	      return 4;

	    if (this.isSquare(n))
	      return 1;
	    // enumeration to check if the number can be decomposed into sum of two squares.
	    for (int i = 1; i * i <= n; ++i) {
	      if (this.isSquare(n - i * i))
	        return 2;
	    }
	    // bottom case of three-square theorem.
	    return 3;
	  }
	
	/*
	public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        return dp[n];
    }
    */

}

/*completedd
 * Assuming that there is akDigitNIts numbers on everykPower is the sum ofN, Then this number is the number of Armstrong.

To give you a positive integerN, Allow you to determine whether he is Armstrong number, it returnstrueNot returnfalse。

 

Example 1:

Input:153
Output:true
Example: 
 153 is a 3-digit, and 153 + 5 = 1 ^ 3 ^ 3 ^ 3 + 3.
Example 2:

Input:123
Output:false
Explanation:  
 123 is a 3-digit, and 123! = 1 + 2 ^ 3 ^ 3 ^ 3 + 3 = 36.
 

prompt:

1 <= N <= 10^8
 */

package leetcodePremium;

public class Armstrong_Number {

	 public boolean isArmstrong(int N) {
         int sum = 0;
         int tmp = N;
         int length = Integer.toString(N).length();
         while (tmp > 0){
             sum += power(tmp % 10, length);
             tmp /= 10;
         }
         return sum == N;
     }

     private int power(int a, int b){
         int res = 1;
         for (int i = 0; i < b; i++){
             res *= a;
         }
         return res;
     }
	
}

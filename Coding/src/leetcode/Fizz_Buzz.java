//completed

/*
 * 
Given an integer n, return a string array answer (1-indexed) where:

answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
answer[i] == "Fizz" if i is divisible by 3.
answer[i] == "Buzz" if i is divisible by 5.
answer[i] == i if non of the above conditions are true.
 

Example 1:

Input: n = 3
Output: ["1","2","Fizz"]
Example 2:

Input: n = 5
Output: ["1","2","Fizz","4","Buzz"]
Example 3:

Input: n = 15
Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 

Constraints:

1 <= n <= 104
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Fizz_Buzz {
	
	public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<String>();

   for (int num = 1; num <= n; num++) {

     boolean divisibleBy3 = (num % 3 == 0);
     boolean divisibleBy5 = (num % 5 == 0);

     String numAnsStr = "";

     if (divisibleBy3) {
       // Divides by 3, add Fizz
       numAnsStr += "Fizz";
     }

     if (divisibleBy5) {
       // Divides by 5, add Buzz
       numAnsStr += "Buzz";
     }

     if (numAnsStr.equals("")) {
       // Not divisible by 3 or 5, add the number
       numAnsStr += Integer.toString(num);
     }

     // Append the current answer str to the ans list
     ans.add(numAnsStr);
   }

   return ans;
   }

}

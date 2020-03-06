//done
/*
 * Sum Of Fibonacci Numbers
How many minimum numbers from fibonacci series are required such that sum of numbers should be equal to a given Number N?
Note : repetition of number is allowed.

Example:

N = 4
Fibonacci numbers : 1 1 2 3 5 .... so on
here 2 + 2 = 4 
so minimum numbers will be 2 
 */

package interviewbit;

import java.util.ArrayList;

public class Sum_Of_Fibonacci_Numbers {
	
	public int fibsum(int A) {
        ArrayList<Integer> fibs = new ArrayList<>();
        fibs.add(0);
        fibs.add(1);
        fibs.add(1);
        int lastVal = 1;
        while (lastVal < A){
            fibs.add(fibs.get(fibs.size()-1) +fibs.get(fibs.size()-2));
            lastVal = fibs.get(fibs.size()-1);
        }
        int count = 0;
        for (int i = fibs.size()-1; i >=0 ; i--) {
            while (A >= fibs.get(i)) {
                A-=fibs.get(i);
                count++;
                if(A == 0) {
                    return count;
                }
            }
            if(A == 0) {
                return count;
            }
        }
        return count;
    }

}

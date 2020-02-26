//ddone
package interviewbit;
/*
 * Triplets with Sum between given range
Given an array of real numbers greater than zero in form of strings.
Find if there exists a triplet (a,b,c) such that 1 < a+b+c < 2 .
Return 1 for true or 0 for false.

Example:

Given [0.6, 0.7, 0.8, 1.2, 0.4] ,

You should return 1

as

0.6+0.7+0.4=1.7

1<1.7<2

Hence, the output is 1.

O(n) solution is expected.

Note: You can assume the numbers in strings don’t overflow the primitive data type and there are no leading zeroes in numbers. Extra memory usage is allowed.
 */

import java.util.ArrayList;
import java.util.Collections;

public class Triplets_with_Sum_between_given_range {
public int solve(ArrayList<String> A) {
        
        ArrayList<Double> ar=new ArrayList<Double>();
        for(int i=0;i<A.size();i++)
            ar.add(Double.parseDouble(A.get(i)));
            
        int l=0,m=1,h=A.size()-1;
        Collections.sort(ar);
        while(l<h && m<h)
        {   Double sum=ar.get(l)+ar.get(m)+ar.get(h);
            if(sum>1.0 && sum<2.0)
            {
                return 1;
            }
            
            else if(sum>=2)
            {
                h--;
            }
            else
            {
                l++;
                m++;
            }
            
            
        }
        
        return 0;
        
        
        
        
        
        
    }
}

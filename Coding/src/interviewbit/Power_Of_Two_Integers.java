//done
/*
 * Power Of Two Integers
Asked in:  
Housing
Amazon
Given a positive integer which fits in a 32 bit signed integer, find if it can be expressed as A^P where P > 1 and A > 0. A and P both should be integers.

Example

Input : 4
Output : True  
as 2^2 = 4. 
 */

package interviewbit;

public class Power_Of_Two_Integers {
	
	public boolean isPower(int a) {
        if(a==1) return true;
    for (int i = 2; i*i <= a; i++) {
      int p = a;
      while(p%i == 0){
        p/=i;
      }
      if(p == 1) return true;
    }
    return false;
        
    }

}

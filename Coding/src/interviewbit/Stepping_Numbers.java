//completed
/*
 * Stepping Numbers
Asked in:  
Epic systems
Given N and M find all stepping numbers in range N to M

The stepping number:

A number is called as a stepping number if the adjacent digits have a difference of 1.
e.g 123 is stepping number, but 358 is not a stepping number

Example:

N = 10, M = 20
all stepping numbers are 10 , 12 
Return the numbers in sorted order.
 */

package interviewbit;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Stepping_Numbers {

	public ArrayList<Integer> stepnum(int A, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        if (A > B) return res;
        
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= 9; i++) q.add(i);
        
        if (A == 0) res.add(0);
        while (!q.isEmpty()) {
            int p = q.poll();
            if (p < B) {
                int last = p % 10;
                if (last > 0) q.add(p * 10 + last - 1);
                if (last < 9) q.add(p * 10 + last + 1);
            }
            if (p >= A && p <= B) res.add(p);
        }
        return res;
    }
	
}

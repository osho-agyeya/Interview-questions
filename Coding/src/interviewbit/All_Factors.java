//done
/*
 * Given a number N, find all factors of N.

Example:

N = 6 
factors = {1, 2, 3, 6}
 */
package interviewbit;

import java.util.ArrayList;
import java.util.LinkedList;

public class All_Factors {
public ArrayList<Integer> allFactors(int a) {
	    ArrayList<Integer> resh=new ArrayList<>();
	    LinkedList<Integer> rest=new LinkedList<>();
	    int f=1;
	    while (f<=Math.sqrt(a)) {
	        if (a % f == 0) {
	            resh.add(f);
	            if (a/f!=f) {
	                rest.addFirst(a/f);
	            }
	        }
	        f++;
	    }
	    resh.addAll(rest);
	    return resh;
	}
}

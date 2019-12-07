//doee

package ctci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Circus_Tower {
	
	public static int longestSeq(Person[] p) {
	    Arrays.sort(p, new Comparator<Person>() {
	        @Override
	        public int compare(Person p1, Person p2) {
	            if (p1.height > p2.height)
	                return 1;
	            else if (p1.height < p2.height)
	                return -1;
	            else {
	                if (p1.weight > p2.weight)
	                    return 1;
	                else if (p2.weight < p2.weight)
	                    return -1;
	            }
	            return 0;
	        }
	    });
	    int maxLen = 1;
	    int len = 1;
	    Person pre = p[0];
	    for (int i = 1; i < p.length; i++) {
	        Person cur = p[i];
	        if (onTop(pre, cur)) {
	            len++;
	        }
	        else {
	            len = 1;
	        }
	        maxLen = Math.max(maxLen, len);
	    }
	    return maxLen;
	}
	 
	private static boolean onTop(Person p1, Person p2) {//return true if person1 can be on top of person2
	    return (p1.height <= p2.height && p1.weight <= p2.weight);
	}  

}

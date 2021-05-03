//completed

/*
 * 
 * 
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
 */

package leetcodePremium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Moving_Average_from_Data_Stream {
	
	 double sum;
	    int size;
	    LinkedList<Integer> list;
	 
	    /** Initialize your data structure here. */
	    public Moving_Average_from_Data_Stream(int size) {
	        this.list = new LinkedList<>();
	        this.size = size;
	    }
	 
	    public double next(int val) {
	        sum += val;
	        list.offer(val);
	 
	        if(list.size()<=size){
	            return sum/list.size();
	        }
	 
	        sum -= list.poll();
	 
	        return sum/size;
	    }
}

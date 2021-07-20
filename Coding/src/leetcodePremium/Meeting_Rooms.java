//completedd

/*
 * 
 * 
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
For example,
Given [[0, 30],[5, 10],[15, 20]],
return false. 
 */

package leetcodePremium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Meeting_Rooms {
	
	public boolean canAttendMeetings(Interval[] intervals) {
	    Arrays.sort(intervals, new Comparator<Interval>(){
	        public int compare(Interval a, Interval b){
	            return a.start-b.start;
	        }
	    });
	 
	    for(int i=0; i<intervals.length-1; i++){
	        if(intervals[i].end>intervals[i+1].start){
	            return false;
	        }
	    }
	 
	    return true;
	}

}

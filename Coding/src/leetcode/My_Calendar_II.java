/* over, n2, n
 * 
 * 
 * You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a triple booking.

A triple booking happens when three events have some non-empty intersection (i.e., some moment is common to all the three events.).

The event can be represented as a pair of integers start and end that represents a booking on the half-open interval [start, end), the range of real numbers x such that start <= x < end.

Implement the MyCalendarTwo class:

MyCalendarTwo() Initializes the calendar object.
boolean book(int start, int end) Returns true if the event can be added to the calendar successfully without causing a triple booking. Otherwise, return false and do not add the event to the calendar.
 

Example 1:

Input
["MyCalendarTwo", "book", "book", "book", "book", "book", "book"]
[[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
Output
[null, true, true, true, false, true, true]

Explanation
MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
myCalendarTwo.book(10, 20); // return True, The event can be booked. 
myCalendarTwo.book(50, 60); // return True, The event can be booked. 
myCalendarTwo.book(10, 40); // return True, The event can be double booked. 
myCalendarTwo.book(5, 15);  // return False, The event ca not be booked, because it would result in a triple booking.
myCalendarTwo.book(5, 10); // return True, The event can be booked, as it does not use time 10 which is already double booked.
myCalendarTwo.book(25, 55); // return True, The event can be booked, as the time in [25, 40) will be double booked with the third event, the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
 

Constraints:

0 <= start < end <= 109
At most 1000 calls will be made to book. */
package leetcode;

public class My_Calendar_II {
	
	/*
	 * Approach #2: Boundary Count [Accepted]
Intuition and Algorithm

When booking a new event [start, end), count delta[start]++ and delta[end]--. When processing the values of delta in sorted order of their keys, the running sum active is the number of events open at that time. If the sum is 3 or more, that time is (at least) triple booked.

A Python implementation was not included for this approach because there is no analog to TreeMap available.

class MyCalendarTwo {
    TreeMap<Integer, Integer> delta;

    public MyCalendarTwo() {
        delta = new TreeMap();
    }

    public boolean book(int start, int end) {
        delta.put(start, delta.getOrDefault(start, 0) + 1);
        delta.put(end, delta.getOrDefault(end, 0) - 1);

        int active = 0;
        for (int d: delta.values()) {
            active += d;
            if (active >= 3) {
                delta.put(start, delta.get(start) - 1);
                delta.put(end, delta.get(end) + 1);
                if (delta.get(start) == 0)
                    delta.remove(start);
                return false;
            }
        }
        return true;
    }
}
Complexity Analysis

Time Complexity: O(N^2)O(N 
2
 ), where NN is the number of events booked. For each new event, we traverse delta in O(N)O(N) time.

Space Complexity: O(N)O(N), the size of delta.
	 * 
	 */

private TreeMap<Integer, Integer> map;    
    
    public My_Calendar_II() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            if(count > 2) {
                map.put(start, map.get(start) - 1);
                if(map.get(start) == 0) {
                    map.remove(start);
                }
                map.put(end, map.get(end) + 1);
                if(map.get(end) == 0) {
                    map.remove(end);
                }
                return false;
            }
        }
        return true;
    }

}

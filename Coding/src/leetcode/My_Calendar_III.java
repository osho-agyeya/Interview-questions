/* over, n2, n
 * 
 * 
 * A k-booking happens when k events have some non-empty intersection (i.e., there is some time that is common to all k events.)

You are given some events [start, end), after each given event, return an integer k representing the maximum k-booking between all the previous events.

Implement the MyCalendarThree class:

MyCalendarThree() Initializes the object.
int book(int start, int end) Returns an integer k representing the largest integer such that there exists a k-booking in the calendar.
 

Example 1:

Input
["MyCalendarThree", "book", "book", "book", "book", "book", "book"]
[[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
Output
[null, 1, 1, 2, 3, 3, 3]

Explanation
MyCalendarThree myCalendarThree = new MyCalendarThree();
myCalendarThree.book(10, 20); // return 1, The first event can be booked and is disjoint, so the maximum k-booking is a 1-booking.
myCalendarThree.book(50, 60); // return 1, The second event can be booked and is disjoint, so the maximum k-booking is a 1-booking.
myCalendarThree.book(10, 40); // return 2, The third event [10, 40) intersects the first event, and the maximum k-booking is a 2-booking.
myCalendarThree.book(5, 15); // return 3, The remaining events cause the maximum K-booking to be only a 3-booking.
myCalendarThree.book(5, 10); // return 3
myCalendarThree.book(25, 55); // return 3
 

Constraints:

0 <= start < end <= 109
At most 400 calls will be made to book.
 */
package leetcode;

public class My_Calendar_III {

	/*
	 * Approach #1: Boundary Count [Accepted]
Intuition and Algorithm

When booking a new event [start, end), count delta[start]++ and delta[end]--. When processing the values of delta in sorted order of their keys, the largest such value is the answer.

In Python, we sort the set each time instead, as there is no analog to TreeMap available.


Complexity Analysis

Time Complexity: O(N^2)O(N 
2
 ), where NN is the number of events booked. For each new event, we traverse delta in O(N)O(N) time. In Python, this is O(N^2 \log N)O(N 
2
 logN) owing to the extra sort step.

Space Complexity: O(N)O(N), the size of delta.
	 * 
	 */
	
	Map<Integer, Integer> map;
    public My_Calendar_III() {
        map = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);

        int activeEvents = 0, maxEvents = 0;
        for (int val : map.values()) {
            activeEvents += val;
            maxEvents = Math.max(maxEvents, activeEvents);
        }
        
        return maxEvents;
    }

}

/* over, 1, m
 * Design a logger system that receives a stream of messages along with their timestamps. Each unique message should only be printed at most every 10 seconds (i.e. a message printed at timestamp t will prevent other identical messages from being printed until timestamp t + 10).

All messages will come in chronological order. Several messages may arrive at the same timestamp.

Implement the Logger class:

Logger() Initializes the logger object.
bool shouldPrintMessage(int timestamp, string message) Returns true if the message should be printed in the given timestamp, otherwise returns false.
 

Example 1:

Input
["Logger", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage"]
[[], [1, "foo"], [2, "bar"], [3, "foo"], [8, "bar"], [10, "foo"], [11, "foo"]]
Output
[null, true, true, false, false, false, true]

Explanation
Logger logger = new Logger();
logger.shouldPrintMessage(1, "foo");  // return true, next allowed timestamp for "foo" is 1 + 10 = 11
logger.shouldPrintMessage(2, "bar");  // return true, next allowed timestamp for "bar" is 2 + 10 = 12
logger.shouldPrintMessage(3, "foo");  // 3 < 11, return false
logger.shouldPrintMessage(8, "bar");  // 8 < 12, return false
logger.shouldPrintMessage(10, "foo"); // 10 < 11, return false
logger.shouldPrintMessage(11, "foo"); // 11 >= 11, return true, next allowed timestamp for "foo" is
                                      // 11 + 10 = 21
 

Constraints:

0 <= timestamp <= 109
Every timestamp will be passed in non-decreasing order (chronological order).
1 <= message.length <= 30
At most 104 calls will be made to shouldPrintMessage.
 */

package leetcodePremium;

public class Logger_Rate_Limiter {
	
	
	/*
	 * 
	 * Approach 2: Hashtable / Dictionary
Intuition

One could combine the queue and set data structure into a hashtable or dictionary, which gives us the capacity of keeping all unique messages as of queue as well as the capacity to quickly evaluate the duplication of messages as of set.

The idea is that we keep a hashtable/dictionary with the message as key, and its timestamp as the value. The hashtable keeps all the unique messages along with the latest timestamp that the message was printed.

pic

As one can see from the above example, there is an entry in the hashtable with the message m2 and the timestamp 2. Then there comes another message m2 with the timestamp 15. Since the message was printed 13 seconds before (i.e. beyond the buffer window), it is therefore eligible to print again the message. As a result, the timestamp of the message m2 would be updated to 15.

Algorithm

We initialize a hashtable/dictionary to keep the messages along with the timestamp.

At the arrival of a new message, the message is eligible to be printed with either of the two conditions as follows:

case 1). we have never seen the message before.

case 2). we have seen the message before, and it was printed more than 10 seconds ago.

In both of the above cases, we would then update the entry that is associated with the message in the hashtable, with the latest timestamp.


Note: for clarity, we separate the two cases into two blocks. One could combine the two blocks together to have a more concise solution.

The main difference between this approach with hashtable and the previous approach with queue is that in previous approach we do proactive cleaning, i.e. at each invocation of function, we first remove those expired messages.

While in this approach, we keep all the messages even when they are expired. This characteristics might become problematic, since the usage of memory would keep on growing over the time. Sometimes it might be more desirable to have the garbage collection property of the previous approach.

Complexity Analysis

Time Complexity: \mathcal{O}(1)O(1). The lookup and update of the hashtable takes a constant time.

Space Complexity: \mathcal{O}(M)O(M) where MM is the size of all incoming messages. Over the time, the hashtable would have an entry for each unique message that has appeared.
	 * 
	 * 
	 */
	
	Map<String, Integer> map = new HashMap<>(); // msg : lst print timestamp
    int limiter = 10;
    /** Initialize your data structure here. */
    public Logger_Rate_Limiter() {

    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message)){
            map.put(message, timestamp);
            return true;
        }else{
            if(timestamp - map.get(message) >= limiter){
                map.put(message, timestamp);
                return true;
            }
        }

        return false;
    }
}

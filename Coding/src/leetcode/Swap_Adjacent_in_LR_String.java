/* over, m, m
 * 
 * In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of either replacing one occurrence of "XL" with "LX", or replacing one occurrence of "RX" with "XR". Given the starting string start and the ending string end, return True if and only if there exists a sequence of moves to transform one string to the other.

 

Example 1:

Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
Output: true
Explanation: We can transform start to end following these steps:
RXXLRXRXL ->
XRXLRXRXL ->
XRLXRXRXL ->
XRLXXRRXL ->
XRLXXRRLX
Example 2:

Input: start = "X", end = "L"
Output: false
Example 3:

Input: start = "LLR", end = "RRL"
Output: false
Example 4:

Input: start = "XL", end = "LX"
Output: true
Example 5:

Input: start = "XLLR", end = "LXLX"
Output: false
 

Constraints:

1 <= start.length <= 104
start.length == end.length
Both start and end will only consist of characters in 'L', 'R', and 'X'.
 * 
 */

package leetcode;

public class Swap_Adjacent_in_LR_String {
	
	/*
	 * The idea is simple. Just get the non-X characters and compare the positions of them.
	 */

	class Pair {
	    int i;
	    char c;
	    Pair(int i, char c) {
	        this.i = i;
	        this.c = c;
	    }
	}

	public boolean canTransform(String start, String end) {
	    List<Pair> startPairs = new ArrayList<>();
	    List<Pair> endPairs = new ArrayList<>();
	    for (int i = 0; i < Math.max(start.length(), end.length()); i++) {
	        if (i < start.length() && start.charAt(i) != 'X') {
	            startPairs.add(new Pair(i, start.charAt(i)));
	        }
	        if (i < end.length() && end.charAt(i) != 'X') {
	            endPairs.add(new Pair(i, end.charAt(i)));
	        }
	    }

	    if (startPairs.size() != endPairs.size()) return false;
	    for (int i = 0; i < startPairs.size(); i++) {
	        if (startPairs.get(i).c != endPairs.get(i).c) return false;
	        if (startPairs.get(i).c == 'L' && startPairs.get(i).i < endPairs.get(i).i) return false;
	        if (startPairs.get(i).c == 'R' && startPairs.get(i).i > endPairs.get(i).i) return false;
	    }

	    return true;
	}
	
}

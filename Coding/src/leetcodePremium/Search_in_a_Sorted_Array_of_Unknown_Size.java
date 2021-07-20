/*completedd
 * 
 * Given an integer array sorted in ascending order, write a function to searchtargetinnums. Iftargetexists, then return its index, otherwise return-1.However, the array size is unknown to you. You may only access the array using anArrayReader interface, where ArrayReader.get(k)returns the element of the array at indexk (0-indexed).
You may assume all integers in the array are less than 10000, and if you access the array out of bounds,ArrayReader.getwill return2147483647.
 */

package leetcodePremium;

public class Search_in_a_Sorted_Array_of_Unknown_Size {

    public int search(ArrayReader reader, int target) {
        int start = 0, end = Integer.MAX_VALUE;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target == reader.get(mid)) {
                return mid;
            } else if (target < reader.get(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (reader.get(start) == target) {
            return start;
        } else if (reader.get(end) == target) {
            return end;
        }
        return -1;
    }
	
}

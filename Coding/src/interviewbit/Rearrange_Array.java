//completed
/*
 * Rearrange Array
Asked in:  
Facebook
Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.

Example:

Input : [1, 0]
Return : [0, 1]
 Lets say N = size of the array. Then, following holds true :
All elements in the array are in the range [0, N-1]
N * N does not overflow for a signed integer
 */
package interviewbit;

import java.util.ArrayList;

public class Rearrange_Array {
	
	public void arrange(ArrayList<Integer> arr) {
        int n=arr.size();
        for (int i=0; i < n; i++)
        arr.set(i,arr.get(i)+(arr.get(arr.get(i))%n)*n);
    // Second Step: Divide all values by n
    for (int i=0; i<n; i++)
        arr.set(i,arr.get(i)/n);
    }

}

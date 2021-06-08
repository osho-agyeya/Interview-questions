/*completed
 * 
 * 
 * Given an integer array A of size N consisting of unique integers from 1 to N. You can swap any two integers atmost B times.

Return the largest lexicographical value array that can be created by executing atmost B swaps.



Problem Constraints
1 <= N <= 106

1 <= B <= 109



Input Format
First argument is an integer array A of size N.

Second argument is an integer B.



Output Format
Return an integer array denoting the largest lexicographical value array that can be created by executing atmost B swaps.



Example Input
Input 1:

 A = [1, 2, 3, 4]
 B = 1
Input 2:

 A = [3, 2, 1]
 B = 2


Example Output
Output 1:

 [4, 2, 3, 1]
Output 2:

 [3, 2, 1]


Example Explanation
Explanation 1:

 In one swap we can swap (1, 4) so that the array becomes : [4, 2, 3, 1].
Explanation 2:

 Array is already the largest lexicographical value array.
 */

package interviewbit;

public class Largest_Permutation {
	
	// Function to calculate largest
    // permutation after atmost K swaps
    static void KswapPermutation(
        int arr[], int n, int k)
    {
 
        // Auxiliary dictionary of storing
        // the position of elements
        int pos[] = new int[n + 1];
 
        for (int i = 0; i < n; ++i)
            pos[arr[i]] = i;
 
        for (int i = 0; i < n && k > 0; ++i) {
 
            // If element is already i'th
            // largest, then no need to swap
            if (arr[i] == n - i)
                continue;
 
            // Find position of i'th largest
            // value, n-i
            int temp = pos[n - i];
 
            // Swap the elements position
            pos[arr[i]] = pos[n - i];
            pos[n - i] = i;
 
            // Swap the ith largest value with the
            // current value at ith place
            int tmp1 = arr[temp];
            arr[temp] = arr[i];
            arr[i] = tmp1;
 
            // decrement number of swaps
            --k;
        }
    }
	
	

}

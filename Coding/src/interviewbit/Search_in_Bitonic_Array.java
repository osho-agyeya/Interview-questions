/*completed
 * Given a bitonic sequence A of N distinct elements, write a program to find a given element B in the bitonic sequence in O(logN) time.

NOTE:

A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.


Problem Constraints
3 <= N <= 105

1 <= A[i], B <= 108

Given array always contain a bitonic point.

Array A always contain distinct elements.



Input Format
First argument is an integer array A denoting the bitonic sequence.

Second argument is an integer B.



Output Format
Return a single integer denoting the position (0 index based) of the element B in the array A if B doesn't exist in A return -1.



Example Input
Input 1:

 A = [3, 9, 10, 20, 17, 5, 1]
 B = 20
Input 2:

 A = [5, 6, 7, 8, 9, 10, 3, 2, 1]
 B = 30


Example Output
Output 1:

 3
Output 2:

 -1


Example Explanation
Explanation 1:

 B = 20 present in A at index 3
Explanation 2:

 B = 30 is not present in A
 */
package interviewbit;

public class Search_in_Bitonic_Array {
	
	 public int solve(int[] A, int B) {
	        int n=A.length;
	        if(n==0)    return -1;
	        int l = 0;
	        int r = n - 1;
	        int index;
	        index = findBitonicPoint(A, n, l, r);
	 
	        int x = searchBitonic(A, n, B, index);
	        return x;
	        
	    }
	    
	    
	    //Function for binary search
	    // in ascending part
	    int ascendingBinarySearch(int arr[],
	                                     int low,
	                                     int high,
	                                     int key)
	    {
	        while (low <= high)
	        {
	            int mid = low + (high - low) / 2;
	            if (arr[mid] == key)
	            {
	                return mid;
	            }
	            if (arr[mid] > key)
	            {
	                high = mid - 1;
	            }
	            else
	            {
	                low = mid + 1;
	            }
	        }
	        return -1;
	    }
	 
	    // Function for binary search in
	    // descending part of array
	     int descendingBinarySearch(int arr[],
	                                      int low,
	                                      int high,
	                                      int key)
	    {
	        while (low <= high)
	        {
	            int mid = low + (high - low) / 2;
	            if (arr[mid] == key)
	            {
	                return mid;
	            }
	            if (arr[mid] < key)
	            {
	                high = mid - 1;
	            }
	            else
	            {
	                low = mid + 1;
	            }
	        }
	        return -1;
	    }
	 
	    // finding bitonic point
	     int findBitonicPoint(int arr[],
	                                 int n,
	                                 int l,
	                                int r)
	    {
	        int mid;
	        int bitonicPoint = 0;
	        mid = (r + l) / 2;
	        if (arr[mid] > arr[mid - 1]
	            && arr[mid] > arr[mid + 1])
	        {
	            return mid;
	        }
	        else {
	            if (arr[mid] > arr[mid - 1]
	                && arr[mid] < arr[mid + 1])
	            {
	                bitonicPoint =  findBitonicPoint(arr, n, mid, r);
	            }
	            else {
	                if (arr[mid] < arr[mid - 1]
	                    && arr[mid] > arr[mid + 1])
	                {
	                    bitonicPoint = findBitonicPoint(arr, n, l, mid);
	                }
	            }
	        }
	          return bitonicPoint;
	    }
	 
	    // Function to search key in bitonic array
	     int searchBitonic(int arr[], int n,
	                            int key, int index)
	    {
	        if (key > arr[index])
	        {
	            return -1;
	        }
	        else if (key == arr[index])
	        {
	            return index;
	        }
	        else {
	            int temp = ascendingBinarySearch(
	                arr, 0, index - 1, key);
	            if (temp != -1)
	            {
	                return temp;
	            }
	 
	            // Search in right of k
	            return descendingBinarySearch(arr, index + 1,
	                                          n - 1, key);
	        }
	    }

}

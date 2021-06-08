/*completedd
 * Given an integer array A of size N. You need to count the number of special elements in the given array.

A element is special if removal of that element make the array balanced.

Array will be balanced if sum of even index element equal to sum of odd index element.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 109



Input Format
First and only argument is an integer array A of size N.



Output Format
Return an integer denoting the count of special elements.



Example Input
Input 1:

 A = [2, 1, 6, 4]
Input 2:

 A = [5, 5, 2, 5, 8]


Example Output
Output 1:

 1
Output 2:

 2


Example Explanation
Explanation 1:

 After deleting 1 from array : {2,6,4}
    (2+4) = (6)
 Hence 1 is the only special element, so count is 1
Explanation 2:

 If we delete A[0] or A[1] , array will be balanced
    (5+5) = (2+8)
 So A[0] and A[1] are special elements, so count is 2.
 */

package interviewbit;

public class Balance_Array {
	
public int solve(int[] arr) {
        
        int n=arr.length;
         // If size of the array is 1
        if (n == 1)
        {
            return 1;
        }
     
        // If size of the array is 2
        if (n == 2)
            return 0;
     
        // Stores sum of even-indexed
        // elements of the given array
        int sumEven = 0;
     
        // Stores sum of odd-indexed
        // elements of the given array
        int sumOdd = 0;
     
        // Traverse the array
        for (int i = 0; i < n; i++)
        {
     
            // If i is an even number
            if (i % 2 == 0)
            {
     
                // Update sumEven
                sumEven += arr[i];
            }
     
            // If i is an odd number
            else
            {
     
                // Update sumOdd
                sumOdd += arr[i];
            }
        }
     
        // Stores sum of even-indexed
        // array elements till i-th index
        int currOdd = 0;
     
        // Stores sum of odd-indexed
        // array elements till i-th index
        int currEven = arr[0];
     
        // Stores count of indices whose
        // removal makes sum of odd and
        // even indexed elements equal
        int res = 0;
     
        // Stores sum of even-indexed elements
        // after removing the i-th element
        int newEvenSum = 0;
     
        // Stores sum of odd-indexed elements
        // after removing the i-th element
        int newOddSum = 0;
     
        // Traverse the array
        for (int i = 1; i < n - 1; i++)
        {
     
            // If i is an odd number
            if (i % 2 != 0)
            {
     
                // Update currOdd
                currOdd += arr[i];
     
                // Update newEvenSum
                newEvenSum = currEven + sumOdd
                             - currOdd;
     
                // Update newOddSum
                newOddSum = currOdd + sumEven
                            - currEven - arr[i];
            }
     
            // If i is an even number
            else
            {
     
                // Update currEven
                currEven += arr[i];
     
                // Update newOddSum
                newOddSum = currOdd + sumEven
                            - currEven;
     
                // Update newEvenSum
                newEvenSum = currEven + sumOdd
                             - currOdd - arr[i];
            }
     
            // If newEvenSum is equal to newOddSum
            if (newEvenSum == newOddSum)
            {
     
                // Increase the count
                res++;
            }
        }
     
        // If sum of even-indexed and odd-indexed
        // elements is equal by removing the last element
        if (sumOdd == sumEven - arr[0])
        {
     
            // Increase the count
            res++;
        }
     
        // If length of the array
        // is an odd number
        if (n % 2 == 1)
        {
     
            // If sum of even-indexed and odd-indexed
            // elements is equal by removing the last element
            if (sumOdd == sumEven - arr[n - 1])
            {
     
                // Increase the count
                res++;
            }
        }
     
        // If length of the array
        // is an even number
        else
        {
     
            // If sum of even-indexed and odd-indexed
            // elements is equal by removing the last element
            if (sumEven == sumOdd - arr[n - 1])
            {
     
                // Increase the count
                res++;
            }
        }
     
        return res;
    }

}

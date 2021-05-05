/*completed
 * Given a sorted array of integers nums and integer values a, b and c. Apply a quadratic function of the form f(x) = ax2 + bx + c to each element x in the array. 
The returned array must be in sorted order.
Expected time complexity: O(n)
Example:
nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,

Result: [3, 9, 15, 33]

nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5

Result: [-23, -5, 1, 7]
 */

package leetcodePremium;

public class Sort_Transformed_Array {

	static void sortArray(int arr[], int n, int A, int B, int C)
    {
       // Apply equation on all elements
        for (int i = 0; i < n; i++)
            arr[i] = A*arr[i]*arr[i] + B*arr[i] + C;
      
        // Find maximum element in resultant array
        int index=-1;
        int maximum = -999999;
        for (int i = 0; i< n; i++)
        {
            if (maximum < arr[i])
            {
                index = i;
                maximum = arr[i];
            }
        }
      
        // Use maximum element as a break point
        // and merge both subarrays usin simple
        // merge function of merge sort
        int i = 0, j = n-1;
        int[] new_arr = new int[n];
        int k = 0;
        while (i < index && j > index)
        {
            if (arr[i] < arr[j])
                new_arr[k++] = arr[i++];
            else
                new_arr[k++] = arr[j--];
        }
      
        // Merge remaining elements
        while (i < index)
            new_arr[k++] = arr[i++];
        while (j > index)
            new_arr[k++] = arr[j--];
      
        new_arr[n-1] = maximum;
      
        // Modify original array
        for (int p = 0; p < n ; p++)
            arr[p] = new_arr[p];
    }
}

//done
/*
 * Given an array of positive number, find maximum sum subsequence such that elements in this subsequence are not adjacent to each other.
 */
package tushar_roy;

public class Maximum_Sum_Subsequence_Non_Adjacent {
	
	public int maxSum(int arr[]) {
        int excl = 0;
        int incl = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int temp = incl;
            incl = Math.max(excl + arr[i], incl);
            excl = temp;
        }
        return incl;
    }


}

//ddoe
/*
 * INVERSIONS
Given an array A, count the number of inversions in the array.

Formally speaking, two elements A[i] and A[j] form an inversion if A[i] > A[j] and i < j

Example:

A : [2, 4, 1, 3, 5]
Output : 3
as the 3 inversions are (2, 1), (4, 1), (4, 3).
 */

package interviewbit;

public class INVERSIONS {
	
	 public int countInversions(int[] a) {
        int c=0;
        int l=a.length;
        for(int i=0;i<l-1;i++){
            for(int j=i+1;j<l;j++){
                if(a[i]>a[j]){
                    c++;
                }
            }
        }
        return c;
    }

}

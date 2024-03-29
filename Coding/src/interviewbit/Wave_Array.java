//completed
/*
 * Wave Array
Asked in:  
Google
Adobe
Amazon
Given an array of integers, sort the array into a wave like array and return it,
In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

Example

Given [1, 2, 3, 4]

One possible answer : [2, 1, 4, 3]
Another possible answer : [4, 1, 3, 2]
 NOTE : If there are multiple answers possible, return the one thats lexicographically smallest.
So, in example case, you will return [2, 1, 4, 3]
 */

package interviewbit;

import java.util.Arrays;

public class Wave_Array {
	
	 public int[] wave(int[] a) {
        Arrays.sort(a);
        for(int i=1;i<a.length;i+=2){
            int temp=a[i-1];
            a[i-1]=a[i];
            a[i]=temp;
        }
        return a;
    }

}

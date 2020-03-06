//done
/*
 * NEXTGREATER
Given an array, find the next greater element G[i] for every element A[i] in the array. The Next greater Element for an element A[i] is the first greater element on the right side of A[i] in array.
More formally,

G[i] for an element A[i] = an element A[j] such that 
    j is minimum possible AND 
    j > i AND
    A[j] > A[i]
Elements for which no greater element exist, consider next greater element as -1.

Example:

Input : A : [4, 5, 2, 10]
Output : [5, 10, 10, -1]

Example 2:

Input : A : [3, 2, 1]
Output : [-1, -1, -1]
 */

package interviewbit;

public class NEXTGREATER {
	
	×
class Solution:
	# @param A : list of integers
	# @return a list of integers
	def nextGreater(self, a):
	    n=len(a)
	    li=[]
	    for i in range(0,n):
	        res=False
	        ma=a[i]
	        for j in range(i+1,n):
	            if(a[j]>a[i]):
	                ma=a[j]
	                break
	        if(ma==a[i]):
	            li.append(-1)
	        else:
	            li.append(ma)
	    return li

}

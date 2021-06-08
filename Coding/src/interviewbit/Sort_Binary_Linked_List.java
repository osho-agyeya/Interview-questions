/*
 * completed
 * Given a Linked List A consisting of N nodes.

The Linked List is binary i.e data values in the linked list nodes consist of only 0's and 1's.

You need to sort the linked list and return the new linked list.

NOTE:

Try to do it in constant space.


Problem Constraints
1 <= N <= 105

A.val = 0 or A.val = 1



Input Format
First and only argument is the head pointer of the linkedlist A.



Output Format
Return the head pointer of the new sorted linked list.



Example Input
Input 1:

 1 -> 0 -> 0 -> 1
Input 2:

 0 -> 0 -> 1 -> 1 -> 0


Example Output
Output 1:

 0 -> 0 -> 1 -> 1
Output 2:

 0 -> 0 -> 0 -> 1 -> 1


Example Explanation
Explanation 1:

 The sorted linked list looks like:
  0 -> 0 -> 1 -> 1
Explanation 2:

 The sorted linked list looks like:
  0 -> 0 -> 0 -> 1 -> 1
 */

package interviewbit;

public class Sort_Binary_Linked_List {
	
	 public ListNode solve(ListNode A) {
	        if(A == null || A.next == null){
	            return A;
	        }
	        ListNode pointer = A;
	        int count = 0;
	        int len = 0;
	        while(pointer != null){
	            len = len + 1;                         // length of the linked list
	            if(pointer.val == 1){
	                count += 1;                       // number of nodes with value = 1
	            }
	            pointer = pointer.next;
	        }
	        ListNode temp = A;
	        int ctr = 0;
	        while(temp != null){
	            ctr += 1;
	            if(ctr <= len - count){                       // until ctr < length of LL - number of nodes wiht value = 1
	                temp.val = 0;
	            }
	            else{
	                temp.val = 1;
	            }
	            temp = temp.next;
	        }
	        return A;
	    }

}

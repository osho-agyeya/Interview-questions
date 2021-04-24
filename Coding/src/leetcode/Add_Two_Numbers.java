//completed


//t=max(l1,l2)
//s=max(l1,l2)

/*
 * 
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
 * 
 * 
 */

package leetcode;

import main_solution.ListNode;

public class Add_Two_Numbers {
	
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead= new ListNode(0); //using dummy head is good
        ListNode l1Travel=l1;
        ListNode l2Travel=l2;
        ListNode sumTravel=dummyHead;
        int carry=0,sum=0;
        while(l1Travel!=null || l2Travel!=null){
            sum=((l1Travel!=null)?l1Travel.val:0)+((l2Travel!=null)?l2Travel.val:0)+carry;
            carry=sum/10;
            sum%=10;
            sumTravel.next=new ListNode(sum);
            sumTravel=sumTravel.next;
            l1Travel=(l1Travel!=null)?l1Travel.next:l1Travel;
            l2Travel=(l2Travel!=null)?l2Travel.next:l2Travel;
        }
        
        sumTravel.next=(carry!=0)?(new ListNode(carry)):sumTravel.next;
        
                
        return dummyHead.next;
        
    }

}
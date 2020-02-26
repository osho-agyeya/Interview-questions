//ddone


//t=max(l1,l2)
//s=max(l1,l2)

/*
 * 
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
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
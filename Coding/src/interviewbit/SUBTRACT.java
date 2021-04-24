//completed
/*
 * SUBTRACT
Given a singly linked list, modify the value of first half nodes such that :

1st node’s new value = the last node’s value - first node’s current value
2nd node’s new value = the second last node’s value - 2nd node’s current value,
and so on …

 NOTE :
If the length L of linked list is odd, then the first half implies at first floor(L/2) nodes. So, if L = 5, the first half refers to first 2 nodes.
If the length L of linked list is even, then the first half implies at first L/2 nodes. So, if L = 4, the first half refers to first 2 nodes.
Example :

Given linked list 1 -> 2 -> 3 -> 4 -> 5,

You should return 4 -> 2 -> 3 -> 4 -> 5
as

for first node, 5 - 1 = 4
for second node, 4 - 2 = 2
Try to solve the problem using constant extra space.
 */

package interviewbit;

import java.util.ArrayDeque;

import main_solution.ListNode;

public class SUBTRACT {
	
	 public ListNode subtract(ListNode root) {
	        if(root==null)  return null;
	        ArrayDeque<ListNode> d=new ArrayDeque<>();
	        ListNode temp=root;
	        while(temp!=null){
	            d.addLast(temp);
	            temp=temp.next;
	        }
	        int len=d.size();
	        int n=(int)Math.floor(len/2);
	        for(int i=1;i<=n;i++){
	            ListNode l=d.pollFirst();
	            ListNode r=d.pollLast();
	            l.val=r.val-l.val;
	        }
	        return root;
	        
	    }

}

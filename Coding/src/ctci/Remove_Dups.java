//ddoe

package ctci;

import java.util.HashSet;
import java.util.Set;

import main_solution.ListNode;

public class Remove_Dups {

	public ListNode deleteDuplicates(ListNode head) {
	    Set<Integer> set = new HashSet<>();
	    ListNode pre = null;
	    ListNode fakeHead = head;
	    while(fakeHead != null){
	        if(!set.add(fakeHead.val)){
	            pre.next = fakeHead.next;
	        } else{
	            pre = fakeHead;
	        }
	        fakeHead = fakeHead.next;
	    }
	    return head;
	}
	
	
}

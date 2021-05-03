/*completed
 * Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.
You may assume the integer do not contain any leading zero, except the number 0 itself.
The digits are stored such that the most significant digit is at the head of the list.
Example:
Input:
1->2->3

Output:
1->2->4s
 */

package leetcodePremium;

public class Plus_One_Linked_List {

	public ListNode plusOne(ListNode head) {
		ListNode h2 = reverse(head);
		ListNode p=h2;
		while(p!=null){
			if(p.val+1<=9){
				p.val=p.val+1;
				break;
			}else{
				p.val=0;
				if(p.next==null){
					p.next = new ListNode(1);
					break;
				}
				p=p.next;
			}
		}
		return reverse(h2);
	}
	public ListNode reverse(ListNode head){
		if(head==null||head.next==null)
			return head;
		ListNode p1=head;
		ListNode p2=p1.next;
		while(p2!=null){
			ListNode t = p2.next;
			p2.next=p1;
			p1=p2;
			p2=t;
		}
		head.next=null;
		return p1;
	}

}

/*completedd
 * 
 * 
 * Given a node from a cyclic linked list which is sorted in ascending order, write a function to insert a value into the list such that it remains a cyclic sorted list. The given node can be a reference to_any_single node in the list, and may not be necessarily the smallest value in the cyclic list.

If there are multiple suitable places for insertion, you may choose any place to insert the new value. After the insertion, the cyclic list should remain sorted.

If the list is empty (i.e., given node isnull), you should create a new single cyclic list and return the reference to that single node. Otherwise, you should return the original given node.

The following example may help you understand the problem better:


In the figure above, there is a cyclic sorted list of three elements. You are given a reference to the node with value 3, and we need to insert 2 into the list.



The new node should insert between node 1 and node 3. After the insertion, the list should look like this, and we should still return node 3.

Thoughts:

No head:
prev.val <= val <= cur.val
prev.val > cur.val and (val < cur.val or prev.val < cur): cur is either the min or the max with not all nodes with the same value
val != every nodes's value in a cyclic linked list where every node has the same value
 */

package leetcodePremium;

public class Insert_into_a_Sorted_Circular_Linked_List {
	
	public Node insert(Node head, int insertVal) {
        Node res = new Node(insertVal);
        if(head == null){
            res.next = res;
            return res;
        }

        Node cur = head;
        while(cur.next != head
              && !((cur.val <= insertVal && insertVal <= cur.next.val)
                   || (cur.val > cur.next.val && (cur.next.val > insertVal || cur.val < insertVal)))){
            cur = cur.next;
        }

        res.next = cur.next;
        cur.next = res;
        return head;
    }

}

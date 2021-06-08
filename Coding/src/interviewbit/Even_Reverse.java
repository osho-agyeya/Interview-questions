/*completed
 * Given a linked list A , reverse the order of all nodes at even positions.



Problem Constraints
1 <= Size of linked list <= 100000



Input Format
First and only argument is the head of the Linked-List A.



Output Format
Return the head of the new linked list.



Example Input
Input 1:

A = 1 -> 2 -> 3 -> 4
Input 2:

A = 1 -> 2 -> 3


Example Output
Output 1:

 1 -> 4 -> 3 -> 2
Output 2:

 1 -> 2 -> 3


Example Explanation
Explanation 1:

Nodes are positions 2 and 4 have been swapped.
Explanation 2:

No swapping neccassary here.
 */
package interviewbit;

public class Even_Reverse {
	
    public ListNode solve(ListNode A) {
        ListNode temp = A;
       Stack<Integer> s = new Stack<Integer>();
       while(temp != null){
           s.push(temp.val);
           temp = temp.next;
       }
       temp = A;
       int size = s.size();
       if(size % 2 == 0) {
           while(temp != null && s.size() > 0) {
               int value = s.pop();
               temp = temp.next;
               temp.val = value;
               temp = temp.next;
               s.pop();
           }
       } else {
           s.pop();
           while(temp != null && s.size() > 0) {
               int value = s.pop();
               temp = temp.next;
               temp.val = value;
               temp = temp.next;
               s.pop();
           }
       }
       return A;
   }

}

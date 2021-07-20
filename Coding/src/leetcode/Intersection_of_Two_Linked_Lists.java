/* over, n+m, 1
 * 
Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

For example, the following two linked lists begin to intersect at node c1:


It is guaranteed that there are no cycles anywhere in the entire linked structure.

Note that the linked lists must retain their original structure after the function returns.

 

Example 1:


Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Intersected at '8'
Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
Example 2:


Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Intersected at '2'
Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
Example 3:


Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: No intersection
Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.
 

Constraints:

The number of nodes of listA is in the m.
The number of nodes of listB is in the n.
0 <= m, n <= 3 * 104
1 <= Node.val <= 105
0 <= skipA <= m
0 <= skipB <= n
intersectVal is 0 if listA and listB do not intersect.
intersectVal == listA[skipA + 1] == listB[skipB + 1] if listA and listB intersect.
 

Follow up: Could you write a solution that runs in O(n) time and use only O(1) memory?
 */

package leetcode;

import main_solution.ListNode;

public class Intersection_of_Two_Linked_Lists {
	
	/*
	 * 
	 * Approach 3: Two Pointers
Intuition

Interview Tip: Approach 3 is essentially a "medium" solution to an "easy" problem. Note that approach 2 is probably sufficient for an interview if you are fairly new to programming (for example, you're applying for an internship during your early years of college). If you're more experienced, it might also be sufficient, but your safest bet would be to also know Approach 3, and to be able to apply the intuition behind it to similar problems. While it might initially look scary, you'll be fine with it once you have a think about it and try and draw a few examples.

We know that we've now fully optimized the time complexity: it's impossible to do better than O(N + M)O(N+M) as, in the worst case, we'll need to look at every node at least once. But, is there a way we can get the space complexity down to O(1)O(1) while maintaining that awesome O(N + M)O(N+M) time complexity that we just achieved? It turns out that there is!

Observe that while list A and list B could be different lengths, that the shared "tail" following the intersection has to be the same length.

Imagine that we have two linked lists, A and B, and we know that their lengths are NN and MM respectively (these can be calculated with O(1)O(1) space and in time proportional to the length of the list). We'll imagine that N = 5N=5 and M = 8M=8.

Two linked lists with question marks on their nodes. The first is 5 nodes long, and the second is 8 nodes long.

Because the "tails" must be the same length, we can conclude that if there is an intersection, then the intersection node will be one of these 5 possibilities.

The two linked lists from above with arrows showing how the last 5 nodes of each list could be a match.

So, to check for each of these pairs, we would start by setting a pointer at the start of the shorter list, and a pointer at the first possible matching node of the longer list. The position of this node is simply the difference between the two lengths, that is, |M - N|∣M−N∣.

The two linked lists from above with a p1 pointer at the head of the first, and a p2 pointer at the 4th node of the second.

Then, we just need to step the two pointers through the list, each time checking whether or not the nodes are the same.

In code, we could write this algorithm with 4 loops, one after the other, each doing the following:

Calculate NN; the length of list A.
Calculate MM; the length of list B.
Set the start pointer for the longer list.
Step the pointers through the list together.
While this would have a time complexity of O(N + M)O(N+M) and a space complexity of O(1)O(1) and would be fine for an interview, we can still simplify the code a bit! As some quick reassurance, most people will struggle to come up with this next part by themselves. It takes practice and seeing lots of linked list and other math problems.

If we say that cc is the shared part, aa is exclusive part of list A and bb is exclusive part of list B, then we can have one pointer that goes over a + c + b and the other that goes over b + c + a. Have a look at the diagram below, and this should be fairly intuitive.

Diagram showing that one pointer could go over a + c + b while the other goes over b + c + a, and then both will end up on the intersection node.

This is the above algorithm in disguise - one pointer is essentially measuring the length of the longer list, and the other is measuring the length of the shorter list, and then placing the start pointer for the longer list. Then both are stepping through the list together. By seeing the solution in this way though, we can now implement it as a single loop.

Algorithm

Set pointer pA to point at headA.
Set pointer pB to point at headB.
While pA and pB are not pointing at the same node:
If pA is pointing to a null, set pA to point to headB.
Else, set pA to point at pA.next.
If pB is pointing to a null, set pB to point to headA.
Else, set pB to point at pB.next.
return the value pointed to by pA (or by pB; they're the same now).
Implementation


Complexity Analysis

Let NN be the length of list A and MM be the length of list B.

Time complexity : O(N + M)O(N+M).

In the worst case, each list is traversed twice giving 2 \cdot M + 2 \cdot N2⋅M+2⋅N, which is equivalent to O(N + M)O(N+M). This is because the pointers firstly go down each list so that they can be "lined up" and then in the second iteration, the intersection node is searched for.

An interesting observation you might have made is that when the lists are of the same length, this algorithm only traverses each list once. This is because the pointers are already "lined up" from the start, so the additional pass is unnecessary.

Space complexity : O(1)O(1).

We aren't allocating any additional data structures, so the amount of extra space used does not grow with the size of the input. For this reason, Approach 3 is better than Approach 2.
	 * 
	 */
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
    if(headA == null || headB == null) return null;
    
    ListNode a = headA;
    ListNode b = headB;
    
    //if a & b have different len, then we will stop the loop after second iteration
    while( a != b){
    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
        a = a == null? headB : a.next;
        b = b == null? headA : b.next;    
    }
    
    return a;
    }

}

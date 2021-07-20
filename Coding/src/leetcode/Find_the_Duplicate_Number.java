/* over, n, 1
 * 
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

 

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [1,1]
Output: 1
Example 4:

Input: nums = [1,1,2]
Output: 1
 

Constraints:

2 <= n <= 3 * 104
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
 

Follow up:

How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem without modifying the array nums?
Can you solve the problem using only constant, O(1) extra space?
Can you solve the problem with runtime complexity less than O(n2)?
 */
package leetcode;

public class Find_the_Duplicate_Number {
	
	/*
	 * Approach 3: Floyd's Tortoise and Hare (Cycle Detection)
Intuition

The idea is to reduce the problem to Linked List Cycle II:

Given a linked list, return the node where the cycle begins.

First of all, where does the cycle come from? Let's use the function f(x) = nums[x] to construct the sequence: x, nums[x], nums[nums[x]], nums[nums[nums[x]]], ....

Each new element in the sequence is an element in nums at the index of the previous element.

If one starts from x = nums[0], such a sequence will produce a linked list with a cycle.

The cycle appears because nums contains duplicates. The duplicate node is a cycle entrance.

Here is how it works:

pic

The example above is simple because the loop is small. Here is a more interesting example (special thanks to @sushant_chaudhari)

pic

Now the problem is to find the entrance of the cycle.

Algorithm

Floyd's algorithm consists of two phases and uses two pointers, usually called tortoise and hare.

In phase 1, hare = nums[nums[hare]] is twice as fast as tortoise = nums[tortoise]. Since the hare goes fast, it would be the first one who enters the cycle and starts to run around the cycle. At some point, the tortoise enters the cycle as well, and since it's moving slower the hare catches the tortoise up at some intersection point. Now phase 1 is over, and the tortoise has lost.

Note that the intersection point is not the cycle entrance in the general case.

pic

To compute the intersection point, let's note that the hare has traversed twice as many nodes as the tortoise, i.e. 2d(\text{tortoise}) = d(\text{hare})2d(tortoise)=d(hare), that means

2(F + a) = F + nC + a2(F+a)=F+nC+a, where nn is some integer.

Hence the coordinate of the intersection point is F + a = nCF+a=nC.

In phase 2, we give the tortoise a second chance by slowing down the hare, so that it now moves with the speed of tortoise: tortoise = nums[tortoise], hare = nums[hare]. The tortoise is back at the starting position, and the hare starts from the intersection point.

pic

Let's show that this time they meet at the cycle entrance after FF steps.

The tortoise started from zero, so its position after FF steps is FF.

The hare started at the intersection point F + a = nCF+a=nC, so its position after F steps is nC + FnC+F, that is the same point as FF.

So the tortoise and the (slowed down) hare will meet at the entrance of the cycle.

Implementation

Current
1 / 10

Complexity Analysis

Time complexity : \mathcal{O}(n)O(n)

For detailed analysis, refer to Linked List Cycle II.

Space complexity : \mathcal{O}(1)O(1)

For detailed analysis, refer to Linked List Cycle II.
	 * 
	 * 
	 */
	
    public int findDuplicate(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }

}

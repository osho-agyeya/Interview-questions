/* over, n2, n
 * 
 * We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
Example 4:

Input: asteroids = [-2,-1,1,2]
Output: [-2,-1,1,2]
Explanation: The -2 and -1 are moving left, while the 1 and 2 are moving right. Asteroids moving the same direction never meet, so no asteroids will meet each other.
 

Constraints:

2 <= asteroids.length <= 104
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0
 * 
 */

package leetcode;

public class Asteroid_Collision {
	
	/*
	 * Approach #1: Stack [Accepted]
Intuition

A row of asteroids is stable if no further collisions will occur. After adding a new asteroid to the right, some more collisions may happen before it becomes stable again, and all of those collisions (if they happen) must occur right to left. This is the perfect situation for using a stack.

Algorithm

Say we have our answer as a stack with rightmost asteroid top, and a new asteroid comes in. If new is moving right (new > 0), or if top is moving left (top < 0), no collision occurs.

Otherwise, if abs(new) < abs(top), then the new asteroid will blow up; if abs(new) == abs(top) then both asteroids will blow up; and if abs(new) > abs(top), then the top asteroid will blow up (and possibly more asteroids will, so we should continue checking.)


Complexity Analysis

Time Complexity: O(N)O(N), where NN is the number of asteroids. Our stack pushes and pops each asteroid at most once.

Space Complexity: O(N)O(N). We use a stack to keep track of the intermediate results. In the worst case, the states do not evolve at the end, i.e. we need O(N)O(N) space where NN is the number of input asteroids.
	 * 
	 */
	
	public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null) {
            return null;
        } else if (asteroids.length <= 1) {
            return asteroids;
        }
        Stack<Integer> stack = new Stack<>();
        for (int cur : asteroids) {
            if (cur > 0) { // previous one does not matter, no collision forever
                stack.push(cur);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && -cur > stack.peek()) { // destroy the previous positive one(s) 
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(cur);
                } else if (stack.peek() == -cur) {
                    stack.pop();
                }
            }
        }
        return stack.stream().mapToInt(i->i).toArray();
    }
	

}

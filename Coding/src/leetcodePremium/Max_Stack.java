/*completed
 * 
 * Design a max stack that supports push, pop, top, peekMax and popMax.

push(x) -- Push element x onto stack.
pop() -- Remove the element on top of the stack and return it.
top() -- Get the element on the top.
peekMax() -- Retrieve the maximum element in the stack.
popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
Example 1:
MaxStack stack = new MaxStack();
stack.push(5); 
stack.push(1);
stack.push(5);
stack.top(); -> 5
stack.popMax(); -> 5
stack.top(); -> 1
stack.peekMax(); -> 5
stack.pop(); -> 1
stack.top(); -> 5
Note:
-1e7 <= x <= 1e7
Number of operations won't exceed 10000.
The last four operations won't be called when stack is empty.
 * 
 */

package leetcodePremium;

public class Max_Stack {
	
	 Stack<Integer> data = new Stack<Integer>();
	    Stack<Integer> max = new Stack<Integer>();
	    /** initialize your data structure here. */
	    public Max_Stack() {

	    }
	    //O(1);
	    public void push(int x) {
	        data.push(x);
	        if (max.isEmpty()) {
	            max.push(x);
	        }
	        else {
	            max.push(Math.max(x, max.peek()));
	        }
	    }
	    //O(1);
	    public int pop() {
	        max.pop();
	        return data.pop();
	    }
	    //O(1);
	    public int top() {
	        return data.peek();
	    }
	    //O(1);
	    public int peekMax() {
	        return max.peek();
	    }
	    //O(n);
	    public int popMax() {
	        int res = max.peek();
	        Stack<Integer> tmp = new Stack<Integer>();
	        while (data.peek() != res) {
	            tmp.push(data.pop());
	            max.pop();
	        }
	        data.pop();
	        max.pop();
	        while (!tmp.isEmpty()) {
	            push(tmp.pop());
	        }
	        return res;
	    }

}

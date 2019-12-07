//doe

/*
 * 
 * 
 * Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Example:

MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);  
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false
Notes:

You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 * 
 * 
 */
package leetcode;

import java.util.Stack;

public class Implement_Queue_using_Stacks {
	
	 private final Stack<Integer> inputbuf;
	    private final Stack<Integer> output;
	    
	    /** Initialize your data structure here. */
	    public Implement_Queue_using_Stacks() {
	        inputbuf = new Stack<Integer>();
	        output = new Stack<Integer>();
	    }
	    
	    /** Push element x to the back of queue. */
	    public void push(int x) {
	        inputbuf.push(x);
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public int pop() {
	        peek();
	        return output.pop();
	    }
	    
	    /** Get the front element. */
	    public int peek() {
	        if (output.empty()) {
	            while (!inputbuf.empty()) {
	                output.push(inputbuf.pop());
	            }
	        }
	        return output.peek();
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
	        return inputbuf.empty() && output.empty();
	    }

}

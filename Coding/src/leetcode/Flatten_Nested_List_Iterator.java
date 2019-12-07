//doe

/*
 * 
 * Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:

Input: [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,1,2,1,1].
Example 2:

Input: [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,4,6].
 * 
 */
package leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Flatten_Nested_List_Iterator implements Iterator<Integer> {

    private Queue<Integer> queue;

    public Flatten_Nested_List_Iterator(List<NestedInteger> nestedList) {

        queue = new LinkedList<>();
        init(nestedList);
    }

    private void init(List<NestedInteger> nestedList) {
        if (nestedList.isEmpty())
            return;

        for (NestedInteger nst : nestedList) {

            if (!nst.isInteger()) {
                init(nst.getList());

            } else
                queue.offer(nst.getInteger());
        }
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

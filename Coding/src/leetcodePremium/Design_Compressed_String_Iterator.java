/*completedd
 * Design and implement a data structure for a compressed string iterator. It should support the following operations: next and hasNext.

The given compressed string will be in the form of each letter followed by a positive integer representing the number of this letter existing in the original uncompressed string.

next() - if the original string still has uncompressed characters, return the next letter; Otherwise return a white space.
hasNext() - Judge whether there is any letter needs to be uncompressed.

Note:
Please remember to RESET your class variables declared in StringIterator, as static/class variables are persisted across multiple test cases. Please see here for more details.

Example:

StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");

iterator.next(); // return 'L'
iterator.next(); // return 'e'
iterator.next(); // return 'e'
iterator.next(); // return 't'
iterator.next(); // return 'C'
iterator.next(); // return 'o'
iterator.next(); // return 'd'
iterator.hasNext(); // return true
iterator.next(); // return 'e'
iterator.hasNext(); // return false
iterator.next(); // return ' '
 */

package leetcodePremium;

public class Design_Compressed_String_Iterator {
	
	  private LinkedList<Character> q1;
	    private LinkedList<Integer> q2;

	    public StringIterator(String compressedString) {
	        q1 = new LinkedList<>();
	        q2 = new LinkedList<>();

	        int num = 0;
	        for(int i = 0; i < compressedString.length(); i++) {
	            char c = compressedString.charAt(i);

	            if(i == compressedString.length() - 1) {
	                num = num * 10 + (c - '0');
	                q2.offerLast(num);
	                break;
	            }
	            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
	                q1.offerLast(c);

	                if(i > 0)
	                    q2.offerLast(num);
	                num = 0;
	            } else if(c >= '0' && c <= '9') {
	                num = num * 10 + (c - '0');
	            }
	        }
	    }

	    public char next() {
	        if(!hasNext())
	            return ' ';

	        char c = q1.peekFirst();
	        int count = q2.poll();

	        if(count == 1) {
	            q1.pollFirst();
	        } else {
	            q2.offerFirst(count - 1);
	        }

	        return c;
	    }

	    public boolean hasNext() {
	        return q1.size() > 0;
	    }

}

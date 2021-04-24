//completed
/*
 * Smallest Multiple With 0 and 1
Asked in:  
Amazon
You are given an integer N. You have to find smallest multiple of N which consists of digits 0 and 1 only. Since this multiple could be large, return it in form of a string.

Note:

Returned string should not contain leading zeroes.
For example,

For N = 55, 110 is smallest multiple consisting of digits 0 and 1.
For N = 2, 10 is the answer.
 */

package interviewbit;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Smallest_Multiple_With_0_and_1 {

	public static class Node {
        String value;
        int modN = -1;
        
        public Node(String x, int y) {
            value  = x;
            modN = y;
        }
    }
    
    public String multiple(int N) {

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(new Node("1", 1 % N));
        
        boolean[] visited = new boolean[N];
        visited[1%N] = true;
        
        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            
            if (node.modN == 0) {
                return node.value;
            }
            
            int s1 = (node.modN * 10) % N;
            int s2 = (node.modN * 10 + 1) % N;
                
            if (!visited[s1]) {
                queue.addLast(new Node(node.value + "0", s1));
                visited[s1] = true;
            }
            
            if (!visited[s2]) {
                queue.addLast(new Node(node.value + "1", s2));
                visited[s2] = true;
            }
            
            
        }
        
        return "";
    }
	
}

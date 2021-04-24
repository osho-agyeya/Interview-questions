//completed
/*
 * N max pair combinations
Asked in:  
Liv.ai
Problem Setter: dhruvi Problem Tester: ganeshk2
Given two arrays A & B of size N each.
Find the maximum N elements from the sum combinations (Ai + Bj) formed from elements in array A and B.

For example if A = [1,2], B = [3,4], then possible pair sums can be 1+3 = 4 , 1+4=5 , 2+3=5 , 2+4=6
and maximum 2 elements are 6, 5

Example:

N = 4
a[]={1,4,2,3}
b[]={2,5,1,6}

Maximum 4 elements of combinations sum are
10   (4+6), 
9    (3+6),
9    (4+5),
8    (2+6)
 */
package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class N_max_pair_combinations {
	
	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Collections.sort(A,Collections.reverseOrder());
        Collections.sort(B,Collections.reverseOrder());
        int n=A.size();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i:A){
            for(int j:B){
                int s = i+j;
                if (pq.size()<n){
                    pq.add(s);
                } else {
                    if (s>pq.peek()){
                        pq.poll();
                        pq.add(s);
                    }else{
                        break;
                    }
                }
            }
        }
        
        ArrayList<Integer> ret = new ArrayList<>(pq);
        Collections.sort(ret,Collections.reverseOrder());
        return ret;
    }
}



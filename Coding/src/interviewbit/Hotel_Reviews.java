//done
/*
 * Hotel Reviews
Asked in:  
Booking.com
Problem Setter: ishubansal Problem Tester: raghav_aggiwal
Given a set of reviews provided by the customers for different hotels and a string containing “Good Words”, you need to sort the reviews in descending order according to their “Goodness Value” (Higher goodness value first). We define the “Goodness Value” of a string as the number of “Good Words” in that string.

Note: Sorting should be stable. If review i and review j have the same “Goodness Value” then their original order would be preserved.

 You are expected to use Trie in an Interview for such problems 

Constraints:

1.   1 <= No.of reviews <= 200
2.   1 <= No. of words in a review <= 1000
3.   1 <= Length of an individual review <= 10,000
4.   1 <= Number of Good Words <= 10,000
5.   1 <= Length of an individual Good Word <= 4
6.   All the alphabets are lower case (a - z)
Input:

S : A string S containing "Good Words" separated by  "_" character. (See example below)
R : A vector of strings containing Hotel Reviews. Review strings are also separated by "_" character.
Output:

A vector V of integer which contain the original indexes of the reviews in the sorted order of reviews. 

V[i] = k  means the review R[k] comes at i-th position in the sorted order. (See example below)
In simple words, V[i]=Original index of the review which comes at i-th position in the sorted order. (Indexing is 0 based)
Example:

Input: 
S = "cool_ice_wifi"
R = ["water_is_cool", "cold_ice_drink", "cool_wifi_speed"]

Output:
ans = [2, 0, 1]
Here, sorted reviews are ["cool_wifi_speed", "water_is_cool", "cold_ice_dr
 */

package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

class Node{
    int match;
    int index;
    
    public Node(int m1,int i1){
        match = m1;
        index=i1;
    }
}

class NodeComparator implements Comparator<Node>{
    public int compare(Node n1, Node n2){
        if(n1.match==n2.match){return n1.index - n2.index;}
        return n2.match-n1.match;
    }
}

public class Hotel_Reviews {
    public ArrayList<Integer> solve(String s, ArrayList<String> arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(arr.size()==0) return ans;
        
        String[] str = s.split("_");
        HashSet<String> set = new HashSet<>(Arrays.asList(str));
        int count=0;
        ArrayList<Node> node = new ArrayList<>();
        
        for(int i=0;i<arr.size();i++){
            count=0;
        String[] temp = arr.get(i).split("_");
        for(String s1 : temp){count += set.contains(s1) ? 1 : 0;}
        node.add(new Node(count,i));
       // System.out.println(count);
        }
        
        Collections.sort(node,new NodeComparator());
        
        for(Node n : node){
            ans.add(n.index);
        }
        return ans;
    }
}
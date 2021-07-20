/* over, n, n
 * 
 * 
There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

 

Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
 

Constraints:

n == ratings.length
1 <= n <= 2 * 104
0 <= ratings[i] <= 2 * 104sss
 *
 *
 */


package leetcode;

import java.util.Arrays;

public class Candy {
	
	/*
	 * Approach 3: Using one array
Algorithm

In the previous approach, we used two arrays to keep track of the left neighbor and the right neighbor relation individually and later on combined these two. Instead of this, we can make use of a single array candies to keep the count of the number of candies to be allocated to the current student. In order to do so, firstly we assign 1 candy to each student. Then, we traverse the array from left-to-right and distribute the candies following only the left neighbor relation i.e. whenever the current element's ratings is larger than the left neighbor and has less than or equal candies than its left neighbor, we update the current element's candies in the candies array as candies[i] = candies[i-1] + 1. While updating we need not compare candies[i] and candies[i - 1], since candies[i] <= candies[i - 1] before updating. After this, we traverse the array from right-to-left. Now, we need to update the i'th element's candies in order to satisfy both the left neighbor and the right neighbor relation. Now, during the backward traversal, if ratings[i] > ratings[i + 1], considering only the right neighbor criteria, we could've updated candies[i] as candies[i] = candies[i + 1] + 1. But, this time we need to update candies[i] only if candies[i] <= candies[i + 1]. This happens because this time we've already altered the candies array during the forward traversal and thus candies[i] isn't necessarily less than or equal to candies[i + 1]. Thus, if ratings[i] > ratings[i + 1], we can update candies[i] as candies[i] = max(candies[i], candies[i + 1] + 1), which makes candies[i] satisfy both the left neighbor and the right neighbor criteria.

Again, we need to sum up all the elements of the candies array to obtain the required result.

\text{minimum\_candies} = \sum_{i=0}^{n-1} candies[i], \\ \text{where } n = \text{length of the ratings array.}minimum_candies=∑ 
i=0
n−1
​
 candies[i],
where n=length of the ratings array.


Complexity Analysis

Time complexity : O(n)O(n). The array candies of size nn is traversed thrice.

Space complexity : O(n)O(n). An array candies of size nn is used.


	 * 
	 * 
	 */
	
	public int candy(int[] ratings) {
    int candies[] = new int[ratings.length];        
    Arrays.fill(candies, 1);// Give each child 1 candy 
    	
    for (int i = 1; i < candies.length; i++){// Scan from left to right, to make sure right higher rated child gets 1 more candy than left lower rated child
        if (ratings[i] > ratings[i - 1]) candies[i] = (candies[i - 1] + 1);
    }
     
    for (int i = candies.length - 2; i >= 0; i--) {// Scan from right to left, to make sure left higher rated child gets 1 more candy than right lower rated child
	    if (ratings[i] > ratings[i + 1]) candies[i] = Math.max(candies[i], (candies[i + 1] + 1));
    }
    
    int sum = 0;        
    for (int candy : candies)  
    	sum += candy;        
    return sum;
}

}

//completed
/*
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given an integer array nums, return the sum of Hamming distances between all the pairs of the integers in nums.

 

Example 1:

Input: nums = [4,14,2]
Output: 6
Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case).
The answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
Example 2:

Input: nums = [4,14,4]
Output: 4
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 109
 * 
 */
package leetcode;

public class Total_Hamming_Distance {
	
    public int totalHammingDistance(int[] nums) {
int total = 0, n = nums.length;
for (int j=0;j<32;j++) {
    int bitCount = 0;
    for (int i=0;i<n;i++) 
        bitCount += (nums[i] >> j) & 1;
    total += bitCount*(n - bitCount);
}
return total;
}

}

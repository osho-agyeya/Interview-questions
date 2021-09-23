/* over, n lnw, 1 where n=no. of piles and W is max size of pile
 * 
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

 

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23
 

Constraints:

1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109
 * 
 */


package leetcode;

public class Koko_Eating_Bananas {
	
	/*
	 * Each hour, Koko chooses some pile of bananas, and eats K bananas from that pile.

There is a limited value range of K: [lo, hi].
There is a K' value, such that K(for any K >= K') can enable her to eat all the bananas within H hours: [K', hi].
We are asked to find K'.

Given a linear searching space [lo, hi], [mi, hi] (lo <= mi) satisfy a property, we can use Binary Searc to get mi.

Initially, we know that K belongs to [1, the largest element in piles[]]. And we follow the pattern of lower-bound Binary Search except that if (K == target) is replaced with if (canEatAll(piles, K, H)).
	 * 
	 */
	
	 public int minEatingSpeed(int[] piles, int H) {
	        int lo = 1, hi = getMaxPile(piles);
	        
	        // Binary search to find the smallest valid K.
	        while (lo <= hi) {
	            int K = lo + ((hi - lo) >> 1);
	            if (canEatAll(piles, K, H)) {
	                hi = K - 1;
	            } else {
	                lo = K + 1;
	            }
	        }
	        
	        return lo;
	    }
	    
	    private boolean canEatAll(int[] piles, int K, int H) {
	        int countHour = 0; // Hours take to eat all bananas at speed K.
	        
	        for (int pile : piles) {
	            countHour += pile / K;
	            if (pile % K != 0)
	                countHour++;
	        }
	        return countHour <= H;
	    }
	    
	    private int getMaxPile(int[] piles) {
	        int maxPile = Integer.MIN_VALUE;
	        for (int pile : piles) {
	            maxPile = Math.max(pile, maxPile);
	        }
	        return maxPile;
	    }

}

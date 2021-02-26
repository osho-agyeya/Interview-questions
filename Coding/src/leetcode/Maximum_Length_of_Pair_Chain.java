package leetcode;

public class Maximum_Length_of_Pair_Chain {
	
	public int findLongestChain(int[][] pairs) {
	     Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
	        int cur = Integer.MIN_VALUE, ans = 0;
	        for (int[] pair: pairs) if (cur < pair[0]) {
	            cur = pair[1];
	            ans++;
	        }
	        return ans;   
	    }

}

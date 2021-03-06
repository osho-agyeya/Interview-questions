//not done

package ctci;

public class The_Masseuse {

	public static int maxMinutes(int[] massages) {
		  int oneAway = 0;
		  int twoAway = 0;
		  for (int i = massages.length - 1; i >= 0; i--) {
		    int bestWith = massages[i] + twoAway;
		    int bestWithout = oneAway;
		    int current = Math.max(bestWith, bestWithout);
		    twoAway = oneAway;
		    oneAway = current;
		  }
		  return oneAway;
		}

		public static int maxMinutes(int[] massages) {
		  /* Allocating two extra slots in the array so we don't have to do bounds
		     * checking on lines 7 and 8. */  
		  int[] memo = new int[massages.length + 2];
		  memo[massages.length] = 0;
		  memo[massages.length + 1] = 0;
		  for (int i = massages.length - 1; i >= 0; i--) {
		    int bestWith = massages[i] + memo[i + 2];
		    int bestWithout = memo[i + 1];
		    memo[i] = Math.max(bestWith, bestWithout);
		  }
		  return memo[0];
		}


		public static int maxMinutes(int[] massages) {
		  int[] memo = new int[massages.length];
		  return maxMinutes(massages, 0, memo);
		}

		public static int maxMinutes(int[] massages, int index, int[] memo) {
		  if (index >= massages.length) {
		    return 0;
		  }
		  if (memo[index] == 0) {
		    int bestWith = massages[index] + maxMinutes(massages, index + 2, memo);
		    int bestWithout = maxMinutes(massages, index + 1, memo);
		    memo[index] = Math.max(bestWith, bestWithout);
		  }
		  
		  return memo[index];
		} 


		public static int maxMinutes(int[] massages, int index) {
		  if (index >= massages.length) { // Out of bounds
		    return 0;
		  }
		  
		  /* Best with this reservation. */
		  int bestWith = massages[index] + maxMinutes(massages, index + 2);
		  
		  /* Best without this reservation. */
		  int bestWithout = maxMinutes(massages, index + 1);
		  
		  /* Return best of this subarray, starting from index. */
		  return Math.max(bestWith, bestWithout);
		}


	
}

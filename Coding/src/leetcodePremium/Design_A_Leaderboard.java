/* completedd
 * Design a Leaderboard class, which has 3 functions:

addScore(playerId, score): Update the leaderboard by adding score to the given player's score. If there is no player with such id in the leaderboard, add him to the leaderboard with the given score.
top(K): Return the score sum of the top K players.
reset(playerId): Reset the score of the player with the given id to 0. It is guaranteed that the player was added to the leaderboard before calling this function.
Initially, the leaderboard is empty.

 

Example 1:

Input: 
["Leaderboard","addScore","addScore","addScore","addScore","addScore","top","reset","reset","addScore","top"]
[[],[1,73],[2,56],[3,39],[4,51],[5,4],[1],[1],[2],[2,51],[3]]
Output: 
[null,null,null,null,null,null,73,null,null,null,141]

Explanation: 
Leaderboard leaderboard = new Leaderboard ();
leaderboard.addScore(1,73);   // leaderboard = [[1,73]];
leaderboard.addScore(2,56);   // leaderboard = [[1,73],[2,56]];
leaderboard.addScore(3,39);   // leaderboard = [[1,73],[2,56],[3,39]];
leaderboard.addScore(4,51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
leaderboard.addScore(5,4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
leaderboard.top(1);           // returns 73;
leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
leaderboard.addScore(2,51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
leaderboard.top(3);           // returns 141 = 51 + 51 + 39;
 

Constraints:

1 <= playerId, K <= 10000
It's guaranteed that K is less than or equal to the current number of players.
1 <= score <= 100
There will be at most 1000 function calls.
 */

package leetcodePremium;

public class Design_A_Leaderboard {
	
	 List<Integer> playerIDs;
	    List<Integer> scores;
	    int size;

	    public Leaderboard() {
	        playerIDs = new ArrayList<Integer>();
	        scores = new ArrayList<Integer>();
	        size = 0;
	    }
	    
	    public void addScore(int playerId, int score) {
	        if (size == 0) {
	            playerIDs.add(playerId);
	            scores.add(score);
	        } else {
	            int idIndex = playerIDs.indexOf(playerId);
	            if (idIndex >= 0) {
	                int newScore = scores.get(idIndex) + score;
	                playerIDs.remove(idIndex);
	                scores.remove(idIndex);
	                int index = binarySearch(scores, newScore);
	                if (index < 0)
	                    index = -index - 1;
	                playerIDs.add(index, playerId);
	                scores.add(index, newScore);
	            } else {
	                int index = binarySearch(scores, score);
	                if (index < 0)
	                    index = -index - 1;
	                playerIDs.add(index, playerId);
	                scores.add(index, score);
	            }
	        }
	        size++;
	    }
	    
	    public int top(int K) {
	        K = Math.min(K, size);
	        int sum = 0;
	        for (int i = 0; i < K; i++)
	            sum += scores.get(i);
	        return sum;
	    }
	    
	    public void reset(int playerId) {
	        int index = playerIDs.indexOf(playerId);
	        playerIDs.remove(index);
	        scores.remove(index);
	        size--;
	    }

	    public int binarySearch(List<Integer> list, int key) {
	        int size = list.size();
	        int low = 0, high = size - 1;
	        while (low <= high) {
	            int mid = (high - low) / 2 + low;
	            int num = list.get(mid);
	            if (num == key)
	                return mid;
	            else if (num > key)
	                low = mid + 1;
	            else
	                high = mid - 1;
	        }
	        return -low - 1;
	    }

}

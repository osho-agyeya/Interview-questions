//ddone
/*
 * Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on. Each time a player picks a number, that number will not be available for the next player. This continues until all the scores have been chosen. The player with the maximum score wins.

Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.

Example 1:
Input: [1, 5, 2]
Output: False
Explanation: Initially, player 1 can choose between 1 and 2. 
If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2). 
So, final score of player 1 is 1 + 2 = 3, and player 2 is 5. 
Hence, player 1 will never be the winner and you need to return False.
Example 2:
Input: [1, 5, 233, 7]
Output: True
Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233.
Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.
Note:
1 <= length of the array <= 20.
Any scores in the given array are non-negative integers and will not exceed 10,000,000.
If the scores of both players are equal, then player 1 is still the winner.
 */

package leetcode;

public class Predict_the_Winner {
	

    static class Pair{
        int first=0, second=0;
    }
    
    public boolean PredictTheWinner(int[] pots) {
        
         Pair[][] moves = new Pair[pots.length][pots.length];
        
        for(int i=0; i < moves.length; i++){
            for(int j=0; j < moves[i].length; j++){
                moves[i][j] = new Pair();
            }
        }
        
        for(int i=0; i < pots.length; i++){
            moves[i][i].first = pots[i];
        }
        
        for(int l = 2; l <= pots.length; l++){
            for(int i=0; i <= pots.length - l; i++){
                int j = i + l -1;
                if(pots[i] + moves[i+1][j].second > moves[i][j-1].second + pots[j]){
                    moves[i][j].first = pots[i] + moves[i+1][j].second;
                    moves[i][j].second = moves[i+1][j].first;
                }else{
                    moves[i][j].first = pots[j] + moves[i][j-1].second;
                    moves[i][j].second = moves[i][j-1].first;
                }
            }
        }
        
        return moves[0][moves.length-1].first>=moves[0][moves.length-1].second;
        
    }

}

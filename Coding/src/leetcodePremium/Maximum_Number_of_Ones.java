/*completedd
 * 
 * Consider a matrix M with dimensions width * height, such that every cell has value 0 or 1, and any square sub-matrix of M of size sideLength * sideLength has at most maxOnes ones.

Return the maximum possible number of ones that the matrix M can have.

 

Example 1:

Input: width = 3, height = 3, sideLength = 2, maxOnes = 1
Output: 4
Explanation:
In a 3*3 matrix, no 2*2 sub-matrix can have more than 1 one.
The best solution that has 4 ones is:
[1,0,1]
[0,0,0]
[1,0,1]
Example 2:

Input: width = 3, height = 3, sideLength = 2, maxOnes = 2
Output: 6
Explanation:
[1,0,1]
[1,0,1]
[1,0,1]
 

Constraints:

1 <= width, height <= 100
1 <= sideLength <= width, height
0 <= maxOnes <= sideLength * sideLength
 * 
 */


package leetcodePremium;

public class Maximum_Number_of_Ones {
	
	public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        int[][] counts = new int[sideLength][sideLength];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++)
                counts[i % sideLength][j % sideLength]++;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++)
                priorityQueue.offer(counts[i][j]);
        }
        int maxTotalOnes = 0;
        for (int i = 0; i < maxOnes; i++)
            maxTotalOnes += priorityQueue.poll();
        return maxTotalOnes;
    }

}

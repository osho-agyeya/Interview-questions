//ddoe
package ctci;

import java.util.ArrayList;

public class Pond_Sizes {
	
	public static ArrayList<Integer> computePondSizes(int[][] land) {
		ArrayList<Integer> pondSizes = new ArrayList<Integer>();
		for (int r = 0; r < land.length; r++) {
			for (int c = 0; c < land[r].length; c++) {
				if (land[r][c] == 0) {
					int size = computeSize(land, r, c);					
					pondSizes.add(size);
				}
			}
		}
		return pondSizes;
	}
	
	public static int computeSize(int[][] land, int row, int col) {
		/* If out of bounds or already visited. */
		if (row < 0 || col < 0 || row >= land.length || col >= land[row].length || land[row][col] != 0) {
			return 0;
		}
		int size = 1;
		land[row][col] = -1;
		for (int dr = -1; dr <= 1; dr++) {
			for (int dc = -1; dc <= 1; dc++) {
				size += computeSize(land, row + dr, col + dc);
			}
		}
		return size;
	}	

}

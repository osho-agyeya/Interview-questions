//doe
/*
 * Given a matrix of 0s and Xs. Find largest subsquare matrix in this matrix such that sides of that square matrix are entirely made of Xs.
 */

package tushar_roy;

public class Maximum_Subsquare_With_Sides_as_X {

	 static int getMin(int x, int y) 
	    { return (x < y) ? x : y; } 
	      
	    // Returns size of maximum 
	    // size subsquare matrix 
	    // surrounded by 'X' 
	    static int findSubSquare(int mat[][],int N) 
	    { 
	    int max = 0; // Initialize result 
	  
	    // Initialize the left-top  
	    // value in hor[][] and ver[][] 
	    int hor[][] = new int[N][N]; 
	    int ver[][] = new int[N][N]; 
	    hor[0][0] = ver[0][0] = 'X'; 
	  
	    // Fill values in  
	    // hor[][] and ver[][] 
	    for (int i = 0; i < N; i++) 
	    { 
	        for (int j = 0; j < N; j++) 
	        { 
	            if (mat[i][j] == 'O') 
	                ver[i][j] = hor[i][j] = 0; 
	            else
	            { 
	                hor[i][j] = (j == 0) ? 1 :  
	                hor[i][j - 1] + 1; 
	                ver[i][j] = (i == 0) ? 1 :  
	                ver[i - 1][j] + 1; 
	            } 
	        } 
	    } 
	  
	    // Start from the rightmost- 
	    // bottommost corner element  
	    // and find the largest  
	    // subsquare with the help  
	    // of hor[][] and ver[][] 
	    for (int i = N - 1; i >= 1; i--) 
	    { 
	        for (int j = N - 1; j >= 1; j--) 
	        { 
	            // Find smaller of values in  
	            // hor[][] and ver[][] A Square  
	            // can only be made by taking  
	            // smaller value 
	            int small = getMin(hor[i][j],  
	                               ver[i][j]); 
	  
	            // At this point, we are sure  
	            // that there is a right vertical 
	            // line and bottom horizontal  
	            // line of length at least 'small'. 
	  
	            // We found a bigger square  
	            // if following conditions 
	            // are met: 
	            // 1)If side of square 
	            //   is greater than max. 
	            // 2)There is a left vertical 
	            //   line of length >= 'small' 
	            // 3)There is a top horizontal 
	            //   line of length >= 'small' 
	            while (small > max) 
	            { 
	                if (ver[i][j - small + 1] >= small && 
	                    hor[i - small + 1][j] >= small) 
	                { 
	                    max = small; 
	                } 
	                small--; 
	            } 
	        } 
	    } 
	    return max; 
	    }	
	
}

//completed
/*
 * Matrix Chain Multiplication
Given an array of integers A representing chain of 2-D matices such that the dimensions of ith matrix is
A[i-1] x A[i].

Find the most efficient way to multiply these matrices together. The problem is not actually to perform the multiplications,
but merely to decide in which order to perform the multiplications.

Return the minimum number of multiplications needed to multiply the chain.



Input Format

The only argument given is the integer array A.
Output Format

Return the minimum number of multiplications needed to multiply the chain.
Constraints

1 <= length of the array <= 1000
1 <= A[i] <= 100
For Example

Input 1:
    A = [40, 20, 30, 10, 30]
Output 1:
    26000
    Explanation 1:
        Dimensions of A1 = 40 x 20
        Dimensions of A2 = 20 x 30
        Dimensions of A3 = 30 x 10
        Dimensions of A4 = 10 x 30
        First, multiply A2 and A3 ,cost = 20*30*10 = 6000
        Second, multilpy A1 and (Matrix obtained after multilying A2 and A3) =  40 * 20 * 10 = 8000
        Third, multiply (Matrix obtained after multiplying A1, A2 and A3) and A4 =  40 * 10 * 30 = 12000
        Total Cost = 12000 + 8000 + 6000 =26000

Input 2:
    A = [10, 20, 30] 
Output 2:
    6000
 */

package interviewbit;

public class Matrix_Chain_Multiplication {
	
	 public int solve(int[] arr) {
		 int temp[][] = new int[arr.length-1][arr.length-1];
	        int q = 0;
	        for(int l=2; l < arr.length; l++){
	            for(int i=0,j=i+l-1; j <arr.length-1; i++,j++){
	                temp[i][j] = Integer.MAX_VALUE;
	                for(int k=0; k < l-1; k++){
	                	System.out.println(l+","+i+","+j+","+k);
	                    q = temp[i][i+k] + temp[i+k+1][j] + arr[i]*arr[i+k+1]*arr[j+1];
	                    if(q < temp[i][j]){
	                        temp[i][j] = q;
	                    }
	                }
	            }
	        }
	        return temp[0][arr.length-2];
	    }
	 
	 
	 public static void main(String[] args) {
		System.out.println(new Matrix_Chain_Multiplication().solve(new int[]{2, 3, 6, 4, 5}));
	}

}

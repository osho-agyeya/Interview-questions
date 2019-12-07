//done
/*
 * Black Shapes
Asked in:  
Amazon
Given N x M character matrix A of O's and X's, where O = white, X = black.

Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)



Input Format:

    The First and only argument is a N x M character matrix.
Output Format:

    Return a single integer denoting number of black shapes.
Constraints:

    1 <= N,M <= 1000
    A[i][j] = 'X' or 'O'
Example:

Input 1:
    A = [ OOOXOOO
          OOXXOXO
          OXOOOXO  ]
Output 1:
    3
Explanation:
    3 shapes are  :
    (i)    X
         X X
    (ii)
          X
    (iii)
          X
          X
Note: we are looking for connected shapes here.

XXX
XXX
XXX
is just one single connected black shape.
 */
package interviewbit;

public class Black_Shapes {

	public int black(String[] a) {
        int c=0;
        int rl=a.length;
        int cl=a[0].length();
        for(int i=0;i<rl;i++){
            for(int j=0;j<cl;j++){
                if(dfs(a,i,j,rl,cl)>0)
                    c++;
            }
        }
        return c;
        
    }
    
    public int dfs(String a[],int r,int c,int rl,int cl){
        if(r>=rl || r<0 || c>=cl || c<0 || a[r].charAt(c)=='O')    return 0;
        //a[r]=a[r].replace("X","O");
        a[r]=a[r].substring(0,c)+"O"+a[r].substring(c+1,cl);
        return 1+dfs(a,r+1,c,rl,cl)+dfs(a,r-1,c,rl,cl)+dfs(a,r,c-1,rl,cl)+dfs(a,r,c+1,rl,cl);
    }
	
}

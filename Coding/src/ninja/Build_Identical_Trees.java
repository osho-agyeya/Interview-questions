package ninja;

import main_solution.TreeNode;

public class Build_Identical_Trees {
public int cntMatrix(TreeNode A, TreeNode B) {
        
        if(A!=null && B!=null) {
        	int left=cntMatrix(A.left, B.left);
        	if(left==-1)	return -1;
        	int right=cntMatrix(A.right, B.right);
        	if(right==-1)	return -1;
        	return left+right;
        }
        if(A!=null)
        	return -1;
        if (B!=null)
			return 1+cntMatrix(A, B.left)+cntMatrix(A, B.right);
		return 0;
    }

}

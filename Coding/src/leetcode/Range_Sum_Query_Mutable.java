//done
/*
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.

Example:

Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:

The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.
 */

package leetcode;

public class Range_Sum_Query_Mutable {
	class SegmentTreeNode {
        int start, end;
        SegmentTreeNode left, right;
        int sum;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }
      
    SegmentTreeNode root = null;
   
    public Range_Sum_Query_Mutable(int[] nums) {
        root = buildTree(nums, 0, nums.length-1);
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else {
            SegmentTreeNode ret = new SegmentTreeNode(start, end);
            if (start == end) {
                ret.sum = nums[start];
            } else {
                int mid = start  + (end - start) / 2;             
                ret.left = buildTree(nums, start, mid);
                ret.right = buildTree(nums, mid + 1, end);
                ret.sum = ret.left.sum + ret.right.sum;
            }         
            return ret;
        }
    }
   
    void update(int i, int val) {
        update(root, i, val);
    }
   
    void update(SegmentTreeNode root, int pos, int val) {
        if (root.start == root.end) {
           root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (pos <= mid) {
                 update(root.left, pos, val);
            } else {
                 update(root.right, pos, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
    
    public int sumRange(SegmentTreeNode root, int start, int end) {
        if (root.end == end && root.start == start) {
            return root.sum;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (end <= mid) {
                return sumRange(root.left, start, end);
            } else if (start >= mid+1) {
                return sumRange(root.right, start, end);
            }  else {    
                return sumRange(root.right, mid+1, end) + sumRange(root.left, start, mid);
            }
        }
    }
    
    
    /*public static void main(String[] args) {
    	for(int i=23;i<=100;) {
    		System.out.print(i+"*****"+Integer.toBinaryString(i));
    		i+=(i&-i);
    		System.out.println("\t"+i+"*****"+Integer.toBinaryString(i));
    	}
		//System.out.println(Integer.toBinaryString(8));
		//System.out.println(Integer.toBinaryString(-8));
		 	}
		 */
    
}
    
    /*
     * segment tree using only array
     * 
     * 
     * public class NumArray {
    int[] tree;
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[n << 1];
        buildTree(nums);
    }

    private void buildTree(int[] nums) {
        for (int i = n; i < n << 1; i++) {
            tree[i] = nums[i - n];
        }

        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[i << 1] + tree[i << 1 | 1];
        }
    }

    void update(int i, int val) {
        for (tree[i += n] = val; i > 0; i >>= 1) {
            tree[i >> 1] = tree[i] + tree[i ^ 1];
        }
    }

    public int sumRange(int i, int j) {
        int ret = 0;
        for (i += n, j += n; i <= j; i >>= 1, j >>= 1) {
            if ((i & 1) == 1) ret += tree[i++];
            if ((j & 1) == 0) ret += tree[j--];
        }
        return ret;
    }
}
     * 
     * 
     * 
     * 
     * 
     * 
     */
    
    /*
     * binary indexed tree(fenwick tree)
     * 
     * 
     * int[] nums;
	int[] BIT;
	int n;

	public NumArray(int[] nums) {
		this.nums = nums;

		n = nums.length;
		BIT = new int[n + 1];
		for (int i = 0; i < n; i++)
			init(i, nums[i]);
	}

	public void init(int i, int val) {
		i++;
		while (i <= n) {
			BIT[i] += val;
			i += (i & -i);
		}
	}

	void update(int i, int val) {
		int diff = val - nums[i];
		nums[i] = val;
		init(i, diff);
	}

	public int getSum(int i) {
		int sum = 0;
		i++;
		while (i > 0) {
			sum += BIT[i];
			i -= (i & -i);
		}
		return sum;
	}

	public int sumRange(int i, int j) {
		return getSum(j) - getSum(i - 1);
	}
}
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * Range sum query using SQRT decomposition
     * 
     * private int[] b;
private int len;
private int[] nums;

public NumArray(int[] nums) {
    this.nums = nums;
    double l = Math.sqrt(nums.length);
    len = (int) Math.ceil(nums.length/l);
    b = new int [len];
    for (int i = 0; i < nums.length; i++)
        b[i / len] += nums[i];
}

public int sumRange(int i, int j) {
    int sum = 0;
    int startBlock = i / len;
    int endBlock = j / len;
    if (startBlock == endBlock) {
        for (int k = i; k <= j; k++)
            sum += nums[k];
    } else {
        for (int k = i; k <= (startBlock + 1) * len - 1; k++)
            sum += nums[k];
        for (int k = startBlock + 1; k <= endBlock - 1; k++)
            sum += b[k];
        for (int k = endBlock * len; k <= j; k++)
            sum += nums[k];
    }
    return sum;
}

public void update(int i, int val) {
    int b_l = i / len;
    b[b_l] = b[b_l] - nums[i] + val;
    nums[i] = val;
}
// Accepted
     * 
     * 
     * 
     * 
     * 
     * 
     */

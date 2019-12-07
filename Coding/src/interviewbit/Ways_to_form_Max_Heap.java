//not done
/*Ways to form Max Heap
Asked in:  
Directi
Problem Setter: aayushkapadia Problem Tester: sneh_gupta
Max Heap is a special kind of complete binary tree in which for every node the value present in that node is greater than the value present in it’s children nodes. If you want to know more about Heaps, please visit this link

So now the problem statement for this question is:

How many distinct Max Heap can be made from n distinct integers

In short, you have to ensure the following properties for the max heap :

Heap has to be a complete binary tree ( A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible. )
Every node is greater than all its children
Let us take an example of 4 distinct integers. Without loss of generality let us take 1 2 3 4 as our 4 distinct integers

Following are the possible max heaps from these 4 numbers :

         4 
       /  \ 
      3   2 
     / 
    1
         4 
       /  \ 
      2   3 
     / 
    1
        4 
       /  \ 
      3   1 
     / 
    2
These are the only possible 3 distinct max heaps possible for 4 distinct elements.

Implement the below function to return the number of distinct Max Heaps that is possible from n distinct elements.

As the final answer can be very large output your answer modulo 1000000007

Input Constraints : n <= 100

 NOTE: Note that even though constraints are mentioned for this problem, for most problems on InterviewBit, constraints are intentionally left out. In real interviews, the interviewer might not disclose constraints and ask you to do the best you can do
 * 
 */
package interviewbit;

public class Ways_to_form_Max_Heap {
	
	int MOD = 1000000007;
	public int solve(int A) {
		long[] ans = new long[101];
		ans[1] = 1;
		ans[0] = 1;
		for(int i=2; i<=A; i++)
		{
			int levels = binlog(i);
			int maxNumOfLeafs = (int) Math.pow(2, levels);
			int actualLeafs = i - (maxNumOfLeafs-1);
			int left = actualLeafs >= maxNumOfLeafs/2 ? maxNumOfLeafs-1: maxNumOfLeafs-1-(maxNumOfLeafs/2 - actualLeafs);
			ans[i] = (ncr(i-1, left)*ans[left])%MOD;
			ans[i] = (ans[i]*ans[i-1-left])%MOD;
		}
		return (int) ans[A];
	}
	
	public static int binlog( int bits ) // returns 0 for bits=0
	{
		int log = 0;
		if( ( bits & 0xffff0000 ) != 0 ) { bits >>>= 16; log = 16; }
		if( bits >= 256 ) { bits >>>= 8; log += 8; }
		if( bits >= 16  ) { bits >>>= 4; log += 4; }
		if( bits >= 4   ) { bits >>>= 2; log += 2; }
		return log + ( bits >>> 1 );
	}
	
	long ncr(int m, int k)
	{
		if(k == 0) return 1;
		if(m == k) return 1;
		long num = 1;
		for(int i=m-k+1; i<=m; i++)
		{
			num = (num * i)%MOD;
		}
		long den = 1;
		for(int i=1; i<=k; i++)
		{
			den= (den*i)%MOD;
		}
		long ans = (num*inverse(den))%MOD;
		return ans;
	}
	
	long inverse(long num)
	{
		int pow = MOD-2;
		long ans = 1;
		long base = num;
		while(pow > 0)
		{
			if(pow == 1)
				return (ans*base)%MOD;
			if(pow % 2 == 0)
			{
				base = (base*base)%MOD;
				pow/=2;
			}
			else
			{
				ans = (base*ans)%MOD;
				pow--;
			}
		}
		return ans;
	}

}

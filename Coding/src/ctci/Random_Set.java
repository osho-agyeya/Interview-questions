//done
package ctci;

public class Random_Set {
	

	 /* Random number between lower and higher, inclusive */
	  public static int rand(int lower, int higher)
	 {
	     return lower + (int)(Math.random() * (higher - lower + 1));
	 }

	 /* pick M elements from original array. Clone original array so that
	 * we don�t destroy the input. */

	 public static int[] pickMRandomly(int[] original, int m)
	{
	 int[] subset = new int[m];
	 int[] array = original.clone();
	  for (int j = 0; j < m; j++)
	  {
	   int index = rand(j, array.length - 1);
	   subset[j] = array[index];
	   array[index] = array[j]; // array[j] is now �dead�
	  }
	   return subset;
	}

	public static void main(String a[])

	{  int ar[]=new int[]{2,5,3,1,4};
	   int br[]=new int[5];
	   br=pickMRandomly(ar,5);//n-1
	      System.out.println();
	   for(int i=0;i<br.length;i++)
	   System.out.print(br[i] + " " );
	}

}

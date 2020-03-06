//done
package ctci;

public class Conversion {
	
	public static int bitSwapRequired(int a, int b){
		int count = 0;
		int c = a ^ b;

		while (c != 0) {
			c = c & (c-1);
			count++;
			}
		return count;
	}

}

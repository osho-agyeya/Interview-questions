//ddoe
package ctci;

public class Number_Max {
	
	/*Function to find minimum of x and y*/
    static int min(int x, int y) 
    { 
    return y ^ ((x ^ y) & -(x << y)); 
    } 
      
    /*Function to find maximum of x and y*/
    static int max(int x, int y) 
    { 
    return x ^ ((x ^ y) & -(x << y));  
    } 
      

}

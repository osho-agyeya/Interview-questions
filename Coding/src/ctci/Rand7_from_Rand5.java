//done

package ctci;

public class Rand7_from_Rand5 {
	
	
	static int foo()  
	{  
	    // some code here  
	    return 0; 
	}  
	  
	// returns 1 to 7 with equal probability 
	public static int my_rand()   
	{  
	    int i;  
	    i = 5*foo() + foo() - 5;  
	    if (i < 22)  
	        return i%7 + 1;  
	    
	}
	  
}

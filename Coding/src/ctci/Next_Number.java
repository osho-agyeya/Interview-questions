//ddoe

package ctci;

public class Next_Number {
	
	static int getPrev(int n) 
	{ 
	    /* Compute c0 and  
	    c1 and store N*/
	    int temp = n; 
	    int c0 = 0; 
	    int c1 = 0; 
	  
	    while ((temp & 1) == 1) 
	    { 
	        c1++; 
	        temp = temp >> 1; 
	    } 
	  
	    if (temp == 0) 
	        return -1; 
	  
	    while (((temp & 1) == 0) &&  
	            (temp!= 0)) 
	    { 
	        c0++; 
	        temp = temp >> 1; 
	    } 
	  
	    return n - (1 << c1) -  
	               (1 << (c0 - 1)) + 1; 
	}
	
	static int getNext(int n) 
	{ 
	    /* Compute c0  
	    and c1 */
	    int c = n; 
	    int c0 = 0; 
	    int c1 = 0; 
	  
	    while (((c & 1) == 0) && (c != 0)) 
	    { 
	        c0 ++; 
	        c >>= 1; 
	    } 
	    while ((c & 1) == 1) 
	    { 
	        c1++; 
	        c >>= 1; 
	    } 
	  
	    // If there is no bigger number  
	    // with the same no. of 1's 
	    if (c0 + c1 == 31 || c0 + c1 == 0) 
	        return -1; 
	  
	    return n + (1 << c0) +  
	               (1 << (c1 - 1)) - 1; 
	} 
	
	

}

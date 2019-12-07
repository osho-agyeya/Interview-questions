//doe

package ctci;

public class Binary_to_String {
	
	 static String printBinary(double num) 
	    { 
	        // Check Number is Between 0 to 1 or Not 
	        if (num >= 1 || num <= 0) 
	            return "ERROR"; 
	  
	        StringBuilder binary = new StringBuilder(); 
	        binary.append("."); 
	  
	        while (num > 0) 
	        { 
	            /* Setting a limit on length: 32 characters, 
	               If the number cannot be represented 
	               accurately in binary with at most 32 
	               character  */
	            if (binary.length() >= 32) 
	                return "ERROR"; 
	  
	            // Multiply by 2 in num to check it 1 or 0 
	            double r = num * 2; 
	            if (r >= 1) 
	            { 
	                binary.append(1); 
	                num = r - 1; 
	            } 
	            else
	            { 
	                binary.append(0); 
	                num = r; 
	            } 
	        } 
	        return binary.toString(); 
	    } 

}

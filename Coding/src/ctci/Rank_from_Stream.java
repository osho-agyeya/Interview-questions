//done
package ctci;

public class Rank_from_Stream {
	
	public static void main(String[] args)  
	{ 
	    int a[] = {5, 1, 14, 4, 15, 9, 7, 20, 11};  
	    int key = 20;  
	    int arraySize = a.length;  
	    int count = 0;  
	    for(int i = 0; i < arraySize; i++)  
	    {  
	        if(a[i] <= key)  
	        {  
	            count += 1;  
	        }  
	    }  
	    System.out.println("Rank of " + key +  
	                    " in stream is: " + (count - 1)); 
	} 

}

//doe
package ctci;

public class Master_Mind {
	
	String getHint(String answer, String guess) {
	    int m[]=new int[256], h = 0, p = 0;
	    for (int i = 0; i < answer.length(); ++i) {
	        if (answer.charAt(i) == guess.charAt(i)) ++h;
	        else {
	            if (m[answer.charAt(i)]++ < 0) ++p;
	            if (m[guess.charAt(i)]-- > 0) ++p;
	        }
	    }
	    return String.valueOf(h) + "H" + String.valueOf(p) + "P";
	}

}

//ddoe
/*Pretty Json
Asked in:  
Facebook
Microsoft
Given a string A representating json object. Return an array of string denoting json object with proper indentaion.

Rules for proper indentation:

Every inner brace should increase one indentation to the following lines.
Every close brace should decrease one indentation to the same line and the following lines.
The indents can be increased with an additional ‘\t’
Note:

[] and {} are only acceptable braces in this case.

Assume for this problem that space characters can be done away with.



Input Format

The only argument given is the integer array A.
Output Format

Return a list of strings, where each entry corresponds to a single line. The strings should not have "\n" character in them.
For Example

Input 1:
    A = "{A:"B",C:{D:"E",F:{G:"H",I:"J"}}}"
Output 1:
    { 
        A:"B",
        C: 
        { 
            D:"E",
            F: 
            { 
                G:"H",
                I:"J"
            } 
        } 
    }

Input 2:
    A = ["foo", {"bar":["baz",null,1.0,2]}]
Output 2:
   [
        "foo", 
        {
            "bar":
            [
                "baz", 
                null, 
                1.0, 
                2
            ]
        }
    ]
 * 
 */

package interviewbit;

public class Pretty_Json {
	
	 public static String pretty(String s) {
        StringBuilder sb = new StringBuilder();
        int indent = 0;
        char pre = 0;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) continue;
            if (c == ']' || c == '}') indent--;
            if (pre == '[' || pre == '{' || pre == ',' || c == ']' || c == '}') {
                sb.append('\n');
                for (int i = 0; i < indent; i++) sb.append("  ");
            }       
            sb.append(c);
            if (c == '[' || c == '{') indent++;
            pre = c;
        }       
        return sb.toString();
    }

}

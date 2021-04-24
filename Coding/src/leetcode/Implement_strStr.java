//completed

/*
 * 
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

 

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Example 3:

Input: haystack = "", needle = ""
Output: 0
 

Constraints:

0 <= haystack.length, needle.length <= 5 * 104
haystack and needle consist of only lower-case English characters.
 */
package leetcode;

public class Implement_strStr {
	
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
    for (int j = 0; ; j++) {
      if (j == needle.length()) return i;
      if (i + j == haystack.length()) return -1;
      if (needle.charAt(j) != haystack.charAt(i + j)) break;
    }
  }
    }
    
    /*KMP algorithm
     * 
      public int strStr(String haystack, String needle) {
        
        
        return KMP(haystack.toCharArray(),needle.toCharArray());
    }
    
     private int[] computeTemporaryArray(char pattern[]){
        int [] lps = new int[pattern.length];
        int j =0;
        for(int i=1; i < pattern.length;){
            if(pattern[i] == pattern[j]){
                lps[i] = j + 1;
                j++;
                i++;
            }else{
                if(j != 0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        return lps;
    }

       public int KMP(char []text, char []pattern){
        
        int lps[] = computeTemporaryArray(pattern);
        int i=0;
        int j=0;
           int ans=-1;
           int p=pattern.length;
           int t=text.length;
           if((p==0 && t==0) || (p==0 && t!=0))
              ans=0;
        while(i < text.length && j < pattern.length){
            if(text[i] == pattern[j]){
                i++;
                j++;
                if(j==pattern.length){
                    ans= i-pattern.length;
                    break;
                }
            }else{
                if(j!=0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        return ans;
            
    }
     * 
     */
    
    

}

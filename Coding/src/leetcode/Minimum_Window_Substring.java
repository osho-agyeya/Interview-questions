/* over, s+t, s+t
Given two strings s and t, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".

Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Example 2:

Input: s = "a", t = "a"
Output: "a"
 

Constraints:

1 <= s.length, t.length <= 105
s and t consist of English letters. 
 */
package leetcode;

public class Minimum_Window_Substring {
	
	/*
	 * 
	 * I will first give the solution then show you the magic template.

The code of solving this problem is below. It might be the shortest among all solutions provided in Discuss.

string minWindow(string s, string t) {
        vector<int> map(128,0);
        for(auto c: t) map[c]++;
        int counter=t.size(), begin=0, end=0, d=INT_MAX, head=0;
        while(end<s.size()){
            if(map[s[end++]]-->0) counter--; //in t
            while(counter==0){ //valid
                if(end-begin<d)  d=end-(head=begin);
                if(map[s[begin++]]++==0) counter++;  //make it invalid
            }  
        }
        return d==INT_MAX? "":s.substr(head, d);
    }
Here comes the template.

For most substring problem, we are given a string and need to find a substring of it which satisfy some restrictions. A general way is to use a hashmap assisted with two pointers. The template is given below.

int findSubstring(string s){
        vector<int> map(128,0);
        int counter; // check whether the substring is valid
        int begin=0, end=0; //two pointers, one point to tail and one  head
        int d; //the length of substring

        for() {  initialize the hash map here  }

        while(end<s.size()){

            if(map[s[end++]]-- ?){   modify counter here  }

            while( counter condition ){ 
                 
                  update d here if finding minimum

                //increase begin to make it invalid/valid again
                
                if(map[s[begin++]]++ ?){ modify counter here }
            }  

             update d here if finding maximum
        }
        return d;
  }
One thing needs to be mentioned is that when asked to find maximum substring, we should update maximum after the inner while loop to guarantee that the substring is valid. On the other hand, when asked to find minimum substring, we should update minimum inside the inner while loop.

The code of solving Longest Substring with At Most Two Distinct Characters is below:

int lengthOfLongestSubstringTwoDistinct(string s) {
        vector<int> map(128, 0);
        int counter=0, begin=0, end=0, d=0; 
        while(end<s.size()){
            if(map[s[end++]]++==0) counter++;
            while(counter>2) if(map[s[begin++]]--==1) counter--;
            d=max(d, end-begin);
        }
        return d;
    }
The code of solving Longest Substring Without Repeating Characters is below:

Update 01.04.2016, thanks @weiyi3 for advise.

int lengthOfLongestSubstring(string s) {
        vector<int> map(128,0);
        int counter=0, begin=0, end=0, d=0; 
        while(end<s.size()){
            if(map[s[end++]]++>0) counter++; 
            while(counter>0) if(map[s[begin++]]-->1) counter--;
            d=max(d, end-begin); //while valid, update d
        }
        return d;
    }
I think this post deserves some upvotes! : )
	 * 
	 */
	
	public String minWindow(String s, String t) {
	    int [] map = new int[128];
	    for (char c : t.toCharArray()) {
	      map[c]++;
	    }
	    int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
	    while (end < s.length()) {
	      final char c1 = s.charAt(end);
	      if (map[c1] > 0) counter--;
	      map[c1]--;
	      end++;
	      while (counter == 0) {
	        if (minLen > end - start) {
	          minLen = end - start;
	          minStart = start;
	        }
	        final char c2 = s.charAt(start);
	        map[c2]++;
	        if (map[c2] > 0) counter++;
	        start++;
	      }
	    }

	    return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
	  }

}


/*
 * 

Longest Substring - at most K distinct characters

  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int[] map = new int[256];
    int start = 0, end = 0, maxLen = Integer.MIN_VALUE, counter = 0;

    while (end < s.length()) {
      final char c1 = s.charAt(end);
      if (map[c1] == 0) counter++;
      map[c1]++;
      end++;

      while (counter > k) {
        final char c2 = s.charAt(start);
        if (map[c2] == 1) counter--;
        map[c2]--;
        start++;
      }

      maxLen = Math.max(maxLen, end - start);
    }

    return maxLen;
  }

LongestSubstring - without repeating characters

  public int lengthOfLongestSubstring2(String s) {
    int[] map = new int[128];
    int start = 0, end = 0, maxLen = 0, counter = 0;

    while (end < s.length()) {
      final char c1 = s.charAt(end);
      if (map[c1] > 0) counter++;
      map[c1]++;
      end++;

      while (counter > 0) {
        final char c2 = s.charAt(start);
        if (map[c2] > 1) counter--;
        map[c2]--;
        start++;
      }

      maxLen = Math.max(maxLen, end - start);
    }

    return maxLen;
  }

 * 
 */

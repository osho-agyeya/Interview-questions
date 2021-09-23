/* over, n, 1
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
Machine 1 (sender) has the function: 
string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}
Machine 2 (receiver) has the function: 
vector<string> decode(string s) {
  //... your code
  return strs;
}

So Machine 1 does: 
string encoded_string = encode(strs);

and Machine 2 does: 
vector<string> strs2 = decode(encoded_string);

strs2 in Machine 2 should be the same as strs in Machine 1. 
Implement the encode and decode methods. 
Note:
The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized enough to work on any possible characters.
Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
 * 
 * 
 */

package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Encode_and_Decode_Strings {
	
	/*
	 * 
	 * Approach 1: Non-ASCII Delimiter
Intuition

Naive solution here is to join strings using delimiters.

What to use as a delimiter? Each string may contain any possible characters out of 256 valid ascii characters.

Seems like one has to use non-ASCII unichar character, for example unichr(257) in Python and Character.toString((char)257) in Java (it's character ā).

fig

Here it's convenient to use two different non-ASCII characters, to distinguish between situations of "empty array" and of "array of empty strings".

Implementation

Use split in Java with a second argument -1 to make it work as split in Python.


Complexity Analysis

Time complexity : \mathcal{O}(N)O(N) both for encode and decode, where N is a number of strings in the input array.

Space complexity : \mathcal{O}(1)O(1) for encode to keep the output, since the output is one string. \mathcal{O}(N)O(N) for decode keep the output, since the output is an array of strings.


Approach 2: Chunked Transfer Encoding
Pay attention to this approach because last year Google likes to ask that sort of low-level optimisation. Serialize and deserialize BST problem is a similar example.

This approach is based on the encoding used in HTTP v1.1. It doesn't depend on the set of input characters, and hence is more versatile and effective than Approach 1.

Data stream is divided into chunks. Each chunk is preceded by its size in bytes.

Encoding Algorithm

fig

Iterate over the array of chunks, i.e. strings.

For each chunk compute its length, and convert that length into 4-bytes string.

Append to encoded string :

4-bytes string with information about chunk size in bytes.

Chunk itself.

Return encoded string.

Decoding Algorithm

fig

Iterate over the encoded string with a pointer i initiated as 0. While i < n:

Read 4 bytes s[i: i + 4]. It's chunk size in bytes. Convert this 4-bytes string to integer length.

Move the pointer by 4 bytes i += 4.

Append to the decoded array string s[i: i + length].

Move the pointer by length bytes i += length.

Return decoded array of strings.

Implementation


Complexity Analysis

Time complexity : \mathcal{O}(N)O(N) both for encode and decode, where N is a number of strings in the input array.

Space complexity : \mathcal{O}(1)O(1) for encode to keep the output, since the output is one string. \mathcal{O}(N)O(N) for decode keep the output, since the output is an array of strings.
	 * 
	 */
	
	 // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<String>();
        int i = 0;
        while(i < s.length()) {
            int slash = s.indexOf('/', i);
            int size = Integer.valueOf(s.substring(i, slash));
            res.add(s.substring(slash + 1, slash + size + 1));
            i = slash + size + 1;
        }
        return res;
    }   

}

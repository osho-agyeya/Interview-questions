/*completed
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
A solution is: 
[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
] */

package leetcodePremium;

public class Group_Shifted_Strings {
	
	public List<List<String>> groupStrings(String[] strings) {
        Map<String,   List<String>> map = new HashMap<>();

        for(String s : strings){
            String hash = getHash(s);
            if(map.containsKey(hash)){
                map.get(hash).add(s);
            }else{
                List<String> l = new ArrayList<>();
                l.add(s);
                map.put(hash, l);
            }
        }

        return new ArrayList<List<String>>(map.values());
    }

    String getHash(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< s.length(); i++){
            sb.append((s.charAt(i) - s.charAt(0) + 26) % 26);
            sb.append('.');// to make sure there is no overlap.
        }

        return sb.toString();
    }

}

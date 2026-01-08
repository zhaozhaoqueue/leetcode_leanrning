package array_and_string;

import java.util.Map;
import java.util.HashMap;
// core idea:
// 1. Hashmap
// 2. count the occurency of each letter
// 3. for the second string, loop the letters and minus the occurency in the previous hashmap
// 4. if find the unseen letter or the occurency is already 0 before minus the current one, return false

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        // if lengths are not equal, return directly
        if (s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> charOccurMap = new HashMap<>();
        // check the occurency of letters in the first string
        for (int i = 0; i < s.length(); i++){
            charOccurMap.put(s.charAt(i), charOccurMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            if(!charOccurMap.containsKey(ch) || charOccurMap.get(ch) == 0) {
                return false;
            }
            charOccurMap.put(ch, charOccurMap.get(ch) - 1);
        }
        return true;
    }
    
}

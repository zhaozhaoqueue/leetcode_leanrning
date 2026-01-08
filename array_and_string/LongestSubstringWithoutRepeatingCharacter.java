package array_and_string;

import java.util.Map;
import java.util.HashMap;

// core idea:
// 1. sliding window
// 2. pay attention to the situation that the loop is over

class LongestSubstringWithoutRepeatingCharacter {
    public int lengthOfLongestSubstring(String s) {
        int max_length = 0;
        Map<Character, Integer> seenCharMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (seenCharMap.containsKey(s.charAt(j))){
                    max_length = seenCharMap.size() > max_length ? seenCharMap.size() : max_length;
                    seenCharMap.clear();
                    break;
                } else {
                    seenCharMap.put(s.charAt(j), j);
                }
            }
        }
        return seenCharMap.size() > max_length ? seenCharMap.size() : max_length;
    }
}
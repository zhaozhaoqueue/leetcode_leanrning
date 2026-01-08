package array_and_string;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        int maxFreq = 0;
        for (int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            maxFreq = maxFreq > map.get(temp) ? maxFreq : map.get(temp);

            while ((i - left + 1 - maxFreq) > k){
                // shrink
                char tempL = s.charAt(left);
                map.put(tempL, map.get(tempL) - 1);
                left ++;
            }
            maxLen = maxLen > i - left + 1 ? maxLen : i - left + 1;
        }
        return maxLen;
    }
}

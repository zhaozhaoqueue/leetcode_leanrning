package array_and_string;

import java.util.List;
// import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

// core idea:
// sliding window: 
//      expand by moving the right pointer
//          try to find the substring (starting from left and ending at right) containing at least all the characters in t
//          when find it, 
//              first check if the required condition is met. If so, store the result.
//              and then shrink the window by moving the left pointer.

class FindAllAnagramsInAString {
    public List<Integer> slidingWindowTemplateByHarryChaoyangHe(String s, String t) {
        //init a collection or int value to save the result according the question.
        List<Integer> result = new LinkedList<>();
        if(t.length()> s.length()) return result;
        
        //create a hashmap to save the Characters of the target substring.
        //(K, V) = (Character, Frequence of the Characters)
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //maintain a counter to check whether match the target string.
        //must be the map size, NOT the string size because the char may be duplicate.
        // number of distinct chars still not fully matched
        int counter = map.size();
        
        //Two Pointers: begin - left pointer of the window; end - right pointer of the window
        int begin = 0, end = 0;
        
        //the length of the substring which match the target string.
        int len = Integer.MAX_VALUE; 
        
        //loop at the begining of the source string
        while(end < s.length()){
            
            char c = s.charAt(end);//get a character
            
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);// plus or minus one
                if(map.get(c) == 0) counter--;//modify the counter according the requirement(different condition).
            }
            end++;
            
            //increase begin pointer to make it invalid/valid again
            while(counter == 0 /* counter condition. different question may have different condition */){
                
                char tempc = s.charAt(begin);//***be careful here: choose the char at begin pointer, NOT the end pointer
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);//plus or minus one
                    if(map.get(tempc) > 0) counter++;//modify the counter according the requirement(different condition).
                }
                
                /* save / update(min/max) the result if find a target*/
                // result collections or result int value
                
                begin++;
            }
        }
        return result;
    }


    public List<Integer> findAnagrams(String s, String t) {
        List<Integer> result = new LinkedList<>();
        if(t.length()> s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int counter = map.size();

        
        for (int i = 0; i < s.length(); i++){
            // expand the window until the window contains at least all the characters in t
            char temp = s.charAt(i);
            if (map.containsKey(temp)){
                map.put(temp, map.get(temp) - 1);
                if (map.get(temp) == 0){
                    counter --;
                }
            }

            // shrink by moving the left pointer
            while (counter == 0){
                char tmpL = s.charAt(left);
                if (map.containsKey(tmpL)){
                    map.put(tmpL, map.get(tmpL) + 1);
                    if (map.get(tmpL) > 0){
                        counter ++;
                    }
                }
                if (t.length() == i - left + 1){
                    result.add(left);
                }
                left ++;
            }
        }

        return result;
    }

    public static void main (String[] args){
        String s = "cbaebabacd";
        String p = "abc";
        FindAllAnagramsInAString obj = new FindAllAnagramsInAString();
        List<Integer> res = obj.findAnagrams(s,p);
        System.out.print(res);
    }
}

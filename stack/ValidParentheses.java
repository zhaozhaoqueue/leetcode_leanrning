package stack;

import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() == 0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        for (int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if (map.containsKey(temp)){
                if (stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if (map.get(temp) != top){
                    return false;
                }
            } else {
                stack.push(temp);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        String s = "([])";
        ValidParentheses obj = new ValidParentheses();
        boolean res = obj.isValid(s);
        System.out.print(res);
    }
}

package stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < tokens.length; i++){
            String t = tokens[i];
            if(t.matches("^[+-]?\\d+$")){
                stack.push(Integer.parseInt(t));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(calculate(a, b, t));
            }
        }
        return stack.pop();
    }

    public static Integer calculate(Integer a, Integer b, String operator){
        if (operator.equals("+")) {
            return a + b;
        } else if (operator.equals("-")){
            return a - b;
        } else if (operator.equals("*")){
            return a * b;
        } else if (operator.equals("/")){
            return a / b;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        EvaluateReversePolishNotation obj = new EvaluateReversePolishNotation();
        Integer res = obj.evalRPN(tokens);
        System.out.println(res);
    }
}

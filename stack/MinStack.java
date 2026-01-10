package stack;

import java.util.List;
import java.util.ArrayList;

public class MinStack {
    private List<Integer> array;
    private List<Integer> minIdx;
    private int nextIdx;
    public MinStack() {
        array = new ArrayList<>();
        minIdx = new ArrayList<>();
        nextIdx = 0;
    }
    
    public void push(int val) {
        array.add(val);
        if (minIdx.size() == 0) {
            minIdx.add(nextIdx);
        } else {
            int idx = minIdx.get(nextIdx - 1);
            minIdx.add(array.get(idx) < val ? idx : nextIdx);
        }
        nextIdx ++;
    }
    
    public void pop() {
        nextIdx --;
        array.removeLast();
        minIdx.removeLast();
    }
    
    public int top() {
        return array.getLast();
    }
    
    public int getMin() {
        return array.get(minIdx.get(nextIdx - 1));
    }

    public static void main(String[] args){
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.print(obj.getMin());
        obj.pop();
        System.out.print(obj.top());
        System.out.print(obj.getMin());
    }
}

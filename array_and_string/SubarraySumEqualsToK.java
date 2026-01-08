package array_and_string;

import java.util.Map;
import java.util.HashMap;

// core idea: 
// 1. SUM[I - J] = k ==> SUM[I] - SUM[J] = k ==> SUM[I] - k = SUM[J]
// 2. loop the array, get the accumulative sum;
// 3. use hashmap to conserve the previous accumulative sum values and the its occurency

public class SubarraySumEqualsToK {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int counter = 0;
        Map<Integer, Integer> subSumOccuMap = new HashMap<>();
        subSumOccuMap.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (subSumOccuMap.containsKey(sum - k)){
                counter += subSumOccuMap.get(sum - k);
            }
            subSumOccuMap.put(sum, subSumOccuMap.getOrDefault(sum, 0) + 1);
        }
        return counter;
    }

    public static void main(String[] args) {
        SubarraySumEqualsToK solution = new SubarraySumEqualsToK();
        int res = solution.subarraySum(new int[]{1,-1,0}, 0);
        System.out.println(res);
    }
}

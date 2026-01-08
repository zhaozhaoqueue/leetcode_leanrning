package array_and_string;

// core idea:
// 1. hash map
// 2. target - number then check if the result in the givin list

import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res_idx = new int[]{};
        Map<Integer, Integer> numIdxMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int res = target - nums[i];
            if (numIdxMap.containsKey(res)) {
                res_idx[0] = i;
                res_idx[1] = numIdxMap.get(res);
                return res_idx;
            }
            numIdxMap.put(nums[i], i);
        }
        return res_idx;
    }
}
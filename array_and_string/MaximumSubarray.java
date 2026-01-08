package array_and_string;

// core idea: dynamic programming
// 1. the max sum of the subarray until the i index is:
//    max of (max sum of the subarray until i-1) and (max sum of the subarray until i-1) + number at i

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        // // DP solution
        // int[] dp = new int[nums.length]; //dp[i] means the max sum of sub array ending with i
        // dp[0] = nums[0];
        // for (int i = 1; i<nums.length; ++i){
        //     dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        // }
        // int max = Integer.MIN_VALUE;
        // for (int i = 0; i < dp.length; i++){
        //     max = max > dp[i] ? max : dp[i];
        // }
        // return max;

        // Kadane's algorithm: save space
        int currentMax = nums[0];
        int globalMax = nums[0];
        for (int i = 1; i < nums.length; i++){
            currentMax = (currentMax + nums[i]) > currentMax ? (currentMax + nums[i]) : currentMax;
            globalMax = currentMax > globalMax ? currentMax : globalMax;
        }
        return globalMax;
    }
}

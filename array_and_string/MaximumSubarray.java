package array_and_string;

// core idea: dynamic programming
// 1. the max sum of the subarray until the i index is:
//    max of (max sum of the subarray until i-1) and (max sum of the subarray until i-1) + number at i

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        // DP solution
        int[] dp = new int[nums.length]; //dp[i] means the max sum of sub array ending with i
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i<nums.length; ++i){
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

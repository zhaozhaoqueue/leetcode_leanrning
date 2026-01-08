package array_and_string;

// core idea:
// 1. sliding window:
//    if sum meets the condition, shrink the window by moving the left pointer to next one
//    if not, move the right pointer to the next one

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int curSum = 0;
        int minLength = nums.length;
        int allSum = 0;
        for (int i = 0; i < nums.length; i++){
            // handle the corner case
            allSum += nums[i];
            curSum = curSum + nums[i];
            while (curSum >= target){
                minLength = minLength < (i - left + 1) ? minLength : (i - left + 1);
                curSum -= nums[left];
                left ++;
            }
        }
        return allSum < target ? 0 : minLength;
    }
}

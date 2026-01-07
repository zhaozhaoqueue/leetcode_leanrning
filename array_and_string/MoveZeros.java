package array_and_string;

// core idea:
// 1. 2 pointer and switch

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int left = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                left ++;
            }
        }
    }
}

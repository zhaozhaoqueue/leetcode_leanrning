package array_and_string;

// core idea:
// 1. 2 pointers, one pointer to mark the unique element list, the other to loop
// 2. if the faster one find the new element not equal to the slower pointer, move the slower pointer one step and switch the elements

class RemoveDuplicatesFromSortedArray{
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return ++i;
    }
}
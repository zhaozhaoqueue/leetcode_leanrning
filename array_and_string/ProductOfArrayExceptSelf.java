package array_and_string;

// core idea:
// 1. loop and get the accumulative product before i (prefix)
// 2. loop again backward and get the accumulative product after i (suffix)
// 3. product 2 results
// 4. use one array to save space

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        res[0] = 1;
        res[n-1] = 1;
        for (int i = 1; i < n; i++){
            res[i] = res[i - 1] * nums[i - 1];
        }
        int prod = 1;
        for (int i = n - 2; i >= 0; i--){
            prod = prod * nums[i + 1];
            res[i] = res[i] * prod;
        }
        return res;
    }

    public static void main(String[] args){
        ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
        int[] res = obj.productExceptSelf(new int[]{1,2,3,4});
        System.out.print(res);
    }
}
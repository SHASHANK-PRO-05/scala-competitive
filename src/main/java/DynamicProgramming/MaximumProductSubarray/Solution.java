package DynamicProgramming.MaximumProductSubarray;

/**
 * https://leetcode.com/problems/maximum-product-subarray/#/description
 */
public class Solution {
    /**
     * Time limit exceeded Solution
     */
//    public int maxProduct(int[] nums) {
//        int ans = Integer.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
//        int[] arr = new int[nums.length];
//        int parameter = 1;
//        for (int i = 0; i < nums.length; i++) {
//            arr[i] = nums[i];
//            if (min > arr[i]) min = arr[i];
//
//            if (Math.abs(nums[i]) == 1) {
//                parameter *= nums[i];
//                continue;
//            }
//            for (int j = 0; j < i; j++) {
//                arr[j] *= nums[i] * parameter;
//                if (ans < arr[j])
//                    ans = arr[j];
//            }
//        }
//        return ans;
//    }
    public int maxProduct(int[] nums) {
        int maxhere, minhere;
        int maxSoFar = nums[0], minSoFarPre = nums[0], maxSoFarPre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxhere = Math.max(nums[i], Math.max(nums[i] * maxSoFarPre, nums[i] * minSoFarPre));
            minhere = Math.min(nums[i], Math.min(nums[i] * maxSoFarPre, nums[i] * minSoFarPre));
            maxSoFar = Math.max(maxSoFar, maxhere);
            minSoFarPre = minhere;
            maxSoFarPre = maxhere;
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-4, -3};
        System.out.println(solution.maxProduct(nums));
    }
}

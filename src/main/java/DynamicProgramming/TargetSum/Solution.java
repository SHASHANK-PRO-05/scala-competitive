package DynamicProgramming.TargetSum;

/**
 * https://leetcode.com/problems/target-sum/#/description
 */
public class Solution {

    /**
     * This function will run in memory limit exceeded
     *
     * @param nums
     * @param s
     * @return
     */
//    public int findTargetSumWays(int[] nums, int S) {
//        int len = nums.length;
//        int arrLen = (int) Math.pow(2, len);
//        int[][] arr = new int[len][arrLen];
//        arr[0][0] = nums[0];
//        arr[0][1] = nums[0] * -1;
//
//        int ans = 0;
//        if (len == 1) {
//            if (arr[0][0] == S) ans++;
//            if (arr[0][1] == S) ans++;
//        }
//        for (int i = 1; i < len; i++) {
//            int maxJ = (int) Math.pow(2, i);
//            for (int j = 0; j < maxJ; j++) {
//                arr[i][j] = arr[i - 1][j] + nums[i];
//                arr[i][j + maxJ] = arr[i - 1][j] - nums[i];
//                if (i == len - 1) {
//                    if (arr[i][j] == S) ans++;
//                    if (arr[i][j + maxJ] == S) ans++;
//                }
//            }
//        }
////        for (int i = 0; i < len; i++) {
////            for (int j = 0; j < arrLen; j++) {
////                System.out.print(arr[i][j] + " ");
////            }
////            System.out.println();
////        }
//        return ans;
//    }
    public int recur(int[] nums, int index, int s, int sum) {
        if (index == nums.length) {
            if (sum == s) return 1;
            else return 0;
        }
        int ans = 0;
        ans += recur(nums, index + 1, s, sum + nums[index])
                + recur(nums, index + 1, s, sum - nums[index]);

        return ans;
    }

    public int findTargetSumWays(int[] nums, int s) {
        return recur(nums, 0, s, 0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(solution.findTargetSumWays(arr, 3));
    }
}

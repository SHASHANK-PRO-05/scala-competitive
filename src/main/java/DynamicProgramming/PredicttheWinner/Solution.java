package DynamicProgramming.PredicttheWinner;

public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j)
                    dp[i][j] = nums[i];
                else {
                    dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1] > 0 ? true : false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 7, 2};
        //System.out.println(solution.PreditctTheWinner(arr));
    }
}

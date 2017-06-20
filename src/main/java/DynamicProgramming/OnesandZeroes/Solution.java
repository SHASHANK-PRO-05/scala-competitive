package DynamicProgramming.OnesandZeroes;

public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int c = 0; c < strs.length; c++) {
            int[] count = count(strs[c]);
            for (int i = m; i - count[0] >= 0; i--) {
                for (int j = n; j - count[1] >= 0; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - count[0]][j - count[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public int[] count(String string) {
        int[] arr = {0, 0};
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '0') {
                arr[0]++;
            } else {
                arr[1]++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] string = {"10", "0001", "111001", "1", "0"};
        System.out.println(solution.findMaxForm(string, 5, 3));
    }
}

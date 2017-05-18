package DynamicProgramming.DecodeWays;

/**
 * https://leetcode.com/problems/decode-ways/#/description
 */
public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        int[][] arr = new int[s.length()][2];
        if (s.charAt(0) != '0')
            arr[0][0] = 1;
        arr[0][1] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != '0')
                arr[i][0] = arr[i - 1][0] + arr[i - 1][1];
            if (Integer.parseInt(s.charAt(i - 1) + "" + s.charAt(i)) <= 26) {
                arr[i][1] = arr[i - 1][0];
            }
        }
        return arr[s.length() - 1][0] + arr[s.length() - 1][1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDecodings("101"));

    }
}

package DynamicProgramming.Triangle;

import java.util.List;

public class Solution {
    /**
     * This a solution one that took approx 15ms to complete,
     * not a bonus answer.
     *
     * @param triangle
     * @return
     */
    /*public int minimumTotal(List<List<Integer>> triangle) {
        int[][] arr = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        int minAns = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.size(); i++) {

            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i != 0 && j != 0) {
                    arr[i][j] = triangle.get(i).get(j) + Math.min((j != triangle.get(i).size() - 1 ? arr[i - 1][j] : Integer.MAX_VALUE), arr[i - 1][j - 1]);
                } else if (i == 0) {
                    arr[i][j] = triangle.get(i).get(j);
                } else {
                    arr[i][j] = triangle.get(i).get(j) + arr[i - 1][j];
                }
                if (i == triangle.size() - 1) {
                    minAns = Math.min(arr[i][j], minAns);
                }
            }
        }

        return minAns;
    }
*/
//    public int minimumTotal(List<List<Integer>> triangle) {
//        if (triangle.size() == 0) {
//            return 0;
//        } else if (triangle.size() == 1) return triangle.get(0).get(0);
//        int dp[] = new int[triangle.size()];
//        dp[0] = triangle.get(0).get(0);
//        return minimumTotal(triangle, dp, 1);
//    }
//
//    public int minimumTotal(List<List<Integer>> triangle, int[] dp, int levelIndex) {
//        List<Integer> studyingList = triangle.get(levelIndex);
//        int pre = dp[0], temp;
//        dp[0] += studyingList.get(0);
//        for (int i = 1; i < levelIndex; i++) {
//            temp = dp[i];
//            dp[i] = studyingList.get(i) + Math.min(pre, dp[i]);
//            pre = temp;
//        }
//        dp[levelIndex] = studyingList.get(levelIndex) + pre;
//        if (levelIndex == triangle.size() - 1) {
//            int res = dp[0];
//            for (int i = 1; i <= levelIndex; i++) {
//                res = Math.min(res, dp[i]);
//            }
//            return res;
//        }
//        return minimumTotal(triangle, dp, levelIndex + 1);
//    }
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        List<List<Integer>> lists = new ArrayList<>(Arrays.asList(Arrays.asList(-10), Arrays.asList(3, 4), Arrays.asList(6, 5, 7)));
//
//        int x = solution.minimumTotal(lists);
//        System.out.println(x);
//    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp[] = new int[triangle.size()];

        return 0;
    }
}

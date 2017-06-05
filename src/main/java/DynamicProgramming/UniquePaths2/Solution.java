package DynamicProgramming.UniquePaths2;

/**
 * https://leetcode.com/problems/unique-paths-ii/#/description
 */
public class Solution {
    //    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        int m = obstacleGrid.length;
//        int n = obstacleGrid[0].length;
//        int[][] arr = new int[m][n];
//        if (obstacleGrid[0][0] == 1) return 0;
//        arr[0][0] = 1;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (obstacleGrid[i][j] != 1) {
//                    arr[i][j] += (j > 0 ? arr[i][j - 1] : 0) + (i > 0 ? arr[i - 1][j] : 0);
//                }
//            }
//        }
//        return arr[m - 1][n - 1];
//    }
//
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{0, 0}};
        System.out.println(solution.uniquePathsWithObstacles(arr));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int arr[] = new int[n];
        int k = 0;
        while (k < n && obstacleGrid[0][k] != 1) {
            arr[k] = 1;
            k += 1;
        }
        while (k < n) {
            arr[k] = 0;
            k = k + 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) arr[j] = 0;
                else if (j > 0) arr[j] = arr[j] + arr[j - 1];
            }
        }
        return arr[n - 1];
    }
}

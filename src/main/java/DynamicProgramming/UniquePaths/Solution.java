package DynamicProgramming.UniquePaths;

/**
 * https://leetcode.com/problems/unique-paths/#/description
 */
public class Solution {
//    public int uniquePaths(int m, int n) {
//        long[][] array = new long[m + 1][n + 1];
//        boolean[][] visited = new boolean[m + 1][n + 1];
//        recurSolution(1, 1, array, visited, m, n);
//        array[m][n] = 1;
//        return (int) array[1][1];
//    }
//
//    public long recurSolution(int i, int j, long[][] array, boolean[][] visited, int m, int n) {
//        if (i > m || j > n) {
//            return 0;
//        }
//        if (i == m && j == n) return 1;
//        if (visited[i][j]) return array[i][j];
//        array[i][j] = recurSolution(i + 1, j, array, visited, m, n) + recurSolution(i, j + 1, array, visited, m, n);
//        visited[i][j] = true;
//        return array[i][j];
//    }
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.uniquePaths(2, 2));
//
//    }
    
}


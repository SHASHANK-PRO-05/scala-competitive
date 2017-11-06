package Codility.IMC.ColorMap;

/**
 * Created by shanky on 10/5/17.
 */
public class Solution {
    public int solution(int[][] A) {
        int n = A.length;
        if (A.length != 0) {
            int ans = 0;
            int m = A[0].length;
            boolean[][] visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j]) {
                        ans++;
                        markSame(visited, A, i, j);
                    }
                }
            }
            return ans;
        } else {
            return 0;
        }
    }

    public void markSame(boolean[][] visited, int[][] array, int i, int j) {
        visited[i][j] = true;
        //NORTH
        if (i > 0 && !visited[i - 1][j] && array[i - 1][j] == array[i][j]) markSame(visited, array, i - 1, j);
        //SOUTH
        if (i < visited.length - 1 && !visited[i + 1][j] && array[i + 1][j] == array[i][j])
            markSame(visited, array, i + 1, j);
        //WEST
        if (j > 0 && !visited[i][j - 1] && array[i][j - 1] == array[i][j]) markSame(visited, array, i, j - 1);
        //EAST
        if (j < visited[i].length - 1 && !visited[i][j + 1] && array[i][j + 1] == array[i][j])
            markSame(visited, array, i, j + 1);
    }

    public static void main(String[] args) {
        int[][] array = {{5, 4, 4}, {4, 3, 4}, {3, 2, 4}, {2, 2, 2}, {3, 3, 4}, {1, 4, 4}, {4, 1, 1}};
        Solution s = new Solution();
        System.out.println(s.solution(array));
    }
}

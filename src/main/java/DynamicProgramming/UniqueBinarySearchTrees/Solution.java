package DynamicProgramming.UniqueBinarySearchTrees;

/**
 * https://leetcode.com/problems/unique-binary-search-trees/#/description
 */


public class Solution {

    //    int arr[][] = new int[100][100];
//
//    public int numTrees(int n) {
//
//        return genTrees(1, n);
//    }
//
//    public int genTrees(int start, int end) {
//        int forThis = 0;
//        if (start <= end && arr[start][end] != 0) {
//            return arr[start][end];
//        }
//        for (int i = start; i <= end; i++) {
//            int lefts = genTrees(start, i - 1);
//            int rights = genTrees(i + 1, end);
//
//            if (lefts == 0 && rights == 0) forThis += 1;
//            else if (lefts == 0) forThis += rights;
//            else if (rights == 0) forThis += lefts;
//            else forThis += lefts * rights;
//        }
//        arr[start][end] = forThis;
//        return forThis;
//    }
//
    public static void main(String[] args) {
        Solution solution = new Solution();
        int treeNodes =
                solution.numTrees(19);


        System.out.println();
        System.out.println(treeNodes);


    }
    public int numTrees(int n) {
        if (n == 0 || n == 1) return 1;
        int[] memo = new int[n + 1];
        memo[0] = memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                memo[i] += memo[j] * memo[i - j - 1];
            }
        }
        return memo[n];
    }
}

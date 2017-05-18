package DynamicProgramming.UniqueBinarySearchTrees;

/**
 * https://leetcode.com/problems/unique-binary-search-trees/#/description
 */


public class Solution {

    int arr[][] = new int[100][100];

    public int numTrees(int n) {

        return genTrees(1, n);
    }

    public int genTrees(int start, int end) {
        int forThis = 0;
        if (start <= end && arr[start][end] != 0) {
            return arr[start][end];
        }
        for (int i = start; i <= end; i++) {
            int lefts = genTrees(start, i - 1);
            int rights = genTrees(i + 1, end);

            if (lefts == 0 && rights == 0) forThis += 1;
            else if (lefts == 0) forThis += rights;
            else if (rights == 0) forThis += lefts;
            else forThis += lefts * rights;
        }
        arr[start][end] = forThis;
        return forThis;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int treeNodes =
                solution.numTrees(19);

        System.out.println(treeNodes);


    }
}

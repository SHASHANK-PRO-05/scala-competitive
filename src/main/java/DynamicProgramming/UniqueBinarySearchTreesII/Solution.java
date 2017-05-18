package DynamicProgramming.UniqueBinarySearchTreesII;

/**
 * https://leetcode.com/problems/unique-binary-search-trees-ii/#/description
 * https://leetcode.com/problems/unique-binary-search-trees/#/description
 */

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {

        return "{" + (left != null ? left.toString() : "null") + "<-" + val + "->" + (right != null ? right.toString() : "null") + "}";
    }
}

public class Solution {
    public TreeNode getNewNode(int x, TreeNode left, TreeNode right) {
        TreeNode temp = new TreeNode(x);
        temp.left = left;
        temp.right = right;
        return temp;
    }

    public int generateTrees(int n) {

        return genTrees(1, n).size();
    }

    public List<TreeNode> genTrees(int start, int end) {
        List<TreeNode> forThis = new ArrayList<>();
        for (int i = start; i <= end; i++) {

            List<TreeNode> lefts = genTrees(start, i - 1);
            List<TreeNode> rights = genTrees(i + 1, end);
            //System.out.println(lefts);

            if (lefts.isEmpty() && rights.isEmpty()) {
                TreeNode temp = new TreeNode(i);
                forThis.add(temp);
            } else if (lefts.isEmpty()) {

                for (TreeNode right : rights) {
                    TreeNode temp = new TreeNode(i);
                    temp.right = right;
                    forThis.add(temp);
                }
            } else if (rights.isEmpty()) {
                for (TreeNode left : lefts) {
                    TreeNode temp = new TreeNode(i);
                    temp.left = left;
                    forThis.add(temp);
                }
            } else if (!lefts.isEmpty() && !rights.isEmpty()) {
                for (TreeNode left : lefts) {
                    for (TreeNode right : rights) {
                        TreeNode temp = new TreeNode(i);
                        temp.left = left;
                        temp.right = right;
                        forThis.add(temp);
                    }
                }
            }

        }
        return forThis;
    }

    public TreeNode addTreeNode(TreeNode insertInto, TreeNode node) {
        if (insertInto.val > node.val) {
            if (insertInto.left == null) {
                return getNewNode(insertInto.val, node, insertInto.right);
            } else {
                return getNewNode(insertInto.val, addTreeNode(insertInto.left, node), insertInto.right);
            }
        } else {
            if (insertInto.right == null) {
                return getNewNode(insertInto.val, insertInto.left, node);
            } else {
                return getNewNode(insertInto.val, insertInto.left, addTreeNode(insertInto.right, node));
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int treeNodes =
                solution.generateTrees(3);

        System.out.println(treeNodes);


    }
}

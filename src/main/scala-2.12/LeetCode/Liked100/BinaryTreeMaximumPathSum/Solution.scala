package LeetCode.Liked100.BinaryTreeMaximumPathSum

/**
  * Created by shanky on 11/6/17.
  */
object Solution {

  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }

  def maxPathSum(root: TreeNode): Int = {
    var maxPathSum = Int.MinValue

    def recur(root: TreeNode): Int = {
      if (root == null) 0
      else {
        var leftMax = recur(root.left)
        var rightMax = recur(root.right)
        maxPathSum = math.max(maxPathSum, leftMax + rightMax + root.value)
        maxPathSum = math.max(maxPathSum, leftMax + root.value)
        maxPathSum = math.max(maxPathSum, rightMax + root.value)
        math.max(leftMax + root.value, rightMax + root.value)
      }
    }

    recur(root)
    maxPathSum
  }

  def main(args: Array[String]): Unit = {

  }
}

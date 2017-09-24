package LeetCode.Weekly46.MaximumWidthofBinaryTree

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def findDepth(root: TreeNode, num: Int): Int = {
    if (root == null) num
    else math.max(findDepth(root.left, num + 1), findDepth(root.right, num + 1))
  }

  def widthOfBinaryTree(root: TreeNode): Int = {
    var width = 0
    val len = findDepth(root, 0)

    var array = Array.ofDim[Int](len + 1)
    for (i <- array.indices) array(i) = -1

    def innerFunc(tempRoot: TreeNode, level: Int, num: Int): Unit = {
      val previousSize = Math.pow(2, level - 1).toInt - 1
      if (tempRoot != null) {
        if (array(level) == -1) array(level) = num
        val tempWidth = num - array(level) + 1
        width = math.max(width, tempWidth)
        innerFunc(tempRoot.left, level + 1, 2 * num)
        innerFunc(tempRoot.right, level + 1, 2 * num + 1)
      }
    }

    innerFunc(root, 1, 1)
    width
  }

  def main(args: Array[String]): Unit = {
    val root = new TreeNode(1)
    root.left = new TreeNode(3)
    root.right = new TreeNode(2)
    //root.left.left = new TreeNode(5)
    //root.left.left.left = new TreeNode(6)
    root.right.right = new TreeNode(9)
    root.right.right.right = new TreeNode(7)
    println(widthOfBinaryTree(root))
  }
}

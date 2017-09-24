package LeetCode.Weekly46.EqualTreePartition

class TreeNode(var _value: Int) {
  var value = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

class UpdatedTree(var _value: Int) {
  var value = _value
  var left: UpdatedTree = null
  var right: UpdatedTree = null
  var sum: Int = 0
}

object Solution {
  def preOrder(root: TreeNode): UpdatedTree = {
    if (root == null) null
    else {
      //First Solving the sub-problems
      val left = preOrder(root.left)
      val right = preOrder(root.right)
      val updatedTree = new UpdatedTree(root.value)
      //Now Solving the main problem
      updatedTree.left = left
      updatedTree.right = right
      //Setting up the sum
      var sum = root.value
      if (left != null) sum += left.sum
      if (right != null) sum += right.sum
      updatedTree.sum = sum
      updatedTree
    }
  }

  def checkEqualTree(root: TreeNode): Boolean = {
    val updatedTree = preOrder(root)
    if (root.left == null && root.right == null) return false

    def mainSum = updatedTree.sum

    if (mainSum % 2 != 0) false
    else {
      def recur(updatedTree: UpdatedTree): Boolean = {
        if (updatedTree == null) false
        else if (mainSum - updatedTree.sum == updatedTree.sum) true
        else recur(updatedTree.left) || recur(updatedTree.right)
      }

      recur(updatedTree)
    }
  }

  def main(args: Array[String]): Unit = {
    val root = new TreeNode(1)
    root.left = new TreeNode(2)
    root.right = new TreeNode(10)
    root.right.left = new TreeNode(2)
    root.right.right = new TreeNode(20)
    println(checkEqualTree(root))
  }
}

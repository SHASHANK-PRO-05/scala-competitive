package LeetCode.Liked100.MaximalRectangle


/**
  * Created by shanky on 11/6/17.
  */
object Solution {

  import java.util

  def maximalRectangle(matrix: Array[Array[Char]]): Int = {
    if (matrix.length == 0) return 0
    var maxLen = 0
    val array = Array.ofDim[Int](matrix(0).length)
    for (row <- matrix) {
      for (j <- row.indices) {
        if (row(j) - '0' == 0)
          array(j) = 0
        else
          array(j) = array(j) + 1
      }
      val stack = new util.Stack[Int]()
      val newRow: Array[Int] = array :+ 0
      for (j <- newRow.indices) {
        while (!stack.isEmpty && newRow(stack.peek()) >= newRow(j)) {
          val peek = newRow(stack.pop())
          val sidX = if (stack.isEmpty) -1 else stack.peek()
          maxLen = math.max(maxLen, (j - sidX - 1) * peek)
        }
        stack.push(j)
      }
    }
    maxLen
  }

  def main(args: Array[String]): Unit = {

  }
}

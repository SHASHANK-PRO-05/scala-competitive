package LeetCode.Liked100.LargestRectangleinHistogram


/**
  * Created by shanky on 11/6/17.
  */
object Solution {

  import java.util

  def largestRectangleArea(heights: Array[Int]): Int = {
    val newHeights = heights :+ 0
    val stack = new util.Stack[Int]()
    var maxHistogram = 0
    for (i <- newHeights.indices) {
      while (!stack.isEmpty && newHeights(stack.peek()) >= newHeights(i)) {
        val top = newHeights(stack.pop())
        val sidX = if (stack.isEmpty) -1 else stack.peek()
        maxHistogram = math.max(maxHistogram, (i - sidX - 1) * top)
      }
      stack.push(i)
    }
    maxHistogram
  }

  def main(args: Array[String]): Unit = {
    println(largestRectangleArea(Array(2, 1, 5, 6, 2, 3)))
  }
}

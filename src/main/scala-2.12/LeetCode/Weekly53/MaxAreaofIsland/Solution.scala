package LeetCode.Weekly53.MaxAreaofIsland

/**
  * Created by shanky on 10/8/17.
  */
object Solution {
  def maxAreaOfIsland(grid: Array[Array[Int]]): Int = {
    val visited = Array.ofDim[Array[Boolean]](grid.length)
    for (i <- visited.indices) {
      visited(i) = Array.ofDim[Boolean](grid(i).length)
    }
    var ans = 0
    for (i <- visited.indices) {
      for (j <- visited(i).indices) {
        if (grid(i)(j) != 0 && !visited(i)(j)) {
          ans = math.max(ans, checkThisOut(grid, visited, i, j))
        }
      }
    }
    ans
  }

  def checkThisOut(grid: Array[Array[Int]], visited: Array[Array[Boolean]], i: Int, j: Int): Int = {
    var thisAns = 1
    visited(i)(j) = true
    if (i > 0 && grid(i - 1)(j) != 0 && !visited(i - 1)(j))
      thisAns += checkThisOut(grid, visited, i - 1, j)
    if (i < grid.length - 1 && grid(i + 1)(j) != 0 && !visited(i + 1)(j))
      thisAns += checkThisOut(grid, visited, i + 1, j)
    if (j > 0 && grid(i)(j - 1) != 0 && !visited(i)(j - 1))
      thisAns += checkThisOut(grid, visited, i, j - 1)
    if (j < grid(i).length - 1 && grid(i)(j + 1) != 0 && !visited(i)(j + 1))
      thisAns += checkThisOut(grid, visited, i, j + 1)
    thisAns
  }

  def main(args: Array[String]): Unit = {
    println(maxAreaOfIsland(Array(Array(1, 1, 0, 0, 0), Array(1, 1, 0, 0, 0), Array(0, 0, 0, 1, 1), Array(0, 0, 0, 1, 1))))
  }
}

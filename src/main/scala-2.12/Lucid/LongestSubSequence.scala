package Lucid

import java.io.PrintWriter
import scala.io.StdIn._

object Solution {
  /**
    * This is the function that will give the desired answer
    * @param grid
    * @return
    */
  def longestSubsequence(grid: Array[Array[Int]]): Int = {
    if (grid.length == 0) return 0
    else {
      /**
        * Basic data collection
        */
      val n = grid.size //size of the rows
      val m = grid(0).size //size of the columns
      var maxAns = Int.MinValue //this will store the ans
      val visited = Array.ofDim[Boolean](n, m) //just to check if element is visited or not
      for (i <- 0 until n) {
        for (j <- 0 until m) {
          maxAns = math.max(maxAns, recur(grid, visited, i, j))
        }
      }
      maxAns
    }
  }

  /**
    * This is recursive function which will visit all non visited adjacent neighbours
    * This is not an optimal solution though dynamic programming is visible here.
    * but have to consider configurations of every array. This is one optimization I can
    * surely think of. We can surely move this thing into stack also as recursion can cause
    * overflow issue. But this is very neat solution and any user can read it and modify it
    * @param grid
    * @param visited
    * @param i
    * @param j
    * @return
    */
  def recur(grid: Array[Array[Int]], visited: Array[Array[Boolean]], i: Int, j: Int): Int = {
    if (visited(i)(j)) return 0
    visited(i)(j) = true
    var thisMax = Int.MinValue
    //Just move to every neighbour
    if (i > 0 && math.abs(grid(i - 1)(j) - grid(i)(j)) > 3)
      thisMax = math.max(thisMax, recur(grid, visited, i - 1, j))
    if (j > 0 && math.abs(grid(i)(j - 1) - grid(i)(j)) > 3)
      thisMax = math.max(thisMax, recur(grid, visited, i, j - 1))
    if (i > 0 && j > 0 && math.abs(grid(i - 1)(j - 1) - grid(i)(j)) > 3)
      thisMax = math.max(thisMax, recur(grid, visited, i, j))
    if (i > 0 && j < grid(i).length - 1 && math.abs(grid(i - 1)(j + 1) - grid(i)(j)) > 3)
      thisMax = math.max(thisMax, recur(grid, visited, i - 1, j + 1))
    if (i < grid.length - 1 && j < grid(i).length - 1 && math.abs(grid(i + 1)(j + 1) - grid(i)(j)) > 3)
      thisMax = math.max(thisMax, recur(grid, visited, i + 1, j + 1))
    if (i < grid.length - 1 && math.abs(grid(i + 1)(j) - grid(i)(j)) > 3)
      thisMax = math.max(thisMax, recur(grid, visited, i + 1, j))
    if (i < grid.length - 1 && j > 0 && math.abs(grid(i + 1)(j - 1) - grid(i)(j)) > 3)
      thisMax = math.max(thisMax, recur(grid, visited, i + 1, j - 1))
    if (j < grid.length - 1 && math.abs(grid(i)(j + 1) - grid(i)(j)) > 3)
      thisMax = math.max(thisMax, recur(grid, visited, i, j + 1))
    visited(i)(j) = false
    thisMax + 1
  }

  def main(args: Array[String]) {
    val Array(numRows, numCols) = readLine.split("\\s+").map(_.toInt);

    val grid = Array.ofDim[Int](numRows, numCols)
    for (row <- 0 until numRows) {
      grid(row) = readLine.split("\\s+").map(_.toInt);
    }

    val res = longestSubsequence(grid)
    println(res)
  }

}

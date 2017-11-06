package LeetCode.Weekly53.NumberofDistinctIslands

import scala.collection.mutable

/**
  * Created by shanky on 10/10/17.
  */
object Solution {
  def numDistinctIslands(grid: Array[Array[Int]]): Int = {
    val n = grid.length
    if (n != 0) {
      val m = grid(0).length
      val visited = Array.ofDim[Boolean](n, m)
      val set = new mutable.HashSet[List[(Int, Int)]]()
      for (i <- 0 until n) {
        for (j <- 0 until m) {
          if (grid(i)(j) == 1 && !visited(i)(j)) {
            var newList: List[(Int, Int)] = List()
            var stack = new mutable.Stack[(Int, Int)]()
            stack.push((i, j))
            while (!stack.isEmpty) {
              var tuple = stack.pop()
              newList = newList :+ (tuple._1 - i, tuple._2 - j)
              visited(tuple._1)(tuple._2) = true
              if (i == 2)
                i
              if (tuple._1 < n - 1 && grid(tuple._1 + 1)(tuple._2) == 1 && !visited(tuple._1 + 1)(tuple._2)) {
                stack.push((tuple._1 + 1, tuple._2))
              }
              if (tuple._2 < m - 1 && grid(tuple._1)(tuple._2 + 1) == 1 && !visited(tuple._1)(tuple._2 + 1))
                stack.push((tuple._1, tuple._2 + 1))
              if (tuple._2 > 0 && grid(tuple._1)(tuple._2 - 1) == 1 && !visited(tuple._1)(tuple._2 - 1))
                stack.push((tuple._1, tuple._2 - 1))
              if (tuple._1 > 0 && grid(tuple._1 - 1)(tuple._2) == 1 && !visited(tuple._1 - 1)(tuple._2))
                stack.push((tuple._1 - 1, tuple._2))
            }
            //println(newList)
            set.add(newList)
          }
        }
      }
      set.size
    } else
      0
  }


  def main(args: Array[String]): Unit = {
    val array = Array(Array(1, 1, 0, 1, 1), Array(1, 0, 0, 0, 0), Array(0, 0, 0, 0, 1), Array(1, 1, 0, 1, 1))
    println(numDistinctIslands(array))
  }
}

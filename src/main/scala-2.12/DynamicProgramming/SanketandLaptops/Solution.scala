package DynamicProgramming.SanketandLaptops

import FastIO.CustomScanner

/**
  * https://www.hackerearth.com/practice/algorithms/dynamic-programming/2-dimensional/practice-problems/algorithm/the-laptops/description/
  */

object Solution {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val t = customScanner.nextInt()
    for (test <- 1 to t) {
      val n = customScanner.nextInt()
      val array = customScanner.nextLine().split(" ").map(_.toInt)
      val sum = array.sum
      val dpArray = Array.ofDim[Boolean](sum + 1)
      dpArray(0) = true
      var ans = 1
      for (a <- array) {
        for (i <- sum to a by -1) {
          if (!dpArray(i) && dpArray(i - a)) {
            ans += 1
            dpArray(i) = true
          }
        }
      }
      println(ans)
    }
  }

}

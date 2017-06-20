package DynamicProgramming.SherlockandDice

import FastIO.CustomScanner

/**
  * https://www.hackerearth.com/practice/algorithms/dynamic-programming/2-dimensional/practice-problems/algorithm/sherlock-and-dice/
  */
object Solution {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val t = customScanner.nextInt()
    for (test <- 1 to t) {
      val m = customScanner.nextInt()
      val n = customScanner.nextInt()
      val k = customScanner.nextInt()
      val memo = Array.ofDim[BigInt](m + 1, k + 1)
      memo(0)(0) = 1L
      var makeValue = 1
      for (i <- 1 to m) {
        makeValue /= n
      }
      for {
        i <- 1 to m
        j <- 1 to n
        l <- k to j by -1
      } {
        if (memo(i)(l) != null && memo(i - 1)(l - j) != null) {
          //println(memo(i)(l) + " " + memo(i - 1)(l - j))
          memo(i)(l) += memo(i - 1)(l - j)
        } else if (memo(i - 1)(l - j) != null) {
          memo(i)(l) = memo(i - 1)(l - j)
        }
      }
      if (memo(m)(k) == null)
        memo(m)(k) = 0
      var ans: BigDecimal = BigDecimal(memo(m)(k))
      //println(ans)
      for (i <- 1 to m) {
        ans = ans / n
      }
      var y = 0
      if (ans != 0)
        while (ans < 1) {
          //println("here")
          y += 1
          ans *= 10
        }
      printf("%.3f %d\n", ans, y)
    }
  }
}

package DynamicProgramming.Terminators

import java.util

import FastIO.CustomScanner

/**
  * Created by shashank on 1/4/17.
  */
object Terminators {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val t = customScanner.nextInt()
    for (test <- 1 to t) {
      val n = customScanner.nextInt()
      val index = Array.ofDim[Int](n + 1)

      val queue = Array.ofDim[Int](n + 1)
      val group = Array.ofDim[util.ArrayList[Int]](n + 1)

      for (i <- 1 to n) {
        val temp = customScanner.nextLine().split(" ").map(_.toInt)
        index(i) = temp(0)
        queue(temp(1)) = i
        group(i) = new util.ArrayList[Int]()
        group(i).add(i)
      }
      var ans = 1
      for (i <- n - 1 to 1 by -1) {
        var j = i + 1
        var tempAns = 0
        while (j <= n) {
          if (index(queue(i)) < index(queue(j))) {
            if (tempAns == 0 || group(queue(tempAns)).size() < group(queue(j)).size()) {
              tempAns = j
            }
          }
          j = j + 1
        }
        if (tempAns > 0) {
          group(queue(i)).addAll(group(queue(tempAns)))
        }
      }

      for (i <- 1 to n) {
        ans = math.max(ans, group(i).size())
      }
      println(ans)
    }
  }
}

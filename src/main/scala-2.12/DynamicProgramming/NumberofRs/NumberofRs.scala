package DynamicProgramming.NumberofRs

import FastIO.CustomScanner

/**
  * Created by shashank on 2/4/17.
  */
object NumberofRs {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val t = customScanner.nextInt()
    for (tests <- 1 to t) {
      val s = customScanner.nextLine()
      val array = Array.ofDim[Int](s.length)
      var sum = Array.ofDim[Int](s.length)
      var cnt = 0
      for (i <- s.indices) {
        if (s.charAt(i) == 'R') {
          array(i) = -1
          cnt += 1
        } else {
          array(i) = 1
        }
      }
      var maxValue = array(0)
      sum(0) = array(0)
      for (i <- 1 until s.length) {
        sum(i) = Math.max(array(i), sum(i - 1) + array(i))
        maxValue = Math.max(maxValue, sum(i))
      }
      println(maxValue + cnt)
    }
  }
}

package DynamicProgramming.LittleDepuAndHisGirlFriend

import FastIO.CustomScanner

/**
  * Created by shashank on 1/4/17.
  */
object LittleDeepuandhisGirlfriend {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val t = customScanner.nextInt()
    for (test <- 1 to t) {
      val m = customScanner.nextInt()
      val n = customScanner.nextInt()
      val array = customScanner.nextLine().split(" ").map(_.toInt)
      val dpArray = Array.ofDim[Boolean](m + 1)
      for (i <- 1 to m) {
        var flag = false
        for (j <- array.indices) {
          if (array(j) <= i && !dpArray(i - array(j))) {
            flag = true
          }
        }
        dpArray(i) = flag
      }
      if (dpArray(m)) {
        println("Little Deepu")
      } else {
        println("Kate")
      }
    }
  }
}

package Trees.Comrades_II

import FastIO.CustomScanner

/**
  * Created by shashank on 7/1/17.
  */
object Comrades_II {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val t = customScanner.nextInt()
    for (test <- 1 to t) {
      val size = customScanner.nextInt()
      val arr = customScanner.nextLine().split(" ").map(_.toInt)
      var ans: Long = size.toLong * (size.toLong - 1L) / 2L
      val map = Array.ofDim[Long](size + 1)
      for (i <- 0 until size) {
        var y = arr(i)
        map(y) += 1L
      }
      val visited = Array.ofDim[Boolean](size + 1)
      for (i <- 1 to size) {
        if (!visited(i)) {
          visited(i) = true
          var childCount = map(i)
          var y = arr(i - 1)
          while (y != 0) {
            
          }
        }
      }
      val handshake: Long = map.sum
      println(handshake + " " + (ans - handshake))
    }
  }


}



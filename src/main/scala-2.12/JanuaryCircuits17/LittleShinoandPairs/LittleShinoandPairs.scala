package JanuaryCircuits17.LittleShinoandPairs

import FastIO.CustomScanner

/**
  * Created by shashank on 22/1/17.
  */
object LittleShinoandPairs {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val n = customScanner.nextInt()
    val arr = customScanner.nextLine().split(" ").map(_.toInt)
  }

  def findAns(n: Int, arr: Array[Int]): Unit = {
    val arrNew: Array[FindExists] = Array.ofDim(n)
    for (i <- 0 until n) {
      if (arrNew(arr(i) - 1) == null)
        arrNew(arr(i) - 1) = new FindExists
      if (i > 0) {

      }
    }
  }
}

class FindExists {
  var first: Boolean = false
  var second: Boolean = false
}

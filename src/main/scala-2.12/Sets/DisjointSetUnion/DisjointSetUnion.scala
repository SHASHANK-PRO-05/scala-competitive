package Sets.DisjointSetUnion

import FastIO.CustomScanner

/**
  * Created by shashank on 22/1/17.
  */
object DisjointSetUnion {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val n = customScanner.nextInt()
    val m = customScanner.nextInt()
    val arr: Array[Set[Int]] = Array.ofDim(n)
    for (i <- 0 until n) {
      arr(i) = Set(i + 1)
    }
    for (graph <- 1 to m) {
      val temp1 = customScanner.nextInt()
      val temp2 = customScanner.nextInt()

    }
  }
}

package AdHoc.MonkandKOperations

import FastIO.CustomScanner

import scala.collection.immutable.Queue
import scala.collection.mutable.ArrayBuffer

/**
  * Created by shashank on 14/1/17.
  */
object MonkandKOperations {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val t = customScanner.nextInt()
    val stringBuilder = new StringBuilder
    for (test <- 1 to t) {
      val n = customScanner.nextInt()
      val k = customScanner.nextInt()
      var arr = customScanner.nextLine().split(" ").map(_.toLong).toBuffer
      for (i <- 0 until k) {
        if (arr.length != 1) {
          if (arr(0) * arr(arr.length - 2) > arr(arr.length - 1) * arr(1)) arr.remove(arr.length - 1)
          else arr.remove(0)
        }
      }
      val ans = arr(0) * arr(arr.length - 1)
      stringBuilder.append(ans + "\n")
    }
    println(stringBuilder)
  }
}

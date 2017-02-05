package JanuaryCircuits17.Transaction

import FastIO.CustomScanner

/**
  * Created by shashank on 28/1/17.
  */
object Transaction {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val size = customScanner.nextInt()
    val queries = customScanner.nextInt()
    val arr = customScanner.nextLine().split(" ").map(_.toLong).sorted
    for (q <- 1 to queries) {
      val m = customScanner.nextLong()
      val n = customScanner.nextInt()
      val pos = bsearch(arr, m)
      if (pos == -1 || pos + n - 1 >= size) println(-1)
      else println(arr(pos + n - 1))
    }
  }

  def bsearch(arr: Array[Long], value: Long): Int = {
    var start = 0
    var pos = -1
    var end = arr.length - 1
    while (start <= end) {
      val mid = (start + end) / 2
      if (arr(mid) >= value) {
        pos = mid
        end = mid - 1
      } else {
        start = mid + 1
      }
    }
    pos
  }
}

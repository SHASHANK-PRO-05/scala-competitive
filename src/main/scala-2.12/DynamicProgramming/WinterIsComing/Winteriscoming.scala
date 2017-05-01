package DynamicProgramming.WinterIsComing

import FastIO.CustomScanner

import scala.collection.mutable

object Winteriscoming {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val t = customScanner.nextInt()
    for (test <- 1 to t) {
      val n = customScanner.nextInt()
      val array = Array.ofDim[Long](n + 1)
      for (iter <- 1 to n) {
        array(iter) = customScanner.nextLong()
      }
      findAns(n, array)
    }
  }

  def findAns(n: Int, array: Array[Long]): Unit = {
    val dpArray = Array.ofDim[Long](n)
    var start: Long = Int.MinValue
    var end: Long = Int.MaxValue
    var map = new mutable.HashMap[Long, Int]()
    map.put(0, 0)
    var elem = 0L
    for (i <- 1 to n) {
      elem += array(i)
      elem %= n
      if (map.contains(elem.toInt)) {
        var startIndex = map.getOrElseUpdate(elem, 0) + 1
        var endIndex = i
        if (endIndex - startIndex < end - start) {
          end = endIndex
          start = startIndex
        }
      }
      map.put(elem, i)
    }
    println((start) + " " + (end))
  }
}

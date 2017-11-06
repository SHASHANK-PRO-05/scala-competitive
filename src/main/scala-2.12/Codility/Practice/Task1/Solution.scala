package Codility.Practice.Task1

/**
  * Created by shanky on 10/4/17.
  */
object Solution {
  def bSearch(a: Array[Int], elem: Int): Int = {
    var start = 0
    var end = a.length - 1
    while (start <= end) {
      val mid = (start + end) / 2
      if (a(mid) == elem) return mid
      else if (a(mid) < elem) {
        start = mid + 1
      } else end = mid - 1
    }
    -1
  }

  def solution(a: Array[Int]): Int = {
    var array = Array.ofDim[Boolean](1000002)
    for (i <- a.indices) {
      if (a(i) > 0)
        array(a(i)) = true
    }
    for (i <- array.indices)
      if (!array(i) && i != 0) return i
    return 0
  }

  def main(args: Array[String]): Unit = {
    println(solution(Array(1, 3, 6, 4, 1, 2)))
  }
}

package LeetCode.Weekly46.ImageSmoother

object Solution {
  def imageSmoother(M: Array[Array[Int]]): Array[Array[Int]] = {
    val m = M.length
    val n = M(0).length
    val array = Array.ofDim[Int](m, n)
    for {
      i <- 0 until m
      j <- 0 until n
    } {
      var num = M(i)(j)
      var denom = 1
      if (i > 0 && j > 0) {
        num += M(i - 1)(j - 1)
        denom += 1
      }
      if (i > 0) {
        num += M(i - 1)(j)
        denom += 1
      }
      if (i > 0 && j < n - 1) {
        num += M(i - 1)(j + 1)
        denom += 1
      }
      if (j > 0) {
        num += M(i)(j - 1)
        denom += 1
      }
      if (j < n - 1) {
        num += M(i)(j + 1)
        denom += 1
      }
      if (i < m - 1 && j > 0) {
        num += M(i + 1)(j - 1)
        denom += 1
      }
      if (i < m - 1) {
        num += M(i + 1)(j)
        denom += 1
      }
      if (i < m - 1 && j < n - 1) {
        num += M(i + 1)(j + 1)
        denom += 1
      }
      array(i)(j) = (num / denom).toInt
    }
    array
  }

  def main(args: Array[String]): Unit = {
    val array = Array(Array(1, 1, 1), Array(1, 0, 1), Array(1, 1, 1))
    println(imageSmoother(array))
  }
}

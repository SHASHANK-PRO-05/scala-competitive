package LeetCode.Random.MaximumLengthofRepeatedSubarray

/**
  * Created by shanky on 11/7/17.
  */
object Solution {
  def findLength(A: Array[Int], B: Array[Int]): Int = {
    var ans = 0
    var array = Array.ofDim[Int](A.length + 1, B.length + 1)
    for (i <- A.indices) {
      for (j <- B.indices) {
        if (A(i) == B(j)) {
          array(i + 1)(j + 1) = array(i)(j) + 1
          ans = math.max(array(i + 1)(j + 1), ans)
        }
      }
    }
    ans
  }

  def main(args: Array[String]): Unit = {
    println(findLength(Array(1, 2, 3, 2, 1), Array(3, 2, 1, 4, 7)))
  }
}

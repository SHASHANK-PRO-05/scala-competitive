package LeetCode.Weekly58.FindPivotIndex

/**
  * Created by shanky on 11/16/17.
  */
object Solution {
  def pivotIndex(nums: Array[Int]): Int = {
    if (nums.length == 0) return -1
    if (nums.length == 1) return 0
    val arrayLeft = Array.ofDim[Int](nums.length)
    val arrayRight = Array.ofDim[Int](nums.length)
    var sum = nums(0);
    arrayLeft(0) = sum
    for (i <- 1 until nums.length) {
      sum += nums(i)
      arrayLeft(i) = sum
    }
    sum = nums(nums.length - 1)
    arrayRight(nums.length - 1) = sum
    for (j <- nums.length - 2 to 0 by -1) {
      sum += nums(j)
      arrayRight(j) = sum
    }
    for (i <- nums.indices) {
      val sumLeft = if (i > 0) arrayLeft(i - 1) else 0
      val sumRight = if (i < nums.length - 1) arrayRight(i + 1) else 0
      if (sumLeft == sumRight) return i
    }
    -1
  }

  def main(args: Array[String]): Unit = {
    println(pivotIndex(Array()))
  }
}

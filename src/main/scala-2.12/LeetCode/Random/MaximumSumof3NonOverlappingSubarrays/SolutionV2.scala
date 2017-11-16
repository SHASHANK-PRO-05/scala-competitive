package LeetCode.Random.MaximumSumof3NonOverlappingSubarrays

/**
  * Created by shanky on 11/8/17.
  */
object fSolutionV2 {
  def maxSumOfThreeSubarrays(nums: Array[Int], k: Int): Array[Int] = {
    var posLeft = Array.ofDim[Int](nums.length)
    var posRight = Array.ofDim[Int](nums.length)
    var sum = 0
    var maxSoFarLeft = 0
    for (i <- nums.indices) {
      if (i >= k) {
        sum = sum + nums(i) - nums(i - k)
        maxSoFarLeft = math.max(maxSoFarLeft, sum)
        posLeft(i) = maxSoFarLeft
      } else if (i == k - 1) {
        sum = sum + nums(i)
        maxSoFarLeft = sum
        posLeft(i) = maxSoFarLeft
      } else {
        sum += nums(i)
      }
    }
    var maxSoFarRight = 0
    sum = 0
    for (i <- nums.indices.reverse) {
      if (i == nums.length - k) {
        sum += nums(i)
        maxSoFarRight = sum
        posRight(i) = maxSoFarRight
      } else if (i < nums.length - k) {
        sum = sum + nums(i) - nums(i + k)
        maxSoFarRight = math.max(maxSoFarRight, sum)
        posRight(i) = maxSoFarRight
      } else {
        sum = sum + nums(i)
      }
    }
    for (i <- k until nums.length - k) {
      println(i)
    }
    posLeft
  }

  def main(args: Array[String]): Unit = {
    println(maxSumOfThreeSubarrays(Array(1, 2, 1, 2, 6, 7, 5, 1), 2))
  }
}

package LeetCode.Random.MaximumSumof3NonOverlappingSubarrays

/**
  * Created by shanky on 11/8/17.
  */
/****************************************
  * This solution loses on memory
  * We have to figure out a better method
  **************************************/
object SolutionV1 {
  def maxSumOfThreeSubarrays(nums: Array[Int], k: Int): Array[Int] = {
    if (nums.length == 0 || k * 3 > nums.length) return null
    val subArraySums = Array.ofDim[Int](nums.length, nums.length)
    val locationOfMaxima = Array.ofDim[Int](nums.length, nums.length)
    var sum = 0
    /** *******************************
      * Filling up the base case first
      * ******************************/
    for (i <- 0 to nums.length) {
      if (i < k) {
        sum += nums(i)
      } else {
        subArraySums(i - k)(i - 1) = sum
        locationOfMaxima(i - k)(i - 1) = i - k
        if (i != nums.length) sum = sum - nums(i - k) + nums(i)
      }
    }
    /** *
      * Setting up the maxima or the dp part
      */
    for (i <- nums.length - k to 0 by -1) {
      for (j <- i + k until nums.length) {
        if (subArraySums(i)(j - 1) >= subArraySums(i + 1)(j)) {
          locationOfMaxima(i)(j) = locationOfMaxima(i)(j - 1)
        } else {
          locationOfMaxima(i)(j) = locationOfMaxima(i + 1)(j)
        }
        subArraySums(i)(j) = math.max(subArraySums(i)(j - 1), subArraySums(i + 1)(j))
      }
    }
    //    locationOfMaxima.foreach(x => println(x.toList))
    //    println("-----------------")
    //    subArraySums.foreach(x => println(x.toList))
    /** *
      * Solving the dynamic programming problem
      */
    var maxAns = 0
    var maxArray: Array[Int] = Array()
    for (i <- k until nums.length - k) {
      if (maxAns < subArraySums(0)(i - 1) + subArraySums(i)(i + k - 1) + subArraySums(i + k)(nums.length - 1)) {
        maxArray = Array(locationOfMaxima(0)(i - 1), locationOfMaxima(i)(i + k - 1), locationOfMaxima(i + k)(nums.length - 1))
      }
      maxAns = math.max(maxAns, subArraySums(0)(i - 1) + subArraySums(i)(i + k - 1) + subArraySums(i + k)(nums.length - 1))
    }
    maxArray
  }

  def main(args: Array[String]): Unit = {
    println(maxSumOfThreeSubarrays(Array(1, 2, 1, 2, 6, 7, 5, 1), 2).toList)
  }
}

package LeetCode.Weekly47.NonDecreasingArray

/**
  * Created by shanky on 8/26/17.
  */
object Solution {
  def checkPossibility(nums: Array[Int]): Boolean = {
    val first = Array.ofDim[Int](nums.size)
    val second = Array.ofDim[Int](nums.size)
    val fifth = Array.ofDim[Int](nums.size)
    val third = Array.ofDim[Int](nums.size)
    val fourth = Array.ofDim[Int](nums.size)

    Array.copy(nums, 0, first, 0, nums.size)
    Array.copy(nums, 0, second, 0, nums.size)
    Array.copy(nums, 0, third, 0, nums.size)
    Array.copy(nums, 0, fourth, 0, nums.size)
    Array.copy(nums, 0, fifth, 0, nums.size)
    checkEqual(first) || checkDecrese(second) || checkIncrease(third) || checkDecreseNeg(fourth) || checkIncreaseNeg(fifth)
  }

  def checkEqual(nums: Array[Int]): Boolean = {
    var doneOnce = false
    var ans = true

    for {
      i <- 1 until nums.length
    } {
      if (nums(i) < nums(i - 1)) {
        if (!doneOnce) {
          doneOnce = true
          nums(i - 1) = nums(i)
        } else {
          ans = false
        }
      }
    }
    for (i <- 1 until nums.length) {
      if (nums(i) < nums(i - 1)) {
        ans = false
      }
    }
    ans
  }

  def checkDecrese(nums: Array[Int]): Boolean = {
    var doneOnce = false
    var ans = true

    for {
      i <- 1 until nums.length
    } {
      if (nums(i) < nums(i - 1)) {
        if (!doneOnce) {
          doneOnce = true
          nums(i - 1) = nums(i) - 1
        } else {
          ans = false
        }
      }
    }
    for (i <- 1 until nums.length) {
      if (nums(i) < nums(i - 1)) {
        ans = false
      }
    }
    ans
  }

  def checkDecreseNeg(nums: Array[Int]): Boolean = {
    //    var doneOnce = false
    //    for {
    //      i <- 1 until nums.length
    //    } {
    //      if (nums(i) < nums(i - 1)) {
    //        if (!doneOnce) {
    //          doneOnce = true
    //          nums(i) = nums(i - 1) - 1
    //        } else {
    //          return false
    //        }
    //      }
    //    }
    //    for (i <- 1 until nums.length) {
    //      if (nums(i) < nums(i - 1)) {
    //        return false
    //      }
    //    }
    false
  }

  def checkIncreaseNeg(nums: Array[Int]): Boolean = {
    var doneOnce = false
    var ans = true
    for {
      i <- 1 until nums.length
    } {
      if (nums(i) < nums(i - 1)) {
        if (!doneOnce) {
          doneOnce = true
          nums(i) = nums(i - 1) + 1
        } else {
          ans = false
        }
      }
    }
    for (i <- 1 until nums.length) {
      if (nums(i) < nums(i - 1)) {
        ans = false
      }
    }
    ans
  }

  def checkIncrease(nums: Array[Int]): Boolean = {
    var doneOnce = false
    var ans = true
    for {
      i <- 1 until nums.length
    } {
      if (nums(i) < nums(i - 1)) {
        if (!doneOnce) {
          doneOnce = true
          nums(i - 1) = nums(i) + 1
        } else {
          ans = false
        }
      }
    }
    for (i <- 1 until nums.length) {
      if (nums(i) < nums(i - 1)) {
        ans = false
      }
    }
    ans
  }


  def main(args: Array[String]): Unit = {
    println(checkPossibility(Array(2, 3, 3, 2, 4)))
  }
}

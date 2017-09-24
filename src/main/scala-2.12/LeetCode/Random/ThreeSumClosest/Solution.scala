package LeetCode.Random.ThreeSumClosest

object Solution {
  def threeSumClosest(nums: Array[Int], target: Int): Int = {
    val size = nums.length
    var ans = Long.MinValue+10
    for {
      i <- nums.indices
      j <- i + 1 until size
      k <- i + 1 to j - 1
    } {
      val num = nums(i) + nums(j) + nums(k)
      if (math.abs(ans - target.toLong).toLong > math.abs(num - target))
        ans = num
    }
    ans.toInt
  }

  def main(args: Array[String]): Unit = {
    val array = Array(0,1,2)
    println(threeSumClosest(array, 0))
  }
}

package LeetCode.Weekly47.PathSumIV

/**
  * Created by shanky on 8/26/17.
  */
object Solution {

  //var finalAns = 0

  def pathSum(nums: Array[Int]): Int = {
    var finalAns = 0
    val array = Array.ofDim[Int](100)
    for {
      i <- array.indices
    } {
      array(i) = -1
    }
    for {
      i <- nums.indices
    } {
      val temp = nums(i).toString
      val d = temp.charAt(0) - '0'
      val p = temp.charAt(1) - '0'
      val v = temp.charAt(2) - '0'
      array((math.pow(2, d - 1) - 1).toInt + (p - 1)) = v
    }

    def check(array: Array[Int], index: Int, temp: Int): Unit = {

      if (array(index * 2 + 1) == -1 && array(index * 2 + 2) == -1) finalAns += temp + array(index)
      else if (array(index * 2 + 1) == -1) check(array, index * 2 + 2, temp + array(index))
      else if (array(index * 2 + 2) == -1) check(array, index * 2 + 1, temp + array(index))
      else {
        check(array, index * 2 + 1, temp + array(index))
        check(array, index * 2 + 2, temp + array(index))
      }
    }

    check(array, 0, 0)
    finalAns
  }


  def main(args: Array[String]): Unit = {
    println(pathSum(Array(113, 213)))
  }
}

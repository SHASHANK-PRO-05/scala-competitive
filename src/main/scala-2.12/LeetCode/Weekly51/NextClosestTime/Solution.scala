package LeetCode.Weekly51.NextClosestTime

/**
  * Created by shanky on 9/23/17.
  */
object Solution {
  def nextClosestTime(time: String): String = {

    val array = Array.ofDim[Int](4)
    val splits = time.split(":")
    array(0) = splits(0)(0) - '0'
    array(1) = splits(0)(1) - '0'
    array(2) = splits(1)(0) - '0'
    array(3) = splits(1)(1) - '0'
    if (array(0) == array(1) && array(0) == array(2) && array(0) == array(3)) {
      return time
    }
    var thisAns = (array(0) * 10 + array(1)) * 60 + (array(2) * 10 + array(3))
    val temp = 24 * 60
    var diff = Long.MaxValue
    var ans = ""
    for (i <- 0 until 4) {
      for (j <- 0 until 4) {
        if ((array(i) * 10 + array(j)) >= 0 && (array(i) * 10 + array(j)) < 24)
          for (k <- 0 until 4) {
            for (l <- 0 until 4) {
              if (array(k) * 10 + array(l) >= 0 && array(k) * 10 + array(l) < 60) {
                var calculate = (array(i) * 10 + array(j)) * 60 + (array(k) * 10 + array(l))

                if (calculate < thisAns) {
                  calculate += temp
                }
                if (diff > calculate - thisAns && calculate - thisAns != 0) {
                  diff = calculate - thisAns
                  ans = array(i).toString + array(j).toString + ":" + array(k).toString + array(l).toString
                }
              }
            }
          }
      }
    }
    ans
  }

  def main(args: Array[String]): Unit = {
    println(nextClosestTime("11:11"))
  }
}

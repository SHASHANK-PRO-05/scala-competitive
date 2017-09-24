package LeetCode.Weekly51.BaseballGame

/**
  * Created by shanky on 9/23/17.
  */
object Solution {
  def calPoints(ops: Array[String]): Int = {
    var ans = 0l
    val prevData = Array.ofDim[Long](ops.length)
    var temp = 0
    for (i <- ops.indices) {
      ops(i) match {
        case "D" => {
          if (temp > 0) prevData(temp) = 2 * prevData(temp - 1)
          else prevData(temp) = 0
          temp += 1
        }
        case "+" => {
          if (temp > 1) prevData(temp) = prevData(temp - 1) + prevData(temp - 2)
          else if (temp > 0) prevData(temp) = prevData(temp - 1)
          else prevData(temp) = 0
          temp += 1
        }
        case "C" => {
          if (temp > 0)
            temp = temp - 1
        }
        case _ => {
          prevData(temp) = ops(i).toLong
          temp += 1
        }
      }
    }
    for (i <- 0 until temp) {
      ans += prevData(i)
    }
    ans.toInt
  }

  def main(args: Array[String]): Unit = {
    val array = Array("5","-2","4","C","D","9","+","+")
    println(calPoints(array))
  }
}

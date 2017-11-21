package LeetCode.Weekly59.SelfDividingNumbers

/**
  * Created by shanky on 11/18/17.
  */
object Solution {
  def isSelfDividing(number: Int): Boolean = {
    var tempNumber = number
    while (tempNumber != 0) {
      val thisNum = tempNumber % 10
      if (thisNum == 0 || number % thisNum != 0) return false
      tempNumber = tempNumber / 10
    }
    true
  }

  def selfDividingNumbers(left: Int, right: Int): List[Int] = {
    var ansList: List[Int] = List()
    for (i <- left to right) {
      if (isSelfDividing(i)) ansList = ansList :+ i
    }
    ansList
  }

  def main(args: Array[String]): Unit = {
    println(selfDividingNumbers(1, 10000))
  }
}

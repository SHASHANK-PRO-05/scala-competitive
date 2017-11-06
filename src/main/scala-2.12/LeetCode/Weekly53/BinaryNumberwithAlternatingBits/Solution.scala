package LeetCode.Weekly53.BinaryNumberwithAlternatingBits

import scala.collection.mutable

/**
  * Created by shanky on 10/8/17.
  */
object Solution {
  val map = new mutable.HashMap[Int, Boolean]()

  def hasAlternatingBits(num: Int): Boolean = {
    if (num == 0 || num == 1) return true

    def check(num: Int, prev: Int): Boolean = {
      if (num == 0 || num == 1) {
        if (prev == num) {
          map.put(num, false)
          return false
        }
        else return true
      }
      else if (num % 2 == prev) {
        map.put(num, false)
        return false;
      } else {
        map.put(num, check(num / 2, num % 2))
        return map.getOrElse(num, true)
      }
    }

    map.put(num, check(num / 2, num % 2))
    map.getOrElse(num, true)
  }


  def main(args: Array[String]): Unit = {
    println(hasAlternatingBits(4))
    println(hasAlternatingBits(5))
  }

}

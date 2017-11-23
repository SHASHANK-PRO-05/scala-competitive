package LeetCode.Weekly59.MyCalendarII

import java.util

/**
  * Created by shanky on 11/20/17.
  */
class Solution {
  val list = new util.ArrayList[(Int, Int)]()
  val overlapList = new MyCalender

  def book(start: Int, end: Int): Boolean = {
    for (it <- 0 until list.size()) {
      if (math.max(list.get(it)._1, start) < math.min(list.get(it)._2, end)) {
        if (!overlapList.book(math.max(list.get(it)._1, start), math.min(list.get(it)._2, end))) return false
      }
    }
    list.add((start, end))
    true
  }

  class MyCalender {
    val list = new util.ArrayList[(Int, Int)]()

    def book(start: Int, end: Int): Boolean = {
      for (it <- 0 until list.size()) {
        if (math.max(list.get(it)._1, start) < math.min(list.get(it)._2, end)) return false
      }
      list.add((start, end))
    }
  }

}

object Solution {
  def main(args: Array[String]): Unit = {

  }
}

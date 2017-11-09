package LeetCode.Random.FrogJump


/**
  * Created by shanky on 11/7/17.
  */
object Solution {

  import java.util

  import scala.collection.mutable

  def main(args: Array[String]): Unit = {
    println(canCross(Array(0, 1, 3, 6, 10, 15, 19, 21, 24, 26, 30, 33)))
  }

  def canCross(stones: Array[Int]): Boolean = {
    if (stones.length == 0) return true
    val maxValue = stones(stones.length - 1)
    val stoneSet = stones.map(_.toLong).toSet
    var set = new mutable.HashSet[(Long, Int)]()
    var ans = new mutable.HashSet[Long]()
    ans.add(stones(0))
    val stack = new util.Stack[(Long, Int)]()
    stack.push((stones(0), 0))
    while (!stack.isEmpty) {
      val top = stack.pop()
      println(top)
      println("----------------------")
      if (top._1 + top._2 - 1 <= maxValue) {
        if (top._2 - 1 > 0 && stoneSet.contains(top._1 + (top._2 - 1)) && !set.contains((top._1 + (top._2 - 1), top._2 - 1))) {
          set.add((top._1 + (top._2 - 1), top._2 - 1))
          ans.add(top._1 + (top._2 - 1))
          stack.push((top._1 + (top._2 - 1), top._2 - 1))
          println(stack.peek())
        }
        if (top._2 != 0 && stoneSet.contains(top._1 + top._2) && !set.contains((top._1 + top._2, top._2))) {
          set.add((top._1 + top._2, top._2))
          ans.add(top._1 + top._2)
          stack.push((top._1 + top._2, top._2))
          println(stack.peek())
        }
        if (stoneSet.contains(top._1 + (top._2 + 1)) && !set.contains((top._1 + (top._2 + 1), top._2 + 1))) {
          set.add((top._1 + (top._2 + 1), top._2 + 1))
          ans.add(top._1 + (top._2 + 1))
          stack.push((top._1 + (top._2 + 1), top._2 + 1))
          println(stack.peek())
        }
      }
      println("**************88")
    }
    ans.contains(maxValue)
  }

}

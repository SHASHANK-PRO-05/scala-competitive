package LeetCode.Weekly45.JudgeRouteCircle

/**
  * Created by shanky on 8/18/17.
  */
object Solution {
  def judgeCircle(moves: String): Boolean = {
    var x = 0
    var y = 0
    for (i <- moves) {
      i match {
        case 'L' => x = x - 1
        case 'R' => x = x + 1
        case 'U' => y += 1
        case 'D' => y -= 1
      }
    }
    if (x == 0 && y == 0) true else false
  }

  def main(args: Array[String]): Unit = {
    println(judgeCircle("UUDDUDLR"))
  }

}

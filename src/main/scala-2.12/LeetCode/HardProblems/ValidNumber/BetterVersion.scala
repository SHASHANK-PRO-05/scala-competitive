package LeetCode.HardProblems.ValidNumber

/**
  * Created by shanky on 11/23/17.
  */
object BetterVersion {
  def isNumber(s: String): Boolean = s.trim.matches("[-+]?(([0-9]+([.][0-9]*)?)|[.][0-9]+)(e[-+]?[0-9]+)?")

  //  def isNumber(s: String): Boolean = s.trim.matches("[+-]?(([0-9]+(.[0-9]*)?)|(.[0-9]+))e[0-9]+") ||
  //    s.trim.matches("[+-]?(([0-9]+(.[0-9]*)?)|(.[0-9]+))")

  def main(args: Array[String]): Unit = {
    println(isNumber("0.9"))
  }
}

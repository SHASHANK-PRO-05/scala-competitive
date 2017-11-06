package LeetCode.Random.RegularExpressionMatching

/**
  * Created by shanky on 10/30/17.
  */
object Solution {
  def isMatch(s: String, p: String): Boolean = {
    if (s.length == 0 || p.length == 0) return false
    val dp = Array.ofDim[Boolean](s.length + 1, p.length + 1)
    dp(0)(0) = true
    for (i <- p.indices) {
      if (p.charAt(i) == '*' && dp(0)(i - 1)) {
        dp(0)(i + 1) = true
      }
    }
    println(dp(0).toList)
    true
  }

  def main(args: Array[String]): Unit = {
    isMatch("aab", "c*a*b")
  }
}

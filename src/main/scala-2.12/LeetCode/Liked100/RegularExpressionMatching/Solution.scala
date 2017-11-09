package LeetCode.Liked100.RegularExpressionMatching

/**
  * Created by shanky on 11/5/17.
  */
object Solution {
  def isMatch(s: String, p: String): Boolean = {
    val dp = Array.ofDim[Boolean](s.length + 1, p.length + 1)
    dp(0)(0) = true
    for (i <- p.indices) {
      if (p.charAt(i) == '*') {
        dp(0)(i + 1) = dp(0)(i - 1)
      }
    }
    for (i <- s.indices) {
      for (j <- p.indices) {
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
          dp(i + 1)(j + 1) = dp(i)(j)
        } else if (p.charAt(j) == '*') {
          if (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
            dp(i + 1)(j + 1) = dp(i)(j + 1) || dp(i + 1)(j) || dp(i + 1)(j - 1)
          } else {
            dp(i + 1)(j + 1) = dp(i + 1)(j - 1)
          }
        }
      }
    }
    dp(s.length)(p.length)
  }

  def main(args: Array[String]): Unit = {
    println(isMatch("aaabbbccc","a*b*c*"))
  }
}

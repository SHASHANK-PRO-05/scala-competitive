package LeetCode.Random.PalindromicSubstrings

/**
  * Created by shanky on 11/22/17.
  */
object Solution {
  def longestPalindrome(temp: String): String = {
    val s = new StringBuilder(temp)
    val isPallindrom = Array.ofDim[Boolean](s.length, s.length)
    var ans = ""
    for (i <- s.indices) {
      isPallindrom(i)(i) = true
      ans = s.charAt(i) + ""
    }
    for (i <- s.length - 1 to 0 by -1) {
      for (j <- i + 1 until s.length) {
        if (s.charAt(i) == s.charAt(j)) {
          if (j == i + 1) {
            if (ans.length < s.substring(i, j + 1).length)
              ans = s.substring(i, j + 1).toString
            isPallindrom(i)(j) = true
          } else if (isPallindrom(i + 1)(j - 1)) {
            if (ans.length < s.substring(i, j + 1).length)
              ans = s.substring(i, j + 1).toString
            isPallindrom(i)(j) = true
          }
        }
      }
    }
    ans
  }

  def main(args: Array[String]): Unit = {
    println(longestPalindrome("a"))
  }
}

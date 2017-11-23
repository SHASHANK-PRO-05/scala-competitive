package LeetCode.Random.LongestPalindromicSubstring

/**
  * Created by shanky on 11/21/17.
  */
object Solution {
  def countSubstrings(s: String): Int = {
    val isPallindrom = Array.ofDim[Boolean](s.length, s.length)
    var ans = s.length
    for (i <- s.indices) {
      isPallindrom(i)(i) = true
    }
    for (i <- s.length - 1 to 0 by -1) {
      for (j <- i + 1 until s.length) {
        if (s.charAt(i) == s.charAt(j)) {
          if (j == i + 1) {
            ans += 1
            isPallindrom(i)(j) = true
          } else if (isPallindrom(i + 1)(j - 1)) {
            ans += 1
            isPallindrom(i)(j) = true
          }
        }
      }
    }
    ans
  }

  def main(args: Array[String]): Unit = {
    println(countSubstrings(""))
    println(-12 / 10)
  }
}

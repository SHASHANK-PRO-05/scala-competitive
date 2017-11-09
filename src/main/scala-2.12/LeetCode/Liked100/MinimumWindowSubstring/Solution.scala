package LeetCode.Liked100.MinimumWindowSubstring

/**
  * Created by shanky on 11/5/17.
  */
object Solution {
  def minWindow(s: String, t: String): String = {
    val countCheck = Array.ofDim[Int](256)
    val required = Array.ofDim[Boolean](256)
    var count = 0
    for (char <- t) {
      countCheck(char) += 1
      required(char) = true
      count += 1
    }

    var start = 0
    var end = -1
    var subStringStart: Long = 0
    var subStringEnd: Long = Int.MaxValue
    while (start < s.length && end < s.length) {
      if (count != 0) {
        end = end + 1
        if (end != s.length)
          countCheck(s.charAt(end)) = countCheck(s.charAt(end)) - 1
        if (end != s.length && required(s.charAt(end)) && countCheck(s.charAt(end)) >= 0)
          count = count - 1
      } else {
        if ((subStringEnd - subStringStart + 1) > (end - start + 1)) {
          subStringEnd = end
          subStringStart = start
        }
        countCheck(s.charAt(start)) = countCheck(s.charAt(start)) + 1
        if (required(s.charAt(start)) && countCheck(s.charAt(start)) > 0)
          count += 1
        start += 1
      }
    }
    s.substring(subStringStart.toInt, subStringEnd.toInt + 1)
  }

  def main(args: Array[String]): Unit = {
    println(minWindow("ADOBECODEBANC", "ABC"))
  }
}

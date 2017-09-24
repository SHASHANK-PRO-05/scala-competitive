package LeetCode.Weekly46.StrangePrinter

/**
  * Created by shanky on 8/20/17.
  */
object Solution {
  def strangePrinter(s: String): Int = {
    val n = s.length
    if (n == 0) 0
    else {
      val dp = Array.ofDim[Int](n + 1, n + 1)
      for (i <- 0 until n) dp(i)(i) = 1
      for {
        i <- 1 until n
        j <- 0 until n - i
      } {
        dp(j)(j + i) = i + 1
        for (k <- j + 1 to j + i) {
          var temp = dp(j)(k - 1) + dp(k)(j + i)
          if (s.charAt(k - 1) == s.charAt(j + i)) temp -= 1
          dp(j)(j + i) = math.min(dp(j)(j + i), temp)
        }
      }
      dp(0)(n - 1)
    }

  }

  def main(args: Array[String]): Unit = {
    print(strangePrinter("aabab"))
  }
}

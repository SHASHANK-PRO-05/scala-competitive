package Hashing.MonkandStringSearch

import FastIO.CustomScanner

/**
  * Created by shashank on 11/1/17.
  */
object MonkandStringSearch {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val n = customScanner.nextInt()
    var ans = "";
    //println(lcs("cdab", "bcd"))
    var i = 0L
    while (i != n) {
      ans = customScanner.next()
      if (i != 0)
        ans = lcs(ans, customScanner.next())
      i = i + 1L
    }
    println(ans.length)
  }

  def lcs(string1: String, string2: String): String = {
    val arr = Array.ofDim[Long](string1.length + 1, string2.length + 1)
    var ans = 0L
    var returnString = ""
    for (i <- 0 to string1.length) {
      for (j <- 0 to string2.length) {
        if (i == 0 || j == 0) arr(i)(j) = 0
        else if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
          //println("here")
          arr(i)(j) = arr(i - 1)(j - 1) + 1
          if (ans < arr(i)(j)) {
            returnString = string2.substring(j - ans.toInt - 1, j)
            ans = arr(i)(j)
          }
        } else arr(i)(j) = 0
      }
    }
    returnString
  }
}

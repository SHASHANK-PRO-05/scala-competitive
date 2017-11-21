package LeetCode.Weekly59.CountDifferentPalindromicSubsequences

import java.util

/**
  * Created by shanky on 11/18/17.
  */
object Solution {
  val div = 1000000007

  def countPalindromicSubsequences(S: String): Int = {
    val treeSet = Array.ofDim[util.TreeSet[Int]](26)
    for (i <- 0 until 26) treeSet(i) = new util.TreeSet[Int]()
    for (i <- S.indices) treeSet(S.charAt(i) - 'a').add(i)
    val memo = Array.ofDim[Int](S.length + 1, S.length + 1)
    recur(0, S.length, treeSet, memo)
  }

  def recur(start: Int, end: Int, treeSet: Array[util.TreeSet[Int]], memo: Array[Array[Int]]): Int = {
    if (start >= end) return 0
    if (memo(start)(end) != 0) return memo(start)(end)
    var ans = 0
    for (i <- treeSet.indices) {
      if (treeSet(i).size != 0) {
        val tempStart: Int = treeSet(i).ceiling(start)
        val tempEnd = treeSet(i).lower(end)
        if (tempStart != null && tempStart < end && tempEnd >= start) {
          ans = ans + 1
          ans = ans % div
          if (tempStart != tempEnd) ans += 1
          ans += recur(tempStart + 1, tempEnd, treeSet, memo)
          ans = ans % div
        }
      }
    }
    memo(start)(end) = ans
    ans
  }

  def main(args: Array[String]): Unit = {
    println(countPalindromicSubsequences("abbb"))
  }
}

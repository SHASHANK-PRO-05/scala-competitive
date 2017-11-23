package LeetCode.Random.LongestPalindromicSubsequence

import scala.collection.mutable

/**
  * Created by shanky on 11/21/17.
  */
object Solution {
  def longestPalindromeSubseq(s: String): Int = {
    val map = new mutable.HashMap[Int, java.util.TreeSet[Int]]()
    val memo = Array.ofDim[Int](s.length + 1, s.length + 1)
    for (i <- s.indices) {
      val place = s.charAt(i) - 'a'
      val treeSet = map.getOrElse(place, new java.util.TreeSet[Int]())
      treeSet.add(i)
      map.put(place, treeSet)
    }
    locationMax(map, 0, s.length, memo)
  }

  def locationMax(map: mutable.HashMap[Int, java.util.TreeSet[Int]], start: Int, end: Int, memo: Array[Array[Int]]): Int = {
    if (start >= end) return 0
    if (memo(start)(end) != 0) return memo(start)(end)
    var ansMax = Int.MinValue
    for ((key, element) <- map) {
      var thisAns = 0
      val newStart = element.ceiling(start)
      val newEnd = element.lower(end)
      if (newStart < end && newEnd >= start) {
        thisAns += 1
        if (newStart != newEnd) {
          thisAns += 1
          thisAns += locationMax(map, newStart + 1, newEnd, memo)
        }
      }
      ansMax = math.max(ansMax, thisAns)
    }
    memo(start)(end) = ansMax
    ansMax
  }

  def main(args: Array[String]): Unit = {
    println(longestPalindromeSubseq("bbbabbaaabbbbbbbaaaaabbbccccccbabccccccc"))
  }
}

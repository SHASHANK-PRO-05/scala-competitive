package LeetCode.Weekly57.LongestWordinDictionary

/**
  * Created by shanky on 11/4/17.
  */
object Solution {


  def longestWord(words: Array[String]): String = {
    val set = words.toSet[String]
    val newWords = words.sortWith((s1, s2) => {
      if (s1.length > s2.length) true
      else if (s1.length < s2.length) false
      else if (s1 < s2) true
      else if (s1 > s2) false
      else false
    })
    for (word <- newWords) {
      val stringBuilder = new StringBuilder(word)
      var tempAns = true
      for (j <- stringBuilder.indices) if (!set.contains(stringBuilder.substring(0, j + 1))) tempAns = false
      if (tempAns)
        return word
    }
    ""
  }


  def main(args: Array[String]): Unit = {
    println(longestWord(List("a", "banana", "app", "appl", "ap", "apply", "apple").toArray))
  }
}

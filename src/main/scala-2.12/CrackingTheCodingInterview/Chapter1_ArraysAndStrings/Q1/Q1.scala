package CrackingTheCodingInterview.Chapter1_ArraysAndStrings.Q1

/**
  * Created by Shashank on 5/2/17.
  * This class is will help in finding whether the given string
  * has unique characters or not.
  */

class UniqueString(private val string: String) {

  /**
    * This function checks the string is unique by running a brute
    *
    * force of O(n^2^)
    *
    * @return boolean
    */
  def checkBruteForce(): Boolean = {
    for (i <- 0 until string.length) {
      for (j <- i + 1 until string.length) {
        if (string.charAt(i) == string.charAt(j))
          return false
      }
    }
    true
  }

  /**
    * This function is will run with O(n) but asks for a higher
    * space complexity
    *
    * @return Boolean
    */
  def checkWithAdditionalDataStructure(): Boolean = {
    val array = Array.ofDim[Int](Char.MaxValue + 1)
    for (i <- 0 until string.length) {
      if (array(string.charAt(i)) != 0) {
        return false
      }
      array(string.charAt(i)) += 1
    }
    true
  }

  def tradeOff(): Boolean = {
    val newString = string.sorted
    for (i <- 0 until newString.length) {
      if ((i > 0 && newString.charAt(i) == newString.charAt(i - 1))
        || (i < newString.length - 1 && newString.charAt(i) == newString.charAt(i + 1))) {
        return false
      }
    }
    true
  }

  /**
    * This only checks a to z or A to z or 0-9 characters
    *
    * @return Boolean
    */
  def checkOnlyA_ZOra_zOr0_9(): Boolean = {
    var uniqueChecker = 0
    for (i <- 0 until string.length) {
      if ((uniqueChecker >> string.charAt(i) - 'A' & 1) != 0) {
        return false
      }
      uniqueChecker = uniqueChecker | (1 << string.charAt(i) - 'A')
    }
    true
  }

  /**
    * This area is bug prone
    *
    * @return
    */
  def anythingFromBitWiseArrayOf4(): Boolean = {
    val arrayChecker: Array[Long] = Array(0L, 0L, 0L, 0L)
    for (i <- 0 until string.length) {
      var char = string.charAt(i)
      var index = 0
      println(1L << 62)
      while (char - 62 > 0) {
        char = (char - 62).toChar
      }
      if ((arrayChecker(index) & (1 << char - 0)) != 0) {
        return false
      }
      arrayChecker(index) = arrayChecker(index) | (1 << char - 0)
    }
    true
  }

}

/**
  * Sample Run for the question
  */
object Q1 {
  def main(args: Array[String]): Unit = {
    println(new UniqueString("44").tradeOff())
    println(new UniqueString("132").checkBruteForce())
    println(new UniqueString("112").checkWithAdditionalDataStructure())
  }
}

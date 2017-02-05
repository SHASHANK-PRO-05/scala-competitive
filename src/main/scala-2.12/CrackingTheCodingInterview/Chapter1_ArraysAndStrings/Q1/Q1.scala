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

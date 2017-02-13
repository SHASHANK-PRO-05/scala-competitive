package CrackingTheCodingInterview.GroupPractice.Day2

/**
  * Created by shashank on 13/2/17.
  */
object MagicBox {
  def main(args: Array[String]): Unit = {
    val temp = oddMagicBox(999)
    for (i <- 0 until 999) {
      for (j <- 0 until 999) {
        print(temp(i)(j) + " ")
      }
      println()
    }
  }

  def oddMagicBox(n: Int): Array[Array[Long]] = {
    if (n > 1000) {
      println("Please read about maximum array size in a language and Big-O notation")
      return null
    }
    val array = Array.ofDim[Long](n, n)
    var iter1 = 0
    var iter2 = n / 2
    var num = 1
    while (num <= n * n) {
      if (array(iter1)(iter2) != 0) {
        iter1 = (iter1 + 2) % n
        iter2 = ((iter2 - 1) + n) % n
      }
      array(iter1)(iter2) = num
      iter1 = ((iter1 - 1) + n) % n
      iter2 = (iter2 + 1) % n
      num += 1
    }
    array
  }
}

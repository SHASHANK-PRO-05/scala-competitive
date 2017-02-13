package CrackingTheCodingInterview.GroupPractice.Day2

/**
  * Created by shashank on 13/2/17.
  */
object MagicBox {
  def main(args: Array[String]): Unit = {
    val temp = fourNType(8)
    for (i <- 0 until 8) {
      for (j <- 0 until 8) {
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

  def fourNType(n: Int): Array[Array[Long]] = {
    if (n > 1000) {
      println("Please read about maximum array size in a language and Big-O notation")
      return null
    }
    var num = 1L
    var num2 = n * n
    val straight = Array.ofDim[Long](n, n)
    val reverse = Array.ofDim[Long](n, n)
    val actual = Array.ofDim[Long](n, n)
    for (i <- 0 until n) {
      for (j <- 0 until n) {
        straight(i)(j) = num
        num += 1
        reverse(i)(j) = num2
        num2 -= 1
      }
    }
    for {
      squareNumber1 <- 0 until n / 4
      squareNumber2 <- 0 until n / 4
      i <- 0 until 4
      j <- 0 until 4} {
      if (i == j || i == 4 - j - 1) {
        actual(squareNumber1 * 4 + i)(squareNumber2 * 4 + j) = straight(squareNumber1 * 4 + i)(squareNumber2 * 4 + j)
      }else{
        actual(squareNumber1 * 4 + i)(squareNumber2 * 4 + j) = reverse(squareNumber1 * 4 + i)(squareNumber2 * 4 + j)
      }
    }
    actual
  }
}

package CrackingTheCodingInterview.GroupPractice.Day2

/**
  * Created by shashank on 13/2/17.
  */
object MagicBox {
  def main(args: Array[String]): Unit = {
    val temp = fourNPlus2Type(10)
    for (i <- 0 until 10) {
      for (j <- 0 until 10) {
        if (temp(i)(j) < 10)
          print("0" + temp(i)(j) + " ")
        else
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
      } else {
        actual(squareNumber1 * 4 + i)(squareNumber2 * 4 + j) = reverse(squareNumber1 * 4 + i)(squareNumber2 * 4 + j)
      }
    }
    actual
  }

  def fourNPlus2Type(n: Int): Array[Array[Long]] = {
    if (n > 1000) {
      println("Please read about maximum array size in a language and Big-O notation")
      return null
    }
    val array = Array.ofDim[Long](n, n)
    for {
      i <- 0 until 2
      j <- 0 until 2
    } {
      var num = 0
      if (i == 0 && j == 0) num = 1
      else if (i == 1 && j == 1) num = (n / 2) * (n / 2) + 1
      else if (i == 0 && j == 1) num = n * n / 2 + 1
      else if (i == 1 && j == 0) num = 3 * (n * n / 4) + 1
      var length = n / 2
      var iter1 = 0
      var iter2: Int = length / 2
      val temp = num
      while (num < temp + (n * n) / 4) {
        if (array(i * length + iter1)(j * length + iter2) != 0) {
          iter1 = (iter1 + 2) % length
          iter2 = ((iter2 - 1) + length) % length
        }
        array(i * length + iter1)(j * length + iter2) = num
        num += 1
        iter1 = ((iter1 - 1) + length) % length
        iter2 = (iter2 + 1) % length
      }
    }
    //exchanging n/2,n/2 with 3n/4,n/2
    println(array(n / 2 / 2)(n / 2 / 2) + " " + array(3 * n / 4)(n / 2 / 2))
    var dummy = array(n / 2 / 2)(n / 2 / 2)
    array(n / 2 / 2)(n / 2 / 2) = array(3 * n / 4)(n / 2 / 2)
    array(3 * n / 4)(n / 2 / 2) = dummy

    //swapping till n/2/2-2
    for (i <- 0 to n / 2 / 2 - 1) {
      for (j <- 0 until n / 2) {
        if (i == n / 2 / 2 - 1 && j == n / 2 / 2) {} else {
          //println(i + " " + j + " " + (j + n / 2))
          dummy = array(j)(i)
          array(j)(i) = array(j + n / 2)(i)
          //array(j)(i) = array(j)(i + n / 2)
          array(j + n / 2)(i) = dummy
        }
      }
    }
    for (i <- 0 to n / 2 / 2 - 2) {
      for (j <- 0 until n / 2) {
        dummy = array(j)(n - 1 - i)
        array(j)(n - 1 - i) = array(j + n / 2)(n - 1 - i)
        array(j + n / 2)(n - 1 - i) = dummy
      }
    }
    array
  }
}

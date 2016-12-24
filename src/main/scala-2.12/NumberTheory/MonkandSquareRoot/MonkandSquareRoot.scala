package NumberTheory.MonkandSquareRoot

import FastIO.CustomScanner

/**
  * Created by home on 12/24/2016.
  */
object MonkandSquareRoot {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val t = customScanner.nextInt()
    val output = new StringBuilder
    for (testCase <- 1 to t) {
      var n: Long = customScanner.nextLong()
      var m: Long = customScanner.nextLong()
      n = n % m
      output.append(findReverseQuadraticResidue(n, m) + "\n")
    }
    println(output)
    customScanner.close()
  }

  def findReverseQuadraticResidue(n: Long, m: Long): Long = {
    if (n > m * m / 2) -1
    else if (checkPerfectSquare(n)) math.sqrt(n).toLong
    else findReverseQuadraticResidue(n + m, m)
  }

  def checkPerfectSquare(n: Long): Boolean = {
    if (math.pow(math.sqrt(n).toLong, 2).toLong == n) true else false
  }
}

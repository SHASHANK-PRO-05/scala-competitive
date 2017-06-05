package CollectingApples

import FastIO.CustomScanner

object Solution {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val t = customScanner.nextInt()
    for (tests <- 1 to t) {
      var (n, p) = (customScanner.nextInt(), customScanner.nextLong())
      val milkQuant = customScanner.nextLine().split(" ").map(_.toInt)
      val apples = customScanner.nextLine().split(" ").map(_.toInt)
      var power = 0
      if (p > n) power = n
      else power = p.toInt
      val array = Array.ofDim[Long](n + 1, n)
      for (i <- 1 to n) {
        array(i)(n - 1) = apples(n - 1)
      }
      for {
        i <- n - 2 to 0 by -1
        j <- 1 to n
      } {
        var temp = j + milkQuant(i) - 1
        if (temp > n) temp = n
        array(j)(i) = math.max(apples(i) + array(j - 1)(i + 1), array(temp)(i + 1))
      }
      println(array(power)(0))
    }
  }

}

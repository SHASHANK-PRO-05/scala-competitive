package AccelHack.MonkandATM

import FastIO.CustomScanner


/**
  * Created by shashank on 7/4/17.
  */
object MonkandATM {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val dpArray = Array.ofDim[Boolean](10000001)
    dpArray(1) = true
    var temp = 2
    while (temp < 10000001) {
      dpArray(temp) = true
      temp = temp * 2
    }
    val count = Array.ofDim[Int](10000001)
    for (i <- 1 to 10000000) {
      count(i) = count(i) + 1
      var j = 2 * i
      while (j < 10000001) {
        count(j) = count(j) + 1
        j = j + i
      }
    }
    val t = customScanner.nextInt()
    for (tests <- 1 to t) {
      val n = customScanner.nextInt()
      var ans = 0
      for (i <- 1 to Math.sqrt(n).toInt) {
        if (n % i == 0 && dpArray(count(i))) {
          ans = math.max(ans, count(i))
        }
        if (n % math.ceil(n / i).toInt == 0 && dpArray(count(math.ceil(n / i).toInt))) {
          ans = math.max(count(math.ceil(n / i).toInt), ans)
        }
      }
      println(ans)
    }
  }
}

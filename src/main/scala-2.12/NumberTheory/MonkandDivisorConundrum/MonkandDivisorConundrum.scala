package NumberTheory.MonkandDivisorConundrum

import java.io.PrintWriter

import FastIO.CustomScanner

/**
  * Created by home on 12/24/2016.
  */
object MonkandDivisorConundrum {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    //val printWriter = new PrintWriter("Conundrum.txt")
    var stringBuilder = new StringBuilder
    val size = customScanner.nextInt()
    val arr = new Array[Int](size)
    var max: Int = Integer.MIN_VALUE
    for (i <- 0 to size - 1) {
      arr(i) = customScanner.nextInt()
      max = Math.max(max, arr(i))
    }
    val queryArray = findMonkandDivisorConundrumBase(arr, max, size)
    val q = customScanner.nextInt()
    //    for (i <- 0 to queryArray.size - 1) {
    //      print(queryArray(i) + " ");
    //    }
    for (i <- 1 to q) {
      val p = customScanner.nextInt()
      val q = customScanner.nextInt()
      stringBuilder.append(findAns(p.toLong, q.toLong, queryArray) + "\n")
    }
    println(stringBuilder)
    //printWriter.flush()
    //printWriter.close()
    customScanner.close()
  }

  def gcd(p: Long, q: Long): Long = {
    if (q == 0) p else gcd(q, p % q)
  }

  def findAns(p: Long, q: Long, newArr: Array[Int]): Int = {
    val gcdPQ = gcd(p, q)
    var ans = 0
    if (p < newArr.size.toLong) ans += newArr(p.toInt)
    if (q < newArr.size.toLong) ans += newArr(q.toInt)
    if (p * q > 0 && p * q / gcdPQ < newArr.size.toLong) ans = ans - newArr((p * q / gcdPQ).toInt)
    ans
  }

  def findMonkandDivisorConundrumBase(arr: Array[Int], max: Int, size: Int): Array[Int] = {
    var newArr = new Array[Int](max.toInt + 1)
    for (i <- 0 to size - 1) {
      for (j <- 1 to Math.sqrt(arr(i)).toInt) {
        if (arr(i) % j == 0) {
          newArr(j) = newArr(j) + 1
          if (arr(i) / j != j) {
            newArr(arr(i) / j) = newArr(arr(i) / j) + 1
          }
        }
      }
      //newArr(arr(i)) = newArr(arr(i)) + 1
    }
    newArr
  }
}

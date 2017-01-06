package NumberTheory.MonkandFredo

import FastIO.CustomScanner

import scala.collection.mutable

/**
  * Created by home on 12/29/2016.
  */
object MonkandFredo {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val t = customScanner.nextInt()
    val stringBuilder = new StringBuilder
    for (test <- 1 to t) {
      val a = customScanner.nextLong()
      val b = customScanner.nextLong()
      val c = customScanner.nextLong()
      stringBuilder.append(findAns(a, b, c) + "\n")
    }
    println(stringBuilder)
  }

  def findAns(a: Long, b: Long, c: Long): Long = {
    if (c == 0)
      1L
    else {
      val temp = advanceGCD(a, b)
      val gcd = a * temp(0) + b * temp(1)
      if (c % gcd != 0) 0L
      else {
        var newA = a / gcd
        var newB = b / gcd
        var newC = c / gcd
        var b1 = (newC / newB + 1D).toLong

        var y1 = ((newC % a) * modInverse(b, a)) % newA
        var ans = ((c / b).toLong - y1) / a + 1
        ans
      }
    }
  }

  def findCount(a: Long, b: Long, arr: Array[Long], gcd: Long): Long = {
    var count = 0L
    while (arr(0) >= 0) {
      if (arr(1) >= 0)
        count += 1L
      //println(a + " " + arr(0) + " " + b + " " + arr(1) + " " + gcd)
      arr(0) -= (b / gcd)
      arr(1) += (a / gcd)
    }
    count
  }

  def modInverse(a: Long, b: Long): Long = {
    val temp = advanceGCD(a, b)
    (a % b + b) % b
  }

  def advanceGCD(a: Long, b: Long): Array[Long] = {
    if (b == 0) Array(1L, 0L)
    else {
      val newList = advanceGCD(b, a % b)
      val temp0 = newList(1)
      val temp1 = newList(0) - (a / b * newList(1))
      Array(temp0, temp1)
    }
  }
}

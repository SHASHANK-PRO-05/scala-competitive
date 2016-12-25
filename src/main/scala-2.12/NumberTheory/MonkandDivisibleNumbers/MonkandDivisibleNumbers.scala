package NumberTheory.MonkandDivisibleNumbers

import FastIO.CustomScanner

import scala.collection.mutable

/**
  * Created by home on 12/25/2016.
  */
object MonkandDivisibleNumbers {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val t = customScanner.nextInt()
    for (i <- 0 to t - 1) {
      val a = customScanner.nextLong()
      val b = customScanner.nextLong()
      val c = customScanner.nextLong()
      val arrA = factorize(a)
      val arrB = factorize(b)
      println(find(a, b, c, arrA, arrB))
    }
  }

  def find(a: Long, b: Long, c: Long, arrA: Array[Long], arrB: Array[Long]): Long = {
    val map = new mutable.HashMap[Long, BigInt]()
    for (j <- 0 to arrB.size - 1) {
      var temp = b
      var ans: Long = 0;
      while (arrB(j) != 1 && temp % arrB(j) == 0) {
        ans += 1
        temp = temp / arrB(j)
      }
      map.put(arrB(j), BigInt(ans) * BigInt(c))
    }
    for (j <- 0 to arrA.size - 1) {
      if (map.contains(arrA(j))) {
        var temp = a
        var ans = 0;
        while (arrA(j) != 1 && temp % arrA(j) == 0) {
          ans += 1
          temp /= arrA(j)
        }
        var bigAns = map.getOrElseUpdate(arrA(j), 0) - BigInt(ans)
        if (bigAns < 0)
          bigAns = BigInt(0)
        map.put(arrA(j), bigAns)
      }
    }
    var keySet = map.keySet.toArray
    var ans = 1L
    val mod = 1000000007L
    for (i <- 0 to keySet.length - 1) {
      ans = (ans * modPow(keySet(i), map.getOrElseUpdate(keySet(i), 0), mod)) % mod
    }
    ans
  }

  def modPow(a: BigInt, b: BigInt, mod: Long): Long = {
    var temp = b
    var ans = BigInt(1L)
    var mantisa = a
    while (temp != 0) {
      if (temp % 2 != 0) {
        ans = (ans * mantisa) % mod
      }
      mantisa = (mantisa * mantisa) % mod
      temp /= 2
    }
    ans.toLong
  }

  def factorize(num: Long): Array[Long] = {
    if (isPrime(num)) Array(num)
    else {
      var arr = Array(1L)
      for (i <- 2L to Math.sqrt(num).toLong) {
        if (num % i == 0) {
          if (isPrime(i)) arr :+= i
          if (num / i != i && isPrime(num / i)) arr :+= num / i
        }
      }
      arr
    }
  }

  def isPrime(num: Long): Boolean = {
    for (i <- 2L to Math.sqrt(num).toLong) {
      if (num % i == 0) return false
    }
    true
  }
}


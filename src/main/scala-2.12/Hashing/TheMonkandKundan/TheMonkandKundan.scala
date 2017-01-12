package Hashing.TheMonkandKundan

import FastIO.CustomScanner

import scala.collection.mutable


/**
  * Created by shashank on 11/1/17.
  */
object TheMonkandKundan {
  def main(args: Array[String]): Unit = {
    val h = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    var map = new mutable.HashMap[Char, Int]()
    for (i <- 0 until h.length)
      map.put(h.charAt(i), i)
    val stringBuilder = new mutable.StringBuilder()
    val customScanner = new CustomScanner()
    val t = customScanner.nextInt()
    for (test <- 1 to t) {
      var strings = customScanner.nextLine().split(" ")
      var ans = 0L;
      for (i <- 0 until strings.length) {
        for (j <- 0 until strings(i).length) {
          ans += (j + map.getOrElse(strings(i).charAt(j), 0))
        }
      }
      ans *= strings.length
      stringBuilder.append(ans + "\n");
    }
    println(stringBuilder.toString());
    customScanner.close()
  }
}

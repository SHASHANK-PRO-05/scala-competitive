package JanuaryCircuits17.GoodString

import FastIO.CustomScanner

import scala.collection.mutable

/**
  * Created by shashank on 20/1/17.
  */
object GoodString {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val map = mutable.Set[Char]()
    val string = customScanner.nextLine()
    for (i <- 0 to string.length - 1) {
      map.add(string.charAt(i))
    }
    println(string.length - map.size)
    customScanner.close()
  }
}

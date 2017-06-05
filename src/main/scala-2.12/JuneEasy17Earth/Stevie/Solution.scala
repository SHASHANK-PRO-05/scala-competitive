package JuneEasy17Earth.Stevie

import FastIO.CustomScanner

import scala.collection.mutable

/**
  * Created by shanky on 6/4/17.
  */
object Solution {

  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val n = customScanner.nextLong()
    val as = customScanner.nextLine().split(" ").map(_.toLong)
    val bs = customScanner.nextLine().split(" ").map(_.toLong)
    val hashMap = new mutable.HashMap[Long, Long]()
    for (i <- as.indices) hashMap(as(i)) = math.max(hashMap.getOrElseUpdate(as(i), 0), bs(i))
    val ans = Array.ofDim[Long](bs.length)
    for (i <- as.indices) {
      ans(i) = math.max(bs(i), hashMap(as(i)))
    }
    ans.foreach(x => print(x + " "))
    println()
  }

}

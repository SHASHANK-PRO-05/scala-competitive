package Hashing.TheMonkandPrateek

import FastIO.CustomScanner

import scala.collection.mutable

/**
  * Created by shashank on 11/1/17.
  */
object TheMonkandPrateek {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val n = customScanner.nextLong()
    val map = new mutable.HashMap[Long, Long]()
    var foundColls = false
    for (i <- 0 until n.toInt) {
      val num = customScanner.nextLong()
      var sum = 0L
      var temp = num
      while (temp != 0) {
        sum += temp % 10
        temp /= 10
      }
      temp = num ^ sum
      map.put(temp, map.getOrElse(temp, 0L) + 1L)
      if (map.getOrElse(temp, 0L) > 1L)
        foundColls = true
    }
    if (foundColls) {
      val arr = new Array[Sorter](map.size)
      var i = 0;
      var maxColl = 0L
      for ((key, value) <- map) {
        //println(key + " " + value)
        if (value != 1L)
          maxColl = maxColl + value - 1L
        arr(i) = new Sorter(key, value)
        i += 1
      }
      scala.util.Sorting.stableSort(arr)
      //    for (i <- 0 to arr.length - 1) {
      //      println(arr(i).getValue() + " " + arr(i).getHash())
      //    }
      println(arr(0).getValue() + " " + maxColl)
    } else {
      val arr = new Array[DiffSorter](map.size)
      var i = 0;
      var maxColl = 0L
      for ((key, value) <- map) {
        //println(key + " " + value)
        if (value != 1L)
          maxColl = maxColl + value - 1L
        arr(i) = new DiffSorter(key, value)
        i += 1
      }
      scala.util.Sorting.stableSort(arr)
      //    for (i <- 0 to arr.length - 1) {
      //      println(arr(i).getValue() + " " + arr(i).getHash())
      //    }
      println(arr(0).getValue() + " " + maxColl)
    }
  }
}

class DiffSorter(value: Long, hashCount: Long) extends Ordered[DiffSorter] {
  def getValue(): Long = {
    this.value
  }

  def getHash(): Long = {
    this.hashCount
  }

  override def compare(that: DiffSorter): Int = {
    if (this.value > that.getValue()) -1
    else 1
  }
}

class Sorter(value: Long, hashCount: Long) extends Ordered[Sorter] {
  def getValue(): Long = {
    this.value
  }

  def getHash(): Long = {
    this.hashCount
  }

  override def compare(that: Sorter): Int = {
    if (this.hashCount > that.getHash()) -1
    else if (this.hashCount < that.getHash()) 1
    else if (this.value > that.getValue()) 1
    else -1
  }
}
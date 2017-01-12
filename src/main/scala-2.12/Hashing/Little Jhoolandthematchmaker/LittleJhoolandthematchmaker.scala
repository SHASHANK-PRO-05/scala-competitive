package Hashing.LittleJhoolandthematchmaker

import FastIO.CustomScanner

import scala.collection.mutable


/**
  * Created by shashank on 11/1/17.
  */
object LittleJhoolandthematchmaker {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val t = customScanner.nextInt()
    val string = "litejho"
    val stringBuilder = new StringBuilder
    for (test <- 0 until t) {
      val n = customScanner.nextInt()
      val k = customScanner.nextInt()
      var arr = new Array[Sorter](n)

      for (i <- 0 until arr.length) {
        val map = new mutable.HashMap[Char, Int]()
        for (j <- 0 until string.length) {
          map.put(string.charAt(j), map.getOrElse(string.charAt(j), 0) + 1)
        }
        val mainString = customScanner.next()
        val temp = mainString.toLowerCase()
        var common = 0
        for (j <- 0 until temp.length) {
          if (map.getOrElse(temp.charAt(j), 0) != 0) {
            common += 1
            map.put(temp.charAt(j), map.getOrElse(temp.charAt(j), 0) - 1)
          }
        }
        arr(i) = new Sorter(mainString, common, i)
      }
      scala.util.Sorting.stableSort(arr)
      for (i <- 0 until k) {
        stringBuilder.append(arr(i).getName() + " ")
      }
      stringBuilder.append("\n")
    }
    println(stringBuilder.toString())
    customScanner.close()
  }
}

class Sorter(name: String, num: Int, index: Int) extends Ordered[Sorter] {
  def getName(): String = {
    this.name
  }

  def getNum(): Int = {
    this.num
  }

  def getIndex(): Int = {
    this.index
  }

  override def compare(that: Sorter): Int = {
    if (this.num > that.getNum()) 1
    else if (this.num < that.getNum()) -1
    else if (this.index > that.getIndex()) 1
    else if (that.getIndex() > this.index) -1
    else 0
  }
}

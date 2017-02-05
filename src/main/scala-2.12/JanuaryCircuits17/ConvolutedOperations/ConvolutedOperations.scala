package JanuaryCircuits17.ConvolutedOperations

import FastIO.CustomScanner

import scala.collection.mutable.ArrayBuffer

class Checker extends Ordered[Checker] {
  var elem = 0L
  var deletedOn = Int.MaxValue
  var insertedOn = 0

  override def compare(that: Checker): Int = {
    if (this.elem > that.elem) 1
    else if (this.elem < that.elem) -1
    else 0
  }
}

/**
  * Created by shashank on 24/1/17.
  */
object ConvolutedOperations {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val n = customScanner.nextInt()
    var list: List[Long] = List()
    var inserting: ArrayBuffer[Checker] = ArrayBuffer()
    var deleting: ArrayBuffer[Checker] = ArrayBuffer()
    for (i <- 1 to n) {
      val typeCheck = customScanner.nextInt()
      if (typeCheck == 1) {
        val temp = new Checker
        temp.elem = customScanner.nextLong()
        temp.insertedOn = i
        inserting = inserting :+ temp
      } else if (typeCheck == 0) {
        //println(inserting.length)
        val temp = inserting.remove(inserting.size - 1)
        //println(inserting.length)
        temp.deletedOn = i
        deleting :+= temp
      } else if (typeCheck == 2) {
        val k = customScanner.nextInt()
        val num = customScanner.nextLong()
        println(deletedBSearch(num, k, deleting) + insertBSearch(num, k, inserting))
      }
    }
  }

  def deletedBSearch(elem: Long, op: Int, list: ArrayBuffer[Checker]): Int = {
    var ans = 0
    for (i <- 0 to list.length - 1) {
      if (elem > list(i).elem && list(i).deletedOn > op)
        ans += 1
    }
    ans
  }

  def insertBSearch(elem: Long, op: Int, list: ArrayBuffer[Checker]): Int = {
    var ans = 0
    for (i <- 0 to list.length - 1) {
      if (elem > list(i).elem && list(i).insertedOn <= op)
        ans += 1
    }
    ans
  }
}

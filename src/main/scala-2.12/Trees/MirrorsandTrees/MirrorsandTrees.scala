package Trees.MirrorsandTrees

import FastIO.CustomScanner

import scala.collection.mutable

class NodePrint {
  var printed = false
  var value = 0L
  var level = 0
}


/**
  * Created by shashank on 28/1/17.
  */
object MirrorsandTrees {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val t = customScanner.nextInt()
    for (test <- 1 to t) {
      val size = customScanner.nextInt()
      val arr: Array[NodePrint] = Array.ofDim(size)
      val rightLevelDone: mutable.HashMap[Int, Boolean] = new mutable.HashMap()
      val leftLevelDone: mutable.HashMap[Int, Boolean] = new mutable.HashMap()
      for (i <- 0 until size) {
        arr(i) = new NodePrint
        arr(i).value = customScanner.nextLong()
        if (i == 0)
          arr(i).level = 0
        else if (i % 2 == 0)
          arr(i).level = arr((i - 2) / 2).level + 1
        else
          arr(i).level = arr((i - 1) / 2).level + 1
      }
      printRight(arr, 0, rightLevelDone)
      printleft(arr, 0, leftLevelDone)
      println()
    }

  }

  def printRight(arr: Array[NodePrint], index: Int, rightLevelDone: mutable.HashMap[Int, Boolean]): Unit = {
    if (index < arr.length) {

      if (!rightLevelDone.contains(arr(index).level) && arr(index).value != 0 && arr(index).printed == false) {
        println(arr(index).value)
        arr(index).printed = true
        rightLevelDone.put(arr(index).level, true)
      }
      printRight(arr, index * 2 + 2, rightLevelDone)
      printRight(arr, index * 2 + 1, rightLevelDone)
    }
  }

  def printleft(arr: Array[NodePrint], index: Int, leftLevelDone: mutable.HashMap[Int, Boolean]): Unit = {
    if (index < arr.length) {
      if (!leftLevelDone.contains(arr(index).level) && arr(index).value != 0 && arr(index).printed == false) {
        println(arr(index).value)
        arr(index).printed = true
        leftLevelDone.put(arr(index).level, true)
      }
      printleft(arr, index * 2 + 1, leftLevelDone)
      printleft(arr, index * 2 + 2, leftLevelDone)
    }
  }

  def getLevel(index: Int): Int = {
    var temp = index
    var ans = 0
    while (temp != 0) {
      ans += 1
      temp /= 2
    }
    ans
  }


}

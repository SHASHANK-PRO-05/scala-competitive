package Trees

import FastIO.CustomScanner

import scala.collection.mutable.ArrayBuffer

/**
  * Created by shashank on 27/1/17.
  */
class Pair {
  var color = 0
  var child = ArrayBuffer[Int]()
  var visited = false
  var immediateParentColor = 0
  var index = 0
}

object MancunianAndColoredTree {


  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val size = customScanner.nextInt()
    val colorType = customScanner.nextInt()
    val arr: Array[Pair] = Array.ofDim[Pair](size + 1)
    for (i <- 2 to size) {
      val parent = customScanner.nextInt()
      if (arr(parent) == null) arr(parent) = new Pair
      arr(parent).child = arr(parent).child :+ i

    }
    for (i <- 1 to size) {
      if (arr(i) == null) arr(i) = new Pair
      arr(i).color = customScanner.nextInt()
      arr(i).index = i
    }
    findAns(arr, List[Pair](), 1)
    for (i <- 1 to size) {
      //println("Index " + i + " " + arr(i).child.toList)
      print(arr(i).immediateParentColor + " ")
    }

  }

  def findAns(arr: Array[Pair], parents: List[Pair], index: Int): Unit = {
    arr(index).immediateParentColor = parents.indexWhere((p) => p.color == arr(index).color)
    if (arr(index).immediateParentColor != -1) {
      arr(index).immediateParentColor = parents(arr(index).immediateParentColor).index
    }
    //println(arr(index).child.toList)
    for (i <- arr(index).child) {
      findAns(arr, arr(index) :: parents, i)
    }
  }
}

package Trees.LittleMonkandSwaps

import FastIO.CustomScanner

import scala.collection.mutable

/**
  * Created by shashank on 15/1/17.
  */
object LittleMonkandSwaps {


  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val size = customScanner.nextInt()
    val arr = customScanner.nextLine().split(" ").map(_.toInt)
    val maxSize = arr.max
    var ans = 0L
    val sortedArr = arr.sorted
    val inorderArr = inorderTraverse(arr)
    val cycleChecks = Array.ofDim[Int](maxSize + 1)
    var mapSet = Set[Int]()
    for (i <- 0 until sortedArr.length) {
      cycleChecks(sortedArr(i)) = i
    }
    for (i <- 0 until inorderArr.length) {
      if (!mapSet.contains(inorderArr(i)) && inorderArr(i) != sortedArr(i)) {
        var x = 0
        var y = inorderArr(i)
        while (!mapSet.contains(y)) {
          x += 1
          mapSet = mapSet + y
          y = inorderArr(cycleChecks(y))
        }
        ans += (x - 1)
      }
    }
    println(ans)
  }

  def inorderTraverse(arr: Array[Int]): Array[Int] = {
    val returnArr = Array.ofDim[Int](arr.length)
    var index = 0
    def internalInOrder(i: Int): Unit = {
      if (i < arr.length) {
        internalInOrder(i * 2 + 1)
        returnArr(index) = arr(i)
        index += 1
        internalInOrder(i * 2 + 2)
      }
    }
    internalInOrder(0)
    returnArr
  }

}

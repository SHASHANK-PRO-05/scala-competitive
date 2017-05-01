package AccelHack.StudiousAmitandHisNewCollege

import java.util

import FastIO.CustomScanner


/**
  * Created by shashank on 8/4/17.
  */
object StudiousAmitandHisNewCollege {
  var visited = Array.ofDim[Boolean](1)
  var recStack = Array.ofDim[Boolean](1)
  var arrayList = Array.ofDim[util.ArrayList[Int]](1)

  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val t = customScanner.nextInt()
    for (tests <- 1 to t) {
      val n = customScanner.nextInt()
      val m = customScanner.nextInt()
      visited = Array.ofDim[Boolean](n)
      recStack = Array.ofDim[Boolean](n)
      arrayList = Array.ofDim[util.ArrayList[Int]](n)
      for (i <- arrayList.indices) {
        arrayList(i) = new util.ArrayList[Int]()
      }
      for (i <- 1 to m) {
        val u = customScanner.nextInt() - 1
        arrayList(customScanner.nextInt() - 1).add(u)
      }
      if (check()) {
        println(0)
      } else {
        println(1)
      }
    }
  }

  def findCycle(index: Int): Boolean = {
    if (!visited(index)) {
      visited(index) = true
      recStack(index) = true
      for (i <- 0 until arrayList(index).size()) {
        if (!visited(arrayList(index).get(i))) {
          return findCycle(arrayList(index).get(i))
        } else if (recStack(arrayList(index).get(i))) {
          return true
        }
      }
    }
    recStack(index) = false
    false
  }

  def check(): Boolean = {
    for (i <- visited.indices) {
      if (findCycle(i)) {
        return true
      }
    }
    false
  }
}

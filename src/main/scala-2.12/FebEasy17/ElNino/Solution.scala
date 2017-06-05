package FebEasy17.ElNino


import java.util

import FastIO.CustomScanner

object Solution {

  class No {
    var elem: Int = _
    var child: util.ArrayList[Int] = new util.ArrayList[Int]()
  }

  val set = new util.HashSet[(Int, Int, Int)]()
  var visited: Array[Boolean] = _

  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val (n, m) = (customScanner.nextInt(), customScanner.nextInt())
    val a = customScanner.nextLine().split(" ").map(_.toInt)
    val nodes = Array.ofDim[No](n)
    visited = Array.ofDim[Boolean](n)
    for (i <- 0 until n) {
      nodes(i) = new No
      nodes(i).elem = i
    }
    for (i <- 1 to n - 1) {
      val parent = customScanner.nextInt()
      nodes(parent - 1).child.add(i)
    }
    //    for (i <- nodes.indices) {
    //      println(nodes(i).elem + " " + nodes(i).child)
    //    }
    for (i <- visited.indices) {
      if (!visited(i))
        recur(nodes, i, new util.ArrayList[Int](), a.toSet)
    }

    set.forEach(x => {
      println(x)
    })
    println(set.size())
  }

  def recur(nodes: Array[No], index: Int, parentIndex: util.ArrayList[Int], a: Set[Int]): Unit = {
    //println(parentIndex + " : " + index)
    visited(index) = true
    for (i <- 0 until parentIndex.size()) {
      if (a.contains(parentIndex.size() - i)) {
        set.add((parentIndex.get(i) + 1, index + 1, parentIndex.size() - i))
      }
    }
    parentIndex.add(index)
    for (i <- 0 until nodes(index).child.size()) {
      recur(nodes, nodes(index).child.get(i), parentIndex, a)
    }
    //    nodes(index).child.forEach((x: Int): Unit => {
    //      recur (nodes, x, parentIndex, a)
    //    })
    parentIndex.remove(parentIndex.size() - 1)
  }
}

package JanuaryCircuits17

import FastIO.CustomScanner

class TrieNode {
  var value: Long = 0L
  var TrieArray: Array[TrieNode] = Array(null, null)

}


/**
  * Created by shashank on 21/1/17.
  */
object MicrosHouse {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val n = customScanner.nextInt()
    val m = customScanner.nextInt()
    val array = Array.ofDim[Long](n, m)
    for (i <- 0 until n) {
      for (j <- 0 until m) {
        array(i)(j) = customScanner.nextLong()
      }
    }
    var ans = Long.MinValue
    for (i <- 0 until m) {
      val arr = Array.ofDim[Long](n)
      //println(arr.toList)
      for (j <- i to 0 by -1) {
        for (k <- 0 until n) {
          arr(k) = arr(k) ^ array(k)(j)
        }
        //println(arr.toList)
        var root: TrieNode = new TrieNode
        var pre_xor = 0L
        for (k <- 0 until n) {
          ans = Math.max(arr(k), ans)
          pre_xor = pre_xor ^ arr(k)
          root = insert(root, pre_xor)
          ans = Math.max(ans, query(root, pre_xor))
        }
      }
    }
    //println(insert(new TrieNode, 0))
    //    for (i <- 0 until n) {
    //      val arr = Array.ofDim[Long](m)
    //      for (j <- i to 0 by -1) {
    //        for (k <- 0 until m) {
    //          arr(k) = arr(k) ^ array(j)(k)
    //        }
    //        //println(arr.toList)
    //        var root: TrieNode = new TrieNode
    //        var pre_xor = 0L
    //        for (k <- 0 until m) {
    //          ans = Math.max(arr(k), ans)
    //          pre_xor = pre_xor ^ arr(k)
    //          root = insert(root, pre_xor)
    //          //print(query(root, pre_xor) + " ")
    //          ans = Math.max(ans, query(root, pre_xor))
    //          //println(ans)
    //        }
    //        //println()
    //      }
    //    }
    println(ans)
  }

  def query(root: TrieNode, pre_xor: Long): Long = {
    var temp = root
    for (i <- 63 to 0 by -1) {
      val msb = (pre_xor >> 1) & 1L
      if (temp.TrieArray(1 - msb.toInt) != null)
        temp = temp.TrieArray(1 - msb.toInt)
      else if (temp.TrieArray(msb.toInt) != null)
        temp = temp.TrieArray(msb.toInt)
    }
    pre_xor ^ temp.value
  }

  def insert(root: TrieNode, pre_xor: Long): TrieNode = {
    var temp = root
    //println(pre_xor)
    for (i <- 63 to 0 by -1) {
      val msb = (pre_xor >> i) & 1L
      //print(msb)
      if (temp.TrieArray(msb.toInt) == null) temp.TrieArray(msb.toInt) = new TrieNode()
      temp = temp.TrieArray(msb.toInt)
    }
    //println("")
    temp.value = pre_xor
    root
  }
}

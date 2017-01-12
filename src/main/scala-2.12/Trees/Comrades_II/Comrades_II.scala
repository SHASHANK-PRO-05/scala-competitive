package Trees.Comrades_II

import FastIO.CustomScanner

/**
  * Created by shashank on 7/1/17.
  */
object Comrades_II {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val t = customScanner.nextInt()
    for (i <- 0 until t) {
      val n = customScanner.nextLong()
      val arr = new Array[List[Long]](n.toInt + 1)
      for (j <- 1 to n.toInt) {
        if (arr(j) == null) arr(j) = List()
        val temp = customScanner.nextLong()
        if (arr(temp.toInt) == null) arr(temp.toInt) = List()
        arr(temp.toInt) :+= j.toLong
      }
      val handshake: Long = findAns(arr);
      val fist: Long = n * (n - 1) / 2L - handshake
      println(handshake + " " + fist)
    }
  }

  def findAns(arr: Array[List[Long]]): Long = {
    var ans = 0L
    def innerFunc(list: List[Long], pos: Long): Long = {
      var innerAns = 0L
      if (arr(pos.toInt).length == 0) 1
      else {
        for {
          i <- list
        } yield {
          innerAns += innerFunc(arr(i.toInt), i)
        }
        if (pos != 0)
          ans += innerAns
        innerAns + 1
      }
    }
    innerFunc(arr(0), 0)
    ans
  }
}



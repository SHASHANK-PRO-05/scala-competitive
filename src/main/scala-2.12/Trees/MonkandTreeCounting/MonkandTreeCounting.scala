package Trees.MonkandTreeCounting

import FastIO.CustomScanner

/**
  * Created by shashank on 15/1/17.
  */
object MonkandTreeCounting {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val n = customScanner.nextInt()
    val k = customScanner.nextLong()
    val arr = new Array[Long](n + 1)
    val treeArr = new Array[List[Int]](n + 1)
    for (i <- 1 to n) {
      arr(i) = customScanner.nextLong()
    }
    for (i <- 2 to n) {
      val temp = customScanner.nextInt()
      if (treeArr(temp) == null)
        treeArr(temp) = List[Int]()
      treeArr(temp) = treeArr(temp).::(i)
    }
    println(findChildsandReportCount(treeArr, arr, 1, k)._2)
  }

  def findChildsandReportCount(treeArr: Array[List[Int]], arr: Array[Long], index: Int, k: Long): (Set[Int], Int) = {
    var ans = Set[Int]()
    var count = 0
    if (treeArr(index) != null) {
      for (i <- treeArr(index)) {
        val prev = findChildsandReportCount(treeArr, arr, i, k)
        ans = ans.union(prev._1)
        count += prev._2
      }
    }

    val temp = ans.toArray
    val tempArr = new Array[Long](temp.size)
    for (i <- 0 until temp.length) {
      tempArr(i) = arr(temp(i))
    }
    scala.util.Sorting.stableSort(tempArr)
    //println(tempArr.toList)
    for (i <- 0 to tempArr.length - 1) {
      count += findNum(tempArr, k, i + 1, tempArr.length - 1, arr(index) + tempArr(i))
    }
    //println(count)
    ans = ans.+(index)
    (ans, count)
  }

  def findNum(arr: Array[Long], k: Long, start: Int, end: Int, agg: Long): Int = {
    var ans = end + 1
    var tempStart = start
    var tempEnd = end
    while (tempStart <= tempEnd) {
      val mid = (tempStart + tempEnd) / 2
      if (agg + arr(mid) >= k) {
        ans = mid
        tempEnd = mid - 1
      } else {
        tempStart = mid + 1
      }
    }
    ans = end - ans + 1
    ans
  }

}

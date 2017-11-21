package LeetCode.Random.MergeIntervals

/**
  * Created by shanky on 11/16/17.
  */
class Interval(var _start: Int = 0, var _end: Int = 0) {
  var start: Int = _start
  var end: Int = _end

  override def toString: String = {
    "{" + start + "," + end + "}"
  }
}

object Solution {
  def merge(intervals: List[Interval]): List[Interval] = {
    val array = intervals.sortWith((x, y) => {
      if (x._start > y._start) false
      else if (x._start < y._start) true
      else if (x._end > y.end) false
      else if (x._end < y._end) true
      else false
    }).toArray

    var newArray = Array.ofDim[Interval](0)
    var current: Interval = new Interval(0, 0)
    for (i <- array.indices) {
      if (array(i).start > current.end) {
        newArray = newArray :+ array(i)
        current = array(i)
      } else if (array(i).start == current.end) {
        current.end = array(i).end
        newArray(newArray.length - 1) = current
      } else {
        current.start = math.min(current.start, array(i).start)
        current.end = math.max(current.end, array(i).end)
        newArray(newArray.length - 1) = current
      }
    }
    newArray.toList
  }

  def main(args: Array[String]): Unit = {
    merge(List(new Interval(2, 3), new Interval(2, 20), new Interval(8, 10), new Interval(15, 18)))
  }
}

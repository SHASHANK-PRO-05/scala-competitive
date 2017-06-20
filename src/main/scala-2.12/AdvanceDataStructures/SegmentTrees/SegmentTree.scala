package AdvanceDataStructures.SegmentTrees

class SegmentTree(arr: Array[Int], n: Int) {
  val maxSize = 1 << (math.ceil(math.log(n) / math.log(2)).toInt + 1)
  val segmentArray = Array.ofDim[Int](maxSize)

  def getMid(s: Int, e: Int): Int = s + (e - s) / 2

  constructSTUtil(0, n - 1, 0)
  //println(segmentArray.deep.mkString(" "))

  def getSumUtil(ss: Int, se: Int, qs: Int, qe: Int, si: Int): Int = {
    if (ss >= qs && se <= qe) segmentArray(si)
    else if (ss > qe || se < qs) return 0
    else {
      val mid = getMid(ss, se)
      getSumUtil(ss, mid, qs, qe, 2 * si + 1) +
        getSumUtil(mid + 1, se, qs, qe, 2 * si + 2)
    }
  }

  def updateSTUtil(ss: Int, se: Int, i: Int, diff: Int, si: Int): Unit = {
    if (i > se || i < ss) return
    segmentArray(si) += diff
    if (ss != se) {
      val mid = getMid(ss, se)
      updateSTUtil(ss, mid, i, diff, 2 * si + 1)
      updateSTUtil(mid + 1, se, i, diff, 2 * si + 2)
    }
  }

  def update(v: Int, index: Int): Unit = {
    val diff = v - arr(index)
    arr(index) = v
    updateSTUtil(0, n - 1, index, diff, 0)
  }

  def constructSTUtil(ss: Int, se: Int, si: Int): Int = {
    if (ss == se) {
      segmentArray(si) = arr(ss)
      arr(ss)
    } else {
      val mid = getMid(ss, se)
      segmentArray(si) = constructSTUtil(ss, mid, si * 2 + 1) +
        constructSTUtil(mid + 1, se, si * 2 + 2)
      //println(si + " " + segmentArray(si))
      segmentArray(si)
    }
  }
}

object SegmentTree {
  def main(args: Array[String]): Unit = {
    val temp = new SegmentTree(Array(1, 3, 5, 7, 9, 11), 6)
    println(temp.getSumUtil(0, 5, 1, 3, 0))
    temp.update(4, 1)
    temp.update(-10, 2)
    println(temp.getSumUtil(0, 5, 1, 3, 0))

  }
}

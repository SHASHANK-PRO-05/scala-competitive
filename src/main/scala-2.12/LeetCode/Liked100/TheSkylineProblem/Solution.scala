package LeetCode.Liked100.TheSkylineProblem



/**
  * Created by shanky on 11/6/17.
  */
object Solution {
  import java.util.Collections
  class ContourOrder extends Ordered[ContourOrder] {
    var index = 0
    var height = 0

    override def compare(that: ContourOrder): Int = {
      if (this.index != that.index)
        this.index - that.index
      else that.height - this.height
    }
  }

  def getSkyline(buildings: Array[Array[Int]]): List[Array[Int]] = {
    var array = new Array[ContourOrder](0)

    for (iter <- buildings) {
      val start = new ContourOrder()
      start.index = iter(0)
      start.height = -iter(2)
      val end = new ContourOrder()
      end.index = iter(1)
      end.height = iter(2)
      array = array :+ start
      array = array :+ end
    }
    array = array.sorted
    val queue = new java.util.PriorityQueue[Int](10, Collections.reverseOrder())
    var list: List[Array[Int]] = List()
    var prev = -1
    for (iter <- array) {
      if (iter.height < 0)
        queue.offer(-1 * iter.height)
      else
        queue.remove(iter.height)
      var cur = queue.peek()

      if (cur != prev) {
        prev = cur
        list = list :+ Array(iter.index, cur)
      }
    }
//    for (elem <- list) {
//      println(elem.toList)
//    }
    list
  }

  def main(args: Array[String]): Unit = {
    println(getSkyline(Array(Array(2, 9, 10), Array(3, 7, 15), Array(5, 12, 12), Array(15, 20, 10), Array(19, 24, 8))))
  }
}

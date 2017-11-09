package LeetCode.Liked100.MergekSortedLists

/**
  * Created by shanky on 11/6/17.
  */
object Solution {

  class orderedListNode extends Ordering[ListNode] {
    override def compare(x: ListNode, y: ListNode): Int = x.x - y.x
  }

  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }

  def mergeKLists(lists: Array[ListNode]): ListNode = {
    if (lists.length == 0) return null
    var list: List[ListNode] = List()
    for (i <- lists) {
      var iter = i
      while (iter != null) {
        list = list :+ iter
        iter = iter.next
      }
    }
    val ans = list.toArray.sortWith(_.x < _.x)
    var newListNode: ListNode = null
    var head: ListNode = null
    for (iter <- ans) {
      if (newListNode == null) {
        newListNode = iter
        head = iter
      } else {
        newListNode.next = iter
        newListNode = iter
      }
    }
    head
  }

  def main(args: Array[String]): Unit = {

  }
}

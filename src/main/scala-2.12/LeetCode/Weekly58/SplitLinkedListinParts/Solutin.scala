package LeetCode.Weekly58.SplitLinkedListinParts

/**
  * Created by shanky on 11/16/17.
  */
object Solutin {

  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x

    override def toString: String = {
      var string = "["
      var tempRoot = this
      while (tempRoot != null) {
        string += tempRoot.x + "->"
        tempRoot = tempRoot.next
      }
      string += "]"
      string
    }
  }

  def splitListToParts(root: ListNode, k: Int): Array[ListNode] = {
    var size = 0
    val array = Array.ofDim[ListNode](k)
    val sizeArray = Array.ofDim[Int](k)
    if (root == null) return array
    var tempRoot = root
    while (tempRoot != null) {
      size += 1
      tempRoot = tempRoot.next
    }
    val equalSize = math.floor(size / k).toInt
    var extraelement = size % k
    java.util.Arrays.fill(sizeArray, 0, k, equalSize)
    for (i <- 0 until extraelement) {
      sizeArray(i) += 1
    }
    var index = 0
    var i = 0
    tempRoot = root
    for (i <- 0 until k) {
      var listNode: ListNode = null
      var home: ListNode = null
      for (j <- 0 until sizeArray(i)) {
        if (listNode == null) {
          listNode = tempRoot
          home = tempRoot
        } else {
          listNode.next = tempRoot
          listNode = tempRoot
        }
        tempRoot = tempRoot.next
      }
      if (listNode != null)
        listNode.next = null
      array(i) = home
    }
    array
  }

  def main(args: Array[String]): Unit = {
    var listNode = new ListNode()
    listNode.x = 1
    listNode.next = new ListNode()
    listNode.next.x = 2
    listNode.next.next = new ListNode()
    listNode.next.next.x = 3
    println(splitListToParts(listNode, 5).toList)
  }
}

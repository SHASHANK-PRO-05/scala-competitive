package LeetCode.Weekly59.MyCalendarI

/**
  * Created by shanky on 11/18/17.
  */
object Solution {
  var head: Tree = null

  class Tree {
    var start = 0
    var end = 0
    var left: Tree = null
    var right: Tree = null
  }

  def isOverLapping(tree: Tree, start: Int, end: Int): Boolean = {
    if (tree.start > start && tree.start < end && tree.end > end) true
    else if (tree.start < start && start < tree.end && tree.end < end) true
    else if (tree.start <= start && tree.end >= end) true
    else if (tree.start >= start && tree.end <= end) true
    else false
  }

  def insert(root: Tree, start: Int, end: Int): (Tree, Boolean) = {
    if (root == null) {
      var tempRoot = new Tree()
      tempRoot.start = start
      tempRoot.end = end
      (tempRoot, true)
    } else {
      if (isOverLapping(root, start, end)) (root, false)
      else {
        if (root.start < start) {
          var getLeftTuple = insert(root.left, start, end)
          root.left = getLeftTuple._1
          (root, getLeftTuple._2)
        } else {
          var getRightTuple = insert(root.right, start, end)
          root.right = getRightTuple._1
          (root, getRightTuple._2)
        }
      }
    }
  }

  def book(start: Int, end: Int): Boolean = {
    if (head == null) {
      head = new Tree()
      head.start = start
      head.end = end
      true
    } else {
      var insertSuccess = insert(head, start, end)
      head = insertSuccess._1
      insertSuccess._2
    }
  }

  def main(args: Array[String]): Unit = {
    println(book(10, 20))
    println(book(5, 10))
    println(book(6, 15))
    println(book(1, 5))
    println(book(31, 40))
    println(book(20, 31))
  }

}

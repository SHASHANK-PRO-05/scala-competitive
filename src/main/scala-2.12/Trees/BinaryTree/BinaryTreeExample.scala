package Trees.BinaryTree

import FastIO.CustomScanner


import scala.util.Sorting

/**
  * Created by shashank on 7/1/17.
  */
object BinaryTreeExample {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val t = customScanner.nextInt()
    var root = new Tree().insert(null, customScanner.nextInt(), null)
    val sortedInputs = new Array[sortedInput](t - 1)
    for (i <- 1 until t) {
      sortedInputs(i - 1) = new sortedInput
      sortedInputs(i - 1).arr = customScanner.nextString()
      sortedInputs(i - 1).elem = customScanner.nextInt()

    }
    Sorting.quickSort(sortedInputs)
    for (i <- 0 until t - 1) {
      //println(sortedInputs(i).arr)
      root = root.insert(root, sortedInputs(i).elem, sortedInputs(i).arr)
    }
    println(root.findDiameter(root))
    customScanner.close()
  }
}

class sortedInput extends Ordered[sortedInput] {
  var arr: String = ""
  var elem: Int = 0

  override def compare(that: sortedInput): Int = {
    if (this.arr.length < that.arr.length) -1
    else if (this.arr.length > that.arr.length) 1
    else 0
  }
}

class Tree {
  def insert(root: Tree, elem: Int, stringArr: String): Tree = {
    def findAndPlace(root: Tree, pos: Int): Tree = {
      if (root == null) LeafNode(elem)
      else if (pos >= stringArr.length)
        null
      else {
        root match {
          case LeafNode(x) if stringArr(pos) == 'L' => FullNode(x, LeafNode(elem), null)
          case LeafNode(x) if stringArr(pos) == 'R' => FullNode(x, null, LeafNode(elem))
          case FullNode(x, left, right) if stringArr(pos) == 'L' => FullNode(x, findAndPlace(left, pos + 1), right)
          case FullNode(x, left, right) if stringArr(pos) == 'R' => FullNode(x, left, findAndPlace(right, pos + 1))
        }
      }
    }
    findAndPlace(root, 0)
  }

  def findDiameter(node: Tree): Int = {
    var ans = 0
    def innerFunc(node: Tree): Int = {
      node match {
        case null => 0
        case LeafNode(x) =>
          //println("LeafNode: " + x)
          ans = math.max(ans, 1);
          1
        case FullNode(x, left, right) => {
          val leftDiam = innerFunc(left)
          val rightDiam = innerFunc(right)
          ans = math.max(ans, leftDiam + 1 + rightDiam)
          val returnData = math.max(leftDiam + 1, rightDiam + 1)
          returnData
        }
      }
    }
    innerFunc(node)
    ans
  }
}

case class LeafNode(x: Int) extends Tree

case class FullNode(x: Int, left: Tree, right: Tree) extends Tree


package Trees.Monkwatchingfight

import FastIO.CustomScanner

/**
  * Created by shashank on 14/1/17.
  */
object Monkwatchingfight {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val size = customScanner.nextInt()
    var tree: Tree = null

    for (i <- 0 until size) {
      if (i == 0) tree = Leaf(customScanner.nextLong())
      else tree = tree.insert(customScanner.nextLong())
    }
    //println(tree)
    println(findHeight(tree))
  }

  def findHeight(tree: Tree): Int = tree match {
    case Leaf(_) => 1
    case FullTree(_, left, right) => Math.max(findHeight(left) + 1, findHeight(right) + 1)
    case Buggy() => 0
  }
}

abstract class Tree {
  def insert(num: Long): Tree

  override def toString: String = this match {
    case Leaf(x) => "{Nil<-" + x + "->Nil}"
    case FullTree(x, left, right) => "{" + left.toString + "<-" + x + "->" + right.toString + "}"
    case Buggy() => "Nil"
  }
}


case class Buggy() extends Tree {
  override def insert(num: Long): Tree = Leaf(num)
}

case class Leaf(x: Long) extends Tree {
  override def insert(num: Long): Tree = {
    if (x < num) FullTree(x, Buggy(), Leaf(num))
    else FullTree(x, Leaf(num), Buggy())
  }
}


case class FullTree(x: Long, left: Tree, right: Tree) extends Tree {
  override def insert(num: Long): Tree = {
    if (num > x) FullTree(x, left, right.insert(num))
    else FullTree(x, left.insert(num), right)
  }
}




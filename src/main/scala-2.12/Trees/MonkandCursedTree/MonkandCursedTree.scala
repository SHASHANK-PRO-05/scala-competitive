package Trees.MonkandCursedTree

import FastIO.CustomScanner


/**
  * Created by shashank on 15/1/17.
  */
object MonkandCursedTree {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val n = customScanner.nextInt()
    var tree: Tree = new Buggy
    for (i <- 0 until n) {
      tree = tree.insert(customScanner.nextLong())
    }
    //println(tree)
    //println(find(tree, Set[Long](), 6).size)
    val num1 = customScanner.nextLong()
    val num2 = customScanner.nextLong()
    var ans1 = find(tree, Set[Long](), num1)
    var ans2 = find(tree, Set[Long](), num2)
    //println(findRoot(tree, num1, num2))
    println(Math.max(ans1.union(ans2).--(ans1.intersect(ans2)).max, findRoot(tree, num1, num2)))
  }

  def findRoot(tree: Tree, num1: Long, num2: Long): Long = {
    tree match {
      case FullTree(x, left, right) => if (x == num1 || x == num2) x
      else if (x > num1 && x < num2) x
      else if (x > num1 && x > num2) findRoot(left, num1, num2)
      else findRoot(right, num1, num2)
      case Leaf(x) => x
    }
  }

  def find(tree: Tree, set: Set[Long], num: Long): Set[Long] = {
    var ans = set
    //println(ans)
    tree match {
      case Leaf(x) => if (x == num) ans = ans.+(x)
      case FullTree(x, left, right) =>
        //println(x)
        ans = ans.+(x)
        //println(ans)
        if (x > num) ans = find(left, ans, num)
        else if (x < num) ans = find(right, ans, num)
      case Buggy() =>
    }
    ans
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





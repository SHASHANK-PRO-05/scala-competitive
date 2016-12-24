package Trees

/**
  * Created by home on 12/21/2016.
  */
abstract class Node {
  /**
    * First setting up a basic insert
    */
  def insert(value: Int, location: Char): Node = {
    this match {
      case null => LeafNode(value)
      case LeafNode(data) => if (location == 'L') LeftNode(data, LeafNode(value)) else RightNode(data, LeafNode(value))
      case RightNode(data, right) => FullNode(data, LeafNode(value), right)
      case LeftNode(data, left) => FullNode(data, left, LeafNode(value))
    }
  }

  /**
    * Basic utility function to find the size of the tree
    */
  def size(): Int = {
    def internal(node: Node, level: Int): Int = {
      node match {
        case LeafNode(data) => level
        case RightNode(data, right) => internal(right, level + 1)
        case LeftNode(data, left) => internal(left, level + 1)
        case FullNode(data, left, right) => Math.max(internal(left, level + 1), internal(right, level + 1))
      }
    }

    internal(this, 1)
  }
}

case class LeafNode(data: Int) extends Node

case class FullNode(data: Int, left: Node, right: Node) extends Node

case class LeftNode(data: Int, left: Node) extends Node

case class RightNode(data: Int, right: Node) extends Node


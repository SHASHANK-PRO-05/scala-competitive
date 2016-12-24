package Trees

import java.io.{BufferedReader, FileInputStream, InputStreamReader}

import FastIO.CustomScanner

/**
  * Created by home on 12/21/2016.
  */
object BinaryTreeTest {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner(new BufferedReader(new InputStreamReader(System.in)))
    val t = customScanner.nextInt()
    var root: Node = new LeafNode(customScanner.nextInt())
    for (i <- 1 to t - 1) {
      root = findNode(root, customScanner.next(), customScanner.nextInt(), 0)
    }
    println(root.size() + 1)
    //println(t);

  }

  def findNode(root: Node, place: String, value: Int, location: Int): Node = {
    if (location == place.length - 1) {
      root.insert(value, place.charAt(location))
    } else {
      root match {
        case LeftNode(data, left) => LeftNode(data, findNode(left, place, value, location + 1))
        case RightNode(data, right) => RightNode(data, findNode(right, place, value, location + 1))
        case FullNode(data, left, right) => if (place.charAt(location) == 'L') FullNode(data, findNode(left, place, value, location + 1), right)
        else FullNode(data, left, findNode(right, place, value, location + 1))
      }
    }
  }
}

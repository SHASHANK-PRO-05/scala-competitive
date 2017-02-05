package Trees.GandhiTreeMarch

import java.util
import java.util.{Collections, Comparator}


class Noddy extends Comparator[Char] {
  var char = 'a'
  var col = 0
  var leftDone = false
  var rightDone = false

  override def compare(o1: Char, o2: Char): Int = {
    if (o1 > o2) return 1
    else if (o1 < o2) return -1
    else 0
  }
}

import FastIO.CustomScanner

/**
  * Created by shashank on 31/1/17.
  */
object GandhiTreeMarch {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val cases = customScanner.nextInt()
    for (test <- 1 to cases) {
      val col = customScanner.nextInt()
      var arrayList: List[Char] = List()
      val string = customScanner.next()
      val stack = new util.Stack[Noddy]()
      for (i <- 0 until string.length) {
        if (string.charAt(i) == ')') stack.pop()
        else if (string.charAt(i) >= 'a' && string.charAt(i) <= 'z') {
          val noddy = new Noddy
          noddy.char = string.charAt(i)
          if (stack.size() != 0) {
            if (!stack.peek().leftDone) {
              stack.peek().leftDone = true
              noddy.col = stack.peek().col - 1

            } else {
              stack.peek().rightDone = true
              noddy.col = stack.peek().col + 1

            }
          }
          if (noddy.col == col) {
            arrayList = arrayList :+ string.charAt(i)
            //arrayList.add(string.charAt(i))
          }
          stack.push(noddy)
        }
        else if (string.charAt(i) == '.') {
          if (stack.size() != 0) {
            if (!stack.peek().leftDone) {
              stack.peek().leftDone = true
            } else {
              stack.peek().rightDone = true
            }
          }
        }
      }
      if (arrayList.size != 0) {
        arrayList = arrayList.sorted
        for (i <- 0 until arrayList.length) {
          print(arrayList(i))
        }
      } else {
        print("Common Gandhijee!")
      }
      println()
    }
  }
}

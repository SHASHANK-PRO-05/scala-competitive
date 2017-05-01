
import java.io.PrintWriter
import java.util

import scala.io.StdIn._

class Node {
  var string = ""
  var count = 0
}

/**
  * Created by shashank on 8/4/17.
  */
object OversizedPancakeFlipper {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter("Output.txt")
    val t = readInt()
    for (test <- 1 to t) {
      val input = readLine().split(" ")
      val string = input(0)
      val m = input(1).toInt
      val hashSet = new util.HashMap[String, Int]
      hashSet.put(string, 0)
      val stack = new util.Stack[Node]()
      val newNode = new Node
      newNode.count = 0
      newNode.string = string
      var ans = Integer.MAX_VALUE
      stack.add(newNode)
      while (!stack.isEmpty) {
        val tempNode = stack.pop()
        if (tempNode.string.contains("-")) {
          for (i <- 0 to input(0).length - m) {
            val stringBuilder = new StringBuilder(tempNode.string)
            for (j <- i until m + i) {
              stringBuilder.charAt(j) match {
                case '+' => stringBuilder.setCharAt(j, '-')
                case '-' => stringBuilder.setCharAt(j, '+')
              }
            }
            if (stringBuilder.count(_ == '+') >= tempNode.string.count(_ == '+'))
              if (!hashSet.containsKey(stringBuilder.toString()) || hashSet.get(stringBuilder.toString()) > tempNode.count + 1) {
                //println(stringBuilder.toString() + " " + hashSet.get(stringBuilder.toString()) + " " + tempNode.count)
                val newNode = new Node
                newNode.string = stringBuilder.toString()
                newNode.count = tempNode.count + 1
                hashSet.put(stringBuilder.toString(), tempNode.count + 1)
                stack.push(newNode)
              }
          }
        }
        else {
          ans = math.min(ans, tempNode.count)
        }
      }
      if (ans != Integer.MAX_VALUE)
        printWriter.println("Case #" + test + ": " + ans)
      else
        printWriter.println("Case #" + test + ": IMPOSSIBLE")
    }
    printWriter.flush()
    printWriter.close()
  }

}

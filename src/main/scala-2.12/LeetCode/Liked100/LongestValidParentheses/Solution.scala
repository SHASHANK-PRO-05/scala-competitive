package LeetCode.Liked100.LongestValidParentheses


/**
  * Created by shanky on 11/5/17.
  */
object Solution {

  import java.util

  class IndexingChar {
    var character: Char = 0
    var index: Int = 0
  }

  def longestValidParentheses(s: String): Int = {
    val stack = new util.Stack[IndexingChar]()
    var stackElem = new IndexingChar()
    stackElem.character = ')'
    stackElem.index = -1
    stack.push(stackElem)
    var maxLen = 0
    for (index <- s.indices) {
      if (s.charAt(index) == '(') {
        val stackElem = new IndexingChar()
        stackElem.character = s.charAt(index)
        stackElem.index = index
        stack.push(stackElem)
      } else {
        if (!stack.isEmpty && stack.peek().character == '(')
          stack.pop()
        else {
          val stackElem = new IndexingChar()
          stackElem.character = s.charAt(index)
          stackElem.index = index
          stack.push(stackElem)
        }
      }
    }
    stackElem = new IndexingChar()
    stackElem.character = ')'
    stackElem.index = s.length
    stack.push(stackElem)
    while (stack.size() != 1) {
      val peek = stack.pop()
      maxLen = math.max(maxLen, peek.index - stack.peek().index - 1)
    }
    maxLen
  }

  def main(args: Array[String]): Unit = {
    println(longestValidParentheses("(())"))
  }
}

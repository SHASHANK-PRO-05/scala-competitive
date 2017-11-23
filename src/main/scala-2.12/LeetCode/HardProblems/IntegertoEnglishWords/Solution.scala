package LeetCode.HardProblems.IntegertoEnglishWords


/**
  * Created by shanky on 11/23/17.
  */
object Solution {

  import java.util

  def numberToWords(num: Int): String = {
    if (num == 0) return "Zero"

    var makeThisZero = if (num < 0) -num else num
    val blocks: Array[List[Int]] = Array(List(), List(), List(), List())
    var index = 0
    while (makeThisZero != 0) {
      blocks(index / 3) = blocks(index / 3) :+ (makeThisZero % 10 + '0')
      makeThisZero /= 10
      index += 1
    }
    val stack = new util.Stack[String]()
    for (i <- blocks.indices) {
      if (blocks(i).nonEmpty) {
        i match {
          case 0 => {
            val element = checkNumber(blocks(i))
            stack.push(element)
          }
          case 1 => {
            val element = checkNumber(blocks(i))
            if (!element.trim.equals(""))
              stack.push(element + " Thousand")
          }
          case 2 => {
            val element = checkNumber(blocks(i))
            if (!element.trim.equals(""))
              stack.push(element + " Million")
          }
          case 3 => {
            val element = checkNumber(blocks(i))
            if (!element.trim.equals(""))
              stack.push(element + " Billion")
          }
        }
      }
    }

    val stringBuilder = new StringBuilder("")
    if (num < 0)
      stringBuilder.append("Negative ")
    while (!stack.isEmpty) {
      stringBuilder.append(stack.pop() + " ")
    }
    stringBuilder.toString().trim
  }

  def checkNumber(list: List[Int]): String = {
    var stack = new util.Stack[String]()
    for (i <- list.indices) {
      if (i == 0) {
        stack.push(giveOnesNumber(list(i).toChar))
      } else if (i == 1) {
        if (list(i) == '1') {
          stack.pop()
          stack.push(specialTensNumber(list(i - 1).toChar))
        } else {
          stack.push(giveTensNumber(list(i).toChar))
        }
      } else {
        if (list(i) != '0')
          stack.push(giveOnesNumber(list(i).toChar) + " Hundred")
      }
    }
    val stringBuilder = new StringBuilder("")
    while (!stack.isEmpty) {
      val element = stack.pop()
      stringBuilder.append(element)
      if (!element.equals("")) {
        stringBuilder.append(" ")
      }
    }
    stringBuilder.toString().trim
  }

  def giveOnesNumber(char: Char): String = {
    char match {
      case '1' => "One"
      case '2' => "Two"
      case '3' => "Three"
      case '4' => "Four"
      case '5' => "Five"
      case '6' => "Six"
      case '7' => "Seven"
      case '8' => "Eight"
      case '9' => "Nine"
      case default => ""
    }
  }

  def specialTensNumber(char: Char): String = {
    char match {
      case '1' => "Eleven"
      case '2' => "Twelve"
      case '3' => "Thirteen"
      case '4' => "Fourteen"
      case '5' => "Fifteen"
      case '6' => "Sixteen"
      case '7' => "Seventeen"
      case '8' => "Eighteen"
      case '9' => "Nineteen"
      case default => "Ten"
    }
  }

  def giveTensNumber(char: Char): String = {
    char match {
      case '2' => "Twenty"
      case '3' => "Thirty"
      case '4' => "Forty"
      case '5' => "Fifty"
      case '6' => "Sixty"
      case '7' => "Seventy"
      case '8' => "Eighty"
      case '9' => "Ninety"
      case default => ""
    }
  }

  def main(args: Array[String]): Unit = {
    println(numberToWords(1000001))
    println(-12 % 10)
  }
}

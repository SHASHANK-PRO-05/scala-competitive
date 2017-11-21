package LeetCode.Weekly58.NumberofAtoms

import scala.collection.mutable

/**
  * Created by shanky on 11/16/17.
  */
object Solution {
  var i = 0

  def countOfAtoms(formula: String): String = {
    recurTheStructure(formula)
    formula
  }

  def readElement(string: String): String = {
    val stringBuilder = new StringBuilder(string.charAt(i) + "")
    i = i + 1
    while (i < string.length && string.charAt(i).isLower) {
      stringBuilder.append(string.charAt(i))
      i += 1
    }
    stringBuilder.toString()
  }

  def readDigit(string: String): Int = {
    var digit = 0
    while (i < string.length && string.charAt(i).isDigit) {
      digit = digit * 10 + (string.charAt(i).toInt)
    }
    if (digit == 0) 1 else digit
  }

  def recurTheStructure(string: String): mutable.HashMap[String, Int] = {
    val ansMap = new mutable.HashMap[String, Int]()
    while (i < string.length && string.charAt(i) != ')') {
      if (string.charAt(i) == '(') {
        i = i + 1
        val map = recurTheStructure(string)
        for ((key, element) <- map) {
          ansMap.put(key, ansMap.getOrElse(key, 0) + element)
        }
      } else {
        val element = readElement(string)
        val digit = readDigit(string)
        ansMap.put(element, ansMap.getOrElse(element, digit))
      }
    }
    i = i + 1
    val digit = readDigit(string)
    for ((key, element) <- ansMap) {
      ansMap.put(key, element * digit)
    }
    ansMap
  }

  def main(args: Array[String]): Unit = {
    countOfAtoms("Mg(OH)2");
  }
}

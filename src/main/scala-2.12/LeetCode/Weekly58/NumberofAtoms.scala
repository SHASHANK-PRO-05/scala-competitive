package LeetCode.Weekly58

import java.util

/**
  * Created by shanky on 11/12/17.
  */
object NumberofAtoms {
  def countOfAtoms(formula: String): String = {
    val stack = new util.Stack[String]()
    for (iter <- formula.indices) {
      formula(iter) match {
        case '(' => stack.push("(")
      }
    }
  }

  def main(args: Array[String]): Unit = {
    countOfAtoms("K4(ON(SO3)2)2")
  }
}

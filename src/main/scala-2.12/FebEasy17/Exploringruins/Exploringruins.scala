package FebEasy17.Exploringruins

import FastIO.CustomScanner

/**
  * Created by shashank on 1/2/17.
  */
object Exploringruins {
  var list: List[String] = List()

  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val string = customScanner.nextLine()
    find(string, 0)
    //println(list)
    println(list.sorted.head)
  }

  def find(string: String, index: Int): Unit = {
    if (index == string.length)
      list :+= string
    else if (string.charAt(index) == '?') {
      var done = false
      if (index > 0 && string.charAt(index - 1) != 'a') {
        if (index < string.length - 1 && string.charAt(index + 1) != 'a') {
          find(string.substring(0, index) + "a" + string.substring(index + 1, string.length), index + 1)
          done = true
        }
        else {
          find(string.substring(0, index) + "a", index + 1)
          done = true
        }
      }
      if (index == 0 && string.charAt(index + 1) != 'a') {
        done = true
        find(string.substring(0, index) + "a" + string.substring(index + 1, string.length), index + 1)
      }
      if (!done)
        find(string.substring(0, index) + "b" + string.substring(index + 1, string.length), index + 1)
    } else {
      find(string, index + 1)
    }
  }
}

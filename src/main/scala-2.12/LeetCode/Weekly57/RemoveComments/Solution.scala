package LeetCode.Weekly57.RemoveComments

/**
  * Created by shanky on 11/5/17.
  */
object Solution {
  def removeComments(source: Array[String]): List[String] = {
    val stringBuilder = new StringBuilder("")
    val ansBuilder = new StringBuilder("")
    var ansList: List[String] = List()
    for (iter <- source) stringBuilder.append(iter + "\n")
    var i = 0
    while (i < stringBuilder.length) {
      if (i >= 0 && stringBuilder.charAt(i) == '*' && ansBuilder.charAt(ansBuilder.length - 1) == '/') {
        ansBuilder.deleteCharAt(ansBuilder.length - 1)
        i = i + 1
        while (!(stringBuilder.charAt(i) == '*' && stringBuilder.charAt(i + 1) == '/'))
          i = i + 1
        i = i + 2
      } else if (i > 0 && stringBuilder.charAt(i) == '/' && ansBuilder.charAt(ansBuilder.length - 1) == '/') {
        ansBuilder.deleteCharAt(ansBuilder.length - 1)
        while (stringBuilder.charAt(i) != '\n')
          i = i + 1
        ansBuilder.append("\n")
        i = i + 1
      } else {
        ansBuilder.append(stringBuilder.charAt(i))
        i = i + 1
      }
    }
    for (iter <- ansBuilder.toString().split("\n")) {
      if (iter.length != 0) ansList = ansList :+ iter
    }
    ansList
  }


  def main(args: Array[String]): Unit = {
    println(removeComments(Array("/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}")))
  }
}

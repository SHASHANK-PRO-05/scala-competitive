

import java.io.{FileInputStream, PrintWriter}
import java.util.Scanner

import io.StdIn._
/**
  * Created by shashank on 8/4/17.
  */
object TidyNumbers {
  def main(args: Array[String]): Unit = {
    val scanner = new Scanner(new FileInputStream("Input.txt"))
    val printWriter = new PrintWriter("Output.txt")
    val t = readInt()
    for (test <- 1 to t) {
      val s = new StringBuilder(readLine())
      for (i <- s.length - 2 to 0 by -1) {
        if (s.charAt(i) > s.charAt(i + 1)) {
          s.setCharAt(i, (s.charAt(i) - 1).toChar)
          for (j <- i + 1 until s.length) {
            s.setCharAt(j, '9')
          }
        }
      }
      printWriter.println("Case #" + test + ": " + s.toLong)
    }
    printWriter.flush()
    printWriter.close()
  }
}

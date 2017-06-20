package DynamicProgramming.CountSubarrays

import java.io.InputStream
import java.util.InputMismatchException


/**
  * https://www.codechef.com/problems/SUBINC
  */
object Main {
  val inputStream: InputStream = System.in
  val stringBuilder = new StringBuilder
  val buffer = Array.ofDim[Byte](1024)
  var (ptrBuffer, lenBuffer) = (0, 0)

  def readByte(): Int = {
    if (lenBuffer == -1) throw new InputMismatchException()
    if (ptrBuffer >= lenBuffer) {
      ptrBuffer = 0
      lenBuffer = inputStream.read(buffer)
    }
    ptrBuffer += 1
    buffer(ptrBuffer - 1)
  }

  def ni(): Int = {
    var (num, b) = (0, readByte())
    var minus = false
    while (!(b >= '0' && b <= '9') && b != '-') b = readByte()
    if (b == '-') {
      minus = true
      b = readByte()
    }
    while (b >= '0' && b <= '9') {
      num = num * 10 + (b - '0')
      b = readByte()
    }
    if (minus) -num else num
  }

  def nai(n: Int): Array[Int] = {
    val array = Array.ofDim[Int](n)
    for (i <- 0 until n) array(i) = ni()
    array
  }

  def main(args: Array[String]): Unit = {
    val t = ni()
    //print("here")
    for (test <- 1 to t) {
      val n = ni()
      val array = nai(n)
      var count = 1L
      val dp = Array.ofDim[Int](n)
      dp(0) = 1
      var currentCount = 1
      for (i <- 1 until array.length) {
        if (array(i) >= array(i - 1)) {
          currentCount += 1
        } else {
          currentCount = 1
        }
        count += currentCount
      }
      stringBuilder.append(count + "\n")
    }
    println(stringBuilder)
  }
}

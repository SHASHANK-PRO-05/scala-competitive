package DynamicProgramming.PandaandXOR

import java.io.{InputStream, PrintWriter}
import java.util.InputMismatchException

/**
  * https://www.hackerearth.com/practice/algorithms/dynamic-programming/2-dimensional/practice-problems/algorithm/panda-and-xor/description/
  */
object Solution {
  val inputStream: InputStream = System.in
  val printWriter: PrintWriter = new PrintWriter(System.out)
  var buffer: Array[Byte] = Array.ofDim[Byte](1024)
  val stringBuilder = new StringBuilder()
  var (lenBuf, ptrBuf) = (0, 0)

  def ni(): Int = {
    var (num, b) = (0, readByte())
    var minus = false
    while (!(b >= '0' && b <= '9') && (b != '-')) b = readByte()
    if (b == '-') {
      minus = true
      b = readByte()
    }
    while (b >= '0' && b <= '9') {
      num = num * 10 + (b - '0')
      b = readByte()
    }
    num
  }

  def readByte(): Int = {
    if (ptrBuf >= lenBuf) {
      ptrBuf = 0
      lenBuf = inputStream.read(buffer)
      if (lenBuf <= 0) throw new InputMismatchException()
    }
    ptrBuf += 1
    buffer(ptrBuf - 1)
  }

  def nai(n: Int): Array[Int] = {
    val array = Array.ofDim[Int](n)
    for (i <- 0 until n) array(i) = ni()
    array
  }

  val mod: Int = 1000000007

  def solve(): Unit = {
    val n = ni()
    val array = nai(n)
    val dp = Array.ofDim[Int](n + 1, 129)
    for (i <- 1 to n) {
      for (j <- 0 to 128) {
        if (dp(i - 1)(j) != 0) {
          val temp = j ^ array(i - 1)
          dp(i)(temp) = dp(i - 1)(j) + dp(i)(temp)
        }
      }
      for (j <- 0 to 128) {
        dp(i)(j) += dp(i - 1)(j)
      }
      dp(i)(array(i - 1)) += 1
    }
    var finalAns = 0
    for (i <- dp(n).indices) {
      var temp = dp(n)(i) * (dp(n)(i) - 1)
      temp /= 2
      finalAns += temp
    }
    stringBuilder.append(finalAns)
    printWriter.println(stringBuilder)
  }

  def run(): Unit = {
    val current = System.currentTimeMillis()
    solve()
    printWriter.flush()
  }

  def main(args: Array[String]): Unit = {
    run()
  }
}

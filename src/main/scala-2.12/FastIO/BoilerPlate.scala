package FastIO

import java.io.{ByteArrayInputStream, InputStream, PrintWriter}
import java.util.InputMismatchException

import scala.collection.mutable

object BoilerPlate {
  var inputStream: InputStream = _
  var printWriter: PrintWriter = _
  var input = ""
  val buffer = Array.ofDim[Byte](1024)
  var (lenBuf, ptrBuf) = (0, 0)

  @throws(classOf[Exception])
  def run(): Unit = {
    inputStream = if (input.isEmpty) System.in else new ByteArrayInputStream(input.getBytes())
    printWriter = new PrintWriter(System.out)
    val s: Long = System.currentTimeMillis()
    solve()
    printWriter.flush()
    if (!input.isEmpty) tr((System.currentTimeMillis() - s) + "ms")
  }


  def solve(): Unit = {
    val n = ni()
    //println(n)
    val a = nai(n)
    val b = nai(n)
    val map = new mutable.HashMap[Int, Int]()
    //println("here")
    for (i <- a.indices) {
      map.put(a(i), math.max(map.getOrElseUpdate(a(i), 0), b(i)))
    }
    for (i <- a.indices) {
      printWriter.append(map.getOrElse(a(i), 0) + " ")
    }
  }

  /**
    * This function helps in reading input stream byte by byte
    *
    * @throws java.lang.Exception
    * @return
    */
  @throws(classOf[Exception])
  def readByte(): Int = {
    if (lenBuf == -1) throw new InputMismatchException()
    if (ptrBuf >= lenBuf) {
      ptrBuf = 0
      lenBuf = inputStream.read(buffer)
      if (lenBuf <= 0) return -1
    }
    ptrBuf += 1
    buffer(ptrBuf - 1)
  }

  def nad(n: Int): Array[Double] = {
    val array = Array.ofDim[Double](n)
    for (i <- 0 until n) {
      array(i) = ns().toDouble
    }
    array
  }

  def nd(): Double = ns().toDouble

  def isSpaceChar(c: Int): Boolean = !(c >= 33 && c <= 126)

  def skip(): Int = {
    var b = readByte()
    while (b == -1 || isSpaceChar(b)) b = readByte()
    b
  }

  def ns(): String = {
    var b = skip()
    var stringBuilder = new mutable.StringBuilder()
    while (!isSpaceChar(b)) {
      /**
        * appendCodePoint not available in scala but java has this
        */
      stringBuilder.append(b.toChar)
      b = readByte()
    }
    stringBuilder.toString()
  }

  /**
    * Returns next array of Long
    *
    * @param n
    * @return
    */
  def nal(n: Int): Array[Long] = {
    val array = Array.ofDim[Long](n)
    for (i <- 0 until n) array(i) = nl()
    array
  }

  @throws(classOf[Exception])
  def nl(): Long = {
    var (num, b) = (0: Long, 0)
    var minus = false
    while (!(b <= '0' && b >= '9') && !(b == '-')) b = readByte()
    if (b == '-') {
      minus = true
      b = readByte()
    }
    while (b >= '0' && b <= '9') {
      num = num * 10 + (b - '0').toLong
    }
    num
  }

  /**
    * Returns next array of integers
    *
    * @param n
    * @return
    */
  def nai(n: Int): Array[Int] = {
    val array = Array.ofDim[Int](n)
    for (i <- 0 until n) array(i) = ni()
    array
  }

  /**
    * NextInt function for getting the next Int value
    *
    * @throws java.lang.Exception
    * @return
    */
  @throws(classOf[Exception])
  def ni(): Int = {
    //println("here")
    var (num, b) = (0, readByte())
    var minus = false
    while ((b <= '0' && b >= '9') && !(b == '-')) b = readByte()
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

  def tr(ob: Object*): Unit = {
    val wrap: mutable.WrappedArray[Object] = ob.asInstanceOf[mutable.WrappedArray[Object]]
    println(wrap.deep.mkString("\n"))
  }

  @throws(classOf[Exception])
  def main(args: Array[String]): Unit = {
    run()
  }
}

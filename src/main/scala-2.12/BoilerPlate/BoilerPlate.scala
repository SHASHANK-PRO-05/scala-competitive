package BoilerPlate

import java.util.InputMismatchException

object BoilerPlate {
  val stream = System.in
  val stringBuilder = new StringBuilder
  var (curChar, numChar) = (0, 0)
  var buffer = Array.ofDim[Byte](1024)

  def read(): Int = {
    if (numChar <= curChar) {
      curChar = 0
      numChar = stream.read(buffer)
      if (numChar <= 0) return -1
    }
    curChar = curChar + 1
    buffer(curChar - 1)
  }

  def isSpacedChar(b: Int) = b == ' ' || b == '\n' || b == '\r' || b == '\t' || b == -1

  def readLong(): Long = {
    var num = 0L
    var b = read()
    while (isSpacedChar(b)) b = read()
    var negative = false
    if (b == '-') {
      negative = true
      b = read()
    }
    while (!isSpacedChar(b)) {
      if (b < '0' || b > '9') throw new InputMismatchException()
      num = num * 10 + (b - '0')
      b = read()
    }
    if (negative) -num else num
  }

  def readInt(): Int = readLong().toInt

  def readArrayLong(n: Int): Array[Long] = {
    val array = Array.ofDim[Long](n)
    for (i <- array.indices) array(i) = readLong()
    array
  }

  def readArrayInt(n: Int): Array[Int] = {
    val array = Array.ofDim[Int](n)
    for (i <- array.indices) array(i) = readInt()
    array
  }

  def solve(): Unit = {
    val tc = readInt()
    for (i <- 1 to tc) {

    }
  }

  def readString(): String = {
    val builder = new StringBuilder
    var b = read()
    while (isSpacedChar(b)) b = read()
    while (!isSpacedChar(b)) {
      builder.append(b.toChar)
      b = read()
    }
    builder.toString()
  }

  def main(args: Array[String]): Unit = {

  }
}

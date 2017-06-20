package DynamicProgramming.WayOut

/**
  * Created by shanky on 6/6/17.
  */
object Main {
  val inputStream = System.in
  val buffer = Array.ofDim[Byte](1024)
  val stringBuilder = new StringBuilder
  var (ptr, lenBuf) = (0, 0)

  def readByte(): Int = {
    if (ptr >= lenBuf) {
      ptr = 0
      lenBuf = inputStream.read(buffer)
    }
    ptr += 1
    buffer(ptr - 1)
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
    num
  }

  def main(args: Array[String]): Unit = {
    val t = ni()
    for (test <- 1 to t) {
      val (n, h) = (ni(), ni())
      val array = Array.ofDim[Int](n + 1)
      array(0) = n
      for (i <- 0 until n) {
        val (temp1, temp2) = (ni(), ni())
        array(temp1) -= 1
        array(temp2 + 1) += 1
      }
      for (i <- 1 to n) {
        array(i) += array(i - 1)
      }
      var finalAns: Long = 0
      var curr: Long = 0
      for (i <- 0 until h) {
        curr += array(i)
      }
      finalAns = curr
      for (i <- h until n) {
        curr = curr + array(i) - array(i - h)
        finalAns = math.min(finalAns, curr)
      }
      stringBuilder.append(finalAns + "\n")
    }
    println(stringBuilder)
  }
}

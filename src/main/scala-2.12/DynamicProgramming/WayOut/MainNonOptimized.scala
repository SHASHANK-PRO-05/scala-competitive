package DynamicProgramming.WayOut

/**
  * https://www.codechef.com/problems/WOUT
  */
object MainNonOptimize {
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
      var (n, h) = (ni(), ni())
      val array = Array.ofDim[Int](n, n)
      for (i <- 0 until n) {
        val (x, y) = (ni(), ni())
        for (j <- 0 until x) {
          array(i)(j) = 1
        }
        for (j <- y + 1 until n) {
          array(i)(j) = 1
        }
      }
//      for (i <- 0 until n) {
//        println(array(i).deep.mkString(" "))
//      }
      for (i <- 1 until n) {
        for (j <- 0 until n) {
          array(i)(j) += array(i - 1)(j)
        }
      }

      var minSum = Int.MaxValue
      var countSum = 0
      for (i <- 0 until h) {
        countSum += array(n - 1)(i)
      }
      minSum = Math.min(minSum, countSum)
      for (i <- h until n) {
        countSum = countSum - array(n - 1)(i - h) + array(n - 1)(i)
        minSum = Math.min(minSum, countSum)
      }
      stringBuilder.append(minSum + "\n")
    }
    println(stringBuilder)
  }
}

package DynamicProgramming.AloknathandHisSanskars

/**
  * https://www.codechef.com/problems/SANSKAR
  */
object Main {
  val inputStream = System.in
  val stringBuilder = new StringBuilder
  val buffer = Array.ofDim[Byte](1024)
  var (ptr, lenBuf) = (0, 0)

  def readByte(): Int = {
    if (ptr >= lenBuf) {
      ptr = 0
      lenBuf = inputStream.read(buffer)
    }
    ptr += 1
    buffer(ptr - 1)
  }

  def nl(): Long = {
    var (num, b) = (0L, readByte())
    var minus = false
    while (!(b >= '0' && b <= '9') && b != '-') b = readByte()
    if (b == '-') {
      b = readByte()
      minus = true
    }
    while (b >= '0' && b <= '9') {
      num = num * 10L + (b - '0').toLong
      b = readByte()
    }
    if (minus) -num else num
  }

  def nal(n: Int): Array[Long] = {
    val array = Array.ofDim[Long](n)
    for (i <- 0 until n) array(i) = nl()
    array
  }

  def ni(): Int = {
    var (num, b) = (0, readByte())
    var minus = false
    while (!(b >= '0' && b <= '9') && b != '-') b = readByte()
    if (b == '-') {
      b = readByte()
      minus = true
    }
    while (b >= '0' && b <= '9') {
      num = num * 10 + (b - '0')
      b = readByte()
    }
    if (minus) -num else num
  }

  def main(args: Array[String]): Unit = {
    val t = ni()
    for (test <- 1 to t) {
      val (n, k) = (ni(), nl())
      val array = nal(n)
      val sum = array.sum
      if (sum % k != 0 || k > n) stringBuilder.append("no\n")
      else if (sum == 0) stringBuilder.append("yes\n")
      else {
        val x = sum / k
        val limit = 1 << n
        val dp = Array.ofDim[Boolean]((k + 1).toInt, limit)
        dp(0)(0) = true
        for (i <- 0 until k.toInt) {
          for (j <- 0 until limit) { //j is bitmask
            if (dp(i)(j)) {
              var sum = 0l
              for (l <- 0 until n) {
                if ((j & (1 << l)) != 0) sum += array(l)
              }
              sum -= i * x
              for (l <- 0 until n) {
                val temp = j | (1 << l)
                if (!dp(i)(temp)) {
                  val dummy = sum + array(l)
                  if (sum + array(l) == x) dp(i + 1)(temp) = true
                  else if (sum + array(l) < x) dp(i)(temp) = true
                }
              }
            }
          }
        }
        if (dp(k.toInt)(limit - 1)) stringBuilder.append("yes\n")
        else stringBuilder.append("no\n")
      }
    }
    println(stringBuilder)
  }
}

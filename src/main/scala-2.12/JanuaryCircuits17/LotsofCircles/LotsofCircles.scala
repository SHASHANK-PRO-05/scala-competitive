package JanuaryCircuits17.LotsofCircles

import FastIO.CustomScanner

/**
  * Created by shashank on 21/1/17.
  */
object LotsofCircles {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val n = customScanner.nextInt()
    val stringBuilder = new StringBuilder
    val quad1 = Array(0L, 0L)
    val quad2 = Array(0L, 0L)
    val quad3 = Array(0L, 0L)
    val quad4 = Array(0L, 0L)
    var leaveQuad1 = 0
    var leaveQuad2 = 0
    var leaveQuad3 = 0
    var leaveQuad4 = 0
    var maxLeave1 = 0
    var maxLeave2 = 0
    val maxLeave3 = 0
    val maxLeave4 = 0
    for (iter <- 0 until n) {
      val radius = customScanner.nextLong()
      val weight = customScanner.nextLong()
      if (iter % 4 == 0) {
        if (quad1(0) + radius > 1000000000) {
          quad1(0) = 0
          leaveQuad1 += (2 * maxLeave1)
          quad1(1) = leaveQuad1
        }
        quad1(0) += radius
        quad1(1) += radius

        stringBuilder.append(quad1(0) + " " + quad1(1) + "\n")
      } else if (iter % 4 == 1) {
        quad2(0) -= radius
        quad2(1) -= radius
        stringBuilder.append(quad2(0) + " " + quad2(1) + "\n")
      } else if (iter % 4 == 2) {
        quad3(0) += radius
        quad3(1) -= radius
        stringBuilder.append(quad3(0) + " " + quad3(1) + "\n")
      } else {
        quad4(0) -= radius
        quad4(1) += radius
        stringBuilder.append(quad4(0) + " " + quad4(1) + "\n")
      }
    }
    println(stringBuilder)
  }
}

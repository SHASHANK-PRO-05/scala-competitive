package DynamicProgramming.NextLuckyNumber

import FastIO.CustomScanner

object Solution {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    val tests = customScanner.nextInt()
    for (t <- 1 to tests) {
      var builder = new StringBuilder(customScanner.nextLine())
      var remainder = 1
      for (i <- builder.length - 1 to 0 by -1) {
        if (builder.charAt(i) == '9') {
          if (remainder == 1) {
            remainder = 1
            builder.setCharAt(i, '0')
          }
        } else {
          builder.setCharAt(i, (builder.charAt(i) + remainder).toChar)
          remainder = 0
        }
      }
      builder = new StringBuilder(((remainder + '0').toChar + "") + builder)
      //println(builder)
      remainder = 0
      for (i <- builder.length - 1 to 1 by -1) {
        if (remainder == 1) {
          if (builder.charAt(i) == '9') {
            builder.setCharAt(i, '0')
          } else {
            builder.setCharAt(i, (builder.charAt(i) + remainder).toChar)
            remainder = 0
          }
        }
        //println(i + ": " + builder)
        if (builder.charAt(i) != '5' && builder.charAt(i) != '3') {
          if (builder.charAt(i) > '5') {
            //println(i + ": " + builder)
            remainder = 1
            builder.setCharAt(i, '3')
            //println(i + ": " + builder)
          } else if (builder.charAt(i) > '3' && builder.charAt(i) < '5') {
            builder.setCharAt(i, '5')
            //println(i + ": " + builder)
          } else {
            builder.setCharAt(i, '3')
          }
          for (j <- i + 1 until builder.length) {
            builder.setCharAt(j, '3')
          }
        }
        //println(i + ": " + builder)
      }
      //println(remainder)
      if (remainder == 1 || builder.charAt(0) == '1') {
        var i = 0
        builder.setCharAt(i, 3)
        for (j <- i until builder.length) {
          builder.setCharAt(j, '3')
        }
      } else {
        //println(builder)
        builder = new StringBuilder(builder.substring(1, builder.length))
      }
      println(builder)
    }
  }
}

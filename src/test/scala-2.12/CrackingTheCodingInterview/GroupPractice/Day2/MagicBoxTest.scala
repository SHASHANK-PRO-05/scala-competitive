package CrackingTheCodingInterview.GroupPractice.Day2

import org.scalatest.FlatSpec

/**
  * Created by shashank on 13/2/17.
  */
class MagicBoxTest extends FlatSpec {
  "Sum of each row" should "be equal to formula n(n^2+1)/2" in {
    var n = (math.random() * 1000).toInt
    if (n % 2 == 0)
      n += 1
    val temp = MagicBox.oddMagicBox(n)
    for (i <- 0 until n) {
      var sum = 0L
      for (j <- 0 until n) {
        sum += temp(i)(j)
      }
      assert(sum == (n * (n * n + 1) / 2))
    }
  }
  "Sum of each col" should "be equal to formula n(n^2+1)/2" in {
    var n = (Math.random() * 1000).toInt
    if (n % 2 == 0)
      n += 1
    val temp = MagicBox.oddMagicBox(n)
    for (i <- 0 until n) {
      var sum = 0L
      for (j <- 0 until n) {
        //print(temp(i)(j) + " ")
        sum += temp(j)(i)
      }
      //println()
      assert(sum == (n * (n * n + 1) / 2))
    }
  }
  "Sum of diagonals" should "be equal to formula n(n^2+1)/2" in {
    var sum1 = 0L
    var sum2 = 0L
    var n = (Math.random() * 1000).toInt
    if (n % 2 == 0)
      n += 1
    val temp = MagicBox.oddMagicBox(n)
    for (i <- 0 until n) {
      sum1 += temp(i)(i)
      sum2 += temp(i)(n - i - 1)
    }
    assert(sum1 == sum2 && sum1 == n * (n * n + 1) / 2)
  }
}

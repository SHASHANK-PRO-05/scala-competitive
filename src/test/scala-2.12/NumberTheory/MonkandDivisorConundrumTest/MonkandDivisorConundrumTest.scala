package NumberTheory.MonkandDivisorConundrumTest

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FlatSpec
import NumberTheory.MonkandDivisorConundrum.MonkandDivisorConundrum._

/**
  * Created by home on 12/24/2016.
  */
@RunWith(classOf[JUnitRunner])
class MonkandDivisorConundrumTest extends FlatSpec {
  //"MonkandDivisorConundrumTest" should "solve the conundrum" in {
  //    for (j <- 1 to 100) {
  //      val size = rand()
  //      var arr = new Array[Int](size)
  //      var max = 0
  //      for (i <- 0 to size - 1) {
  //        arr(i) = rand()
  //        max = Math.max(max, arr(i)).toInt
  //      }
  //      println("Max " + max)
  //      val queryArray = findMonkandDivisorConundrumBase(arr, max, size)
  //      val q = rand()
  //      for (i <- 1 to q) {
  //        val q = rand()
  //        val p = rand()
  //        val ans1 = bruteForce(p, q, arr)
  //        val ans2 = findAns(p, q, queryArray)
  //        //        println("Test Number " + j)
  //        //        println("Array")
  //        //        for (k <- 1 to size) {
  //        //          print(arr(k - 1) + " ")
  //        //        }
  //        //        println()
  //        //        println("Max " + max)
  //        //        for (k <- 0 to max) {
  //        //          print(queryArray(k) + " ")
  //        //        }
  //        //        println()
  //        //        println("P :" + p + " Q :" + q)
  //        println(ans1 + " " + ans2)
  //        assert(ans1 == ans2)
  //      }
  //    }
  //
  // }

  def bruteForce(p: Int, q: Int, arr: Array[Int]): Int = {
    var ans = 0;
    for (i <- 0 to arr.size - 1) {
      if (arr(i) % p == 0 || arr(i) % q == 0) {
        //println("This is crap " + arr(i) + " " + p + " " + q)
        ans += 1
      }

    }
    ans
  }

  def rand(): Int = {
    var temp = (Math.random() * 2 * 10000).toInt
    while (temp == 0) {
      temp = (Math.random() * 2 * 10000).toInt
    }
    temp
  }
}

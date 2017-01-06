package NumberTheory.MonkandFredoTest

import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.junit.JUnitRunner
import NumberTheory.MonkandFredo.MonkandFredo._
import scala.collection.mutable

/**
  * Created by home on 12/30/2016.
  */
@RunWith(classOf[JUnitRunner])
class MonkandFredo extends FlatSpec {
  "MonkandFredo" should "help fredo from getting out from the problem of monk" in {
    val t = randInt()
    for (i <- 1 to t) {
      val a = randAnB()
      val b = randAnB()
      val c = rand()
      println(a + " " + b + " " + c + " " + findAns(a, b, c) + " " + dpWay(a, b, c))
      assert(dpWay(a, b, c) === findAns(a, b, c))
    }
  }

  def dpWay(a: Long, b: Long, c: Long): Long = {
    val map = mutable.HashMap[Long, Long]()
    map(0) = 1L
    val listCoins = Array(a, b)
    for (i <- 0 to listCoins.length - 1) {
      for (j <- listCoins(i) to c) {
        map(j) = map.getOrElse(j, 0L) + map.getOrElse(j - listCoins(i), 0L)
      }
    }
    map.getOrElse(c, 0)
  }

  def randInt(): Int = {
    (Math.random() * 100000).toInt
  }
  def randAnB():Long={
    (Math.random() * 100).toLong
  }
  def rand(): Long = {
    (Math.random() * 100000).toLong
  }
}

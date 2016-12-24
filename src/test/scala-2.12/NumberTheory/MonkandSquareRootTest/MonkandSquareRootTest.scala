package NumberTheory.MonkandSquareRootTest

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FlatSpec

import NumberTheory.MonkandSquareRoot._

/**
  * Created by home on 12/24/2016.
  */
@RunWith(classOf[JUnitRunner])
class MonkandSquareRootTest extends FlatSpec {
//  "reverseQuadraticResidueMinima" should " be giving as brute force will do" in {
//    for (i <- 1 to 100) {
//      var randomVals = rand()
//      val brute = bruteForce(randomVals);
//      val check = MonkandSquareRoot.findReverseQuadraticResidue(randomVals(0), randomVals(1))
//      println(randomVals(0) + " " + randomVals(1) + " " + brute + " " + check);
//      assert(brute === check)
//    }
//  }

  def rand(): List[Long] = {
    var n: Long = (Math.random() * 900000).toLong;
    var m: Long = (Math.random() * 1000000).toLong
    while (m < n) {
      m = (Math.random() * 1000000).toLong
    }
    n %= m
    List(n, m)
  }

  def bruteForce(list: List[Long]): Long = {
    for (i <- 0L to (list(1) / 2L).toLong) {
      if ((i * i) % list(1) == list(0))
        return i.toLong
    }
    -1L
  }
}

package CrackingTheCodingInterview.Chapter1_ArraysAndStrings.Q1

import org.scalatest.{FlatSpec, Matchers}
import CrackingTheCodingInterview.Chapter1_ArraysAndStrings.Q1.UniqueString

/**
  * Created by shashank on 5/2/17.
  */
class Q1_Test extends FlatSpec with Matchers {
  "UniqueString" should "Return true on bruteForce" in {
    new UniqueString("56789").checkBruteForce() should be(true)
  }
  it should "Return false on tradeOff" in {
    new UniqueString("598765").tradeOff() should be(false)
  }
  it should "Return false on checkOnlyA_ZOra_zOr0_9" in {
    new UniqueString("5a906tgAa").checkOnlyA_ZOra_zOr0_9() should be(false)
  }
  it should "Return false on anythingFromBitWiseArrayOf4" in {
    new UniqueString("aa").anythingFromBitWiseArrayOf4() should be(false)
  }
}

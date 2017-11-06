package Internships.HA.Main.FinalDiscountedPrice

import scala.collection.mutable.ListBuffer

/**
  * Created by shanky on 9/24/17.
  */
object Solution {
  def finalPrice(prices: Array[Int]) = {
    import scala.collection.mutable.ListBuffer
    val arrayCheck = Array.ofDim[Int](prices.length)
    arrayCheck(prices.length - 1) = prices.length
    for (i <- prices.length - 2 to 0 by -1) {
      var j = i + 1
      if (prices(i) >= prices(j)) {
        arrayCheck(i) = j
      } else {
        while (j != prices.length && prices(j) > prices(i)) {
          j = arrayCheck(j)
        }
        arrayCheck(i) = j
      }
    }
    //println(arrayCheck.toList)
    var ans: Long = 0L
    var list = new ListBuffer[Int]()
    for (iter <- arrayCheck.indices) {
      if (arrayCheck(iter) != arrayCheck.length) {
        ans = ans + (prices(iter) - prices(arrayCheck(iter)))
      } else {
        ans += prices(iter)
        list += iter
      }
    }
    println(ans)
    list.sorted.foreach(x => print(x + " "))
  }

  def main(args: Array[String]): Unit = {
    finalPrice(Array(5, 1, 3, 4, 6, 2))
  }

}

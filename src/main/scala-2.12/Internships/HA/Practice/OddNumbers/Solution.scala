package Internships.HA.Practice.OddNumbers




/**
  * Created by shanky on 9/24/17.
  */
object Solution {
  //def toIntArray(list: util.ArrayList[Int]): Array[Int] = list.toArray(_.toInt)

  def oddNumbers(l: Int, r: Int): Array[Int] = {
    import scala.collection.mutable.ListBuffer

    var array = new ListBuffer[Int]
    if (l % 2 == 0) {
      for (i <- l + 1 to r by 2)
        array += i
    } else {
      for (i <- l to r by 2) {
        array += i
      }

    }
    array.toArray
  }

  def main(args: Array[String]): Unit = {
    println(oddNumbers(1, 5))
  }

}

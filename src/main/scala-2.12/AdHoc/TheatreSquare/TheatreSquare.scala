


/**
  * Created by home on 12/21/2016.
  */

import scala.io.StdIn._

object Main {


  def main(args: Array[String]): Unit = {
    val temps = readLine().split(" ").map(_.toLong)
    val n = temps(0)
    val m = temps(1)
    val a = temps(2)
    val ans = Math.ceil(n.toDouble / a) * Math.ceil(m.toDouble / a)
    println(ans.toLong)
  }
}

package Internships.HA.Main.ArrangeTheWords


/**
  * Created by shanky on 9/24/17.
  */

object Solution {


  def arrange(sentence: String): String = {
    class Token extends Ordered[Token] {
      var string: String = _
      var token: Int = _

      def compare(that: Token): Int = {

        if (this.string.length > that.string.length) 1
        else if (this.string.length < that.string.length) -1
        else if (this.string.length == that.string.length) {
          if (this.token < that.token) -1
          else if (this.token > that.token) 1
          else 0
        }
        else 0
      }
    }
    val array = sentence.replace(".", "").trim().replaceAll(" +", " ").toLowerCase().split(" ")
    var arrayOfToken = Array.ofDim[Token](array.length)
    for (i <- array.indices) {
      arrayOfToken(i) = new Token()
      arrayOfToken(i).string = array(i)
      arrayOfToken(i).token = i
    }
    arrayOfToken.sorted
    var ans = StringBuilder.newBuilder
    ans.append(arrayOfToken(0).string(0).toUpper + "" + arrayOfToken(0).string.substring(1) + " ")
    for (i <- 1 until array.length - 1) {
      ans.append(arrayOfToken(i).string + " ")
    }
    ans.append(arrayOfToken(array.length - 1).string + ".")
    ans.toString()
    //    ans.append(array(array.length - 1) + ".")
    //    ans.toString()
  }

  def main(args: Array[String]): Unit = {
    println(arrange("The lines are printed in reverse order."))
  }
}

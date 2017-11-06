package LeetCode.Weekly52.RepeatedStringMatch

/**
  * Created by shanky on 9/30/17.
  */
object Solution {


  def repeatedStringMatch(A: String, B: String): Int = {
    if (A.contains(B)) return 1
    if((A+A).contains(B)) return 2
    if (!B.contains(A)) return -1
    var index = B.indexOf(A)
    var j = index
    var ans = 0
    while (j + A.length < B.length && B.substring(j, j + A.length).equals(A)) {
      ans += 1
      j = j + A.length
    }
    if (j + A.length == B.length && B.substring(j, j + A.length).equals(A)) ans += 1
    else if ((B.substring(j, B.length) + B.substring(0, index)).equals(A)) ans += 2
    else if ((B.length - j) <= A.length && (B.substring(j, B.length) + B.substring(0, A.length - (B.length - j))).equals(A)) ans += 1
    else ans = -1
    ans
  }

  def main(args: Array[String]): Unit = {
    println(repeatedStringMatch("bb",
      "bbbbbbb"))
  }
}

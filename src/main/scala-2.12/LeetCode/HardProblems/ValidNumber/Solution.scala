package LeetCode.HardProblems.ValidNumber


/**
  * Created by shanky on 11/22/17.
  */
object Solution {

  import scala.collection.mutable

  var finals = List("q2", "q5", "q8", "q4")

  def isNumber(temp: String): Boolean = {
    val s = temp.trim()
    var startState = "q0"
    var i = 0
    var hashMap = new mutable.HashMap[String, List[(Int, String)]]()
    hashMap.put("q0", List(('+', "q1"), ('-', "q1"), (0, "q1")))
    hashMap.put("q1", List(('0', "q2")
      , ('1', "q2"), ('2', "q2"), ('3', "q2")
      , ('4', "q2"), ('5', "q2"), ('6', "q2")
      , ('7', "q2"), ('8', "q2"), ('9', "q2")
      , ('.', "q3")))
    hashMap.put("q2", List(('0', "q2")
      , ('1', "q2"), ('2', "q2"), ('3', "q2")
      , ('4', "q2"), ('5', "q2"), ('6', "q2")
      , ('7', "q2"), ('8', "q2"), ('9', "q2")
      , ('.', "q4"), ('e', "q6")))
    hashMap.put("q3", List(('0', "q5")
      , ('1', "q5"), ('2', "q5"), ('3', "q5")
      , ('4', "q5"), ('5', "q5"), ('6', "q5")
      , ('7', "q5"), ('8', "q5"), ('9', "q5")))
    hashMap.put("q4", List(('0', "q5")
      , ('1', "q5"), ('2', "q5"), ('3', "q5")
      , ('4', "q5"), ('5', "q5"), ('6', "q5")
      , ('7', "q5"), ('8', "q5"), ('9', "q5"), ('e', "q6")))
    hashMap.put("q5", List(('0', "q5")
      , ('1', "q5"), ('2', "q5"), ('3', "q5")
      , ('4', "q5"), ('5', "q5"), ('6', "q5")
      , ('7', "q5"), ('8', "q5"), ('9', "q5"), ('e', "q6")))
    hashMap.put("q6", List(('+', "q7"), ('-', "q7")))
    hashMap.put("q7", List(('0', "q8")
      , ('1', "q8"), ('2', "q8"), ('3', "q8")
      , ('4', "q8"), ('5', "q8"), ('6', "q8")
      , ('7', "q8"), ('8', "q8"), ('9', "q8")
    ))
    hashMap.put("q8", List(('0', "q8")
      , ('1', "q8"), ('2', "q8"), ('3', "q8")
      , ('4', "q8"), ('5', "q8"), ('6', "q8")
      , ('7', "q8"), ('8', "q8"), ('9', "q8")))
    while (i < s.length) {
      if (startState.equals("q0") || startState.equals("q6")) {
        val list = hashMap.getOrElse(startState, null)
        val index = list.indexWhere(x => {
          x._1 == s.charAt(i)
        })
        if (index == -1) {
          if (startState == "q0") startState = "q1"
          else startState = "q7"
        }
      }
      val list = hashMap.getOrElse(startState, null)
      val index = list.indexWhere(x => {
        x._1 == s.charAt(i)
      })
      if (index == -1) {
        return false
      }
      startState = list(index)._2
      i += 1
    }
    if (finals.contains(startState))
      true
    else
      false
  }

  def main(args: Array[String]): Unit = {
    println(isNumber("6e6"))
  }
}

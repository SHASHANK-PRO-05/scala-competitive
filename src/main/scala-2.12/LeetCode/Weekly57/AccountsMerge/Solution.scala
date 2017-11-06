package LeetCode.Weekly57.AccountsMerge

import scala.collection.mutable

/**
  * Created by shanky on 11/4/17.
  */
object Solution {

  class EMail(email: String, name: String) {
    var emailList = mutable.HashSet[String]()
    var visited = false
    var globalName = name
    var thisEmail = email
  }

  def accountsMerge(accounts: List[List[String]]): List[List[String]] = {
    var hashMap = new mutable.HashMap[String, EMail]()
    for (list <- accounts) {
      for (iter <- list.tail) {
        if (!hashMap.contains(iter)) {
          val emailObject = new EMail(iter, list.head)
          emailObject.emailList ++= list.tail
          hashMap.put(iter, emailObject)
        } else {
          val emailObject = hashMap.getOrElse(iter, null)
          emailObject.emailList ++= list.tail
          hashMap.put(iter, emailObject)
        }
      }
    }
    var ansList: List[List[String]] = List()

    for ((key, value) <- hashMap) {
      if (!value.visited) {
        val queue = new mutable.Queue[EMail]()
        val set = new mutable.HashSet[String]()
        val name = value.globalName
        queue.enqueue(value)
        while (!queue.isEmpty) {
          val topElem = queue.dequeue()
          topElem.visited = true
          set.add(topElem.thisEmail)
          for (iter <- topElem.emailList) {
            if (!hashMap.getOrElse(iter, null).visited) {
              queue.enqueue(hashMap.getOrElse(iter, null))
            }
          }
        }
        ansList = ansList :+ (List(name) ++ set.toList.sortWith(_ < _))
      }
    }
    ansList
  }

  def main(args: Array[String]): Unit = {
    println(accountsMerge(List(List("David","David0@m.co","David1@m.co"),List("David","David3@m.co","David4@m.co"),List("David","David4@m.co","David5@m.co"),List("David","David2@m.co","David3@m.co"),List("David","David1@m.co","David2@m.co"))))
  }
}

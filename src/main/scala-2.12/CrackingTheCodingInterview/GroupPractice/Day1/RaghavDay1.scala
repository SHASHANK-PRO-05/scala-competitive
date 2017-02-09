package CrackingTheCodingInterview.GroupPractice.Day1

/**
  * Created by shashank on 9/2/17.
  */
object RaghavDay1 {
  def main(args: Array[String]): Unit = {
    val firstLinkedList = new LinkedList(1, new LinkedList(2, new LinkedList(10, new LinkedList(4, null))))
    val secondLinkedList = new LinkedList(5, new LinkedList(6, new LinkedList(9, firstLinkedList.getNext().getNext())))
    println(intersectionDetector(firstLinkedList, secondLinkedList).getElem())
    //println(floydCycleDetector(secondLinkedList))
  }

  def intersectionDetector(firstList: LinkedList, secondList: LinkedList): LinkedList = {
    //element which will be returned
    var node: LinkedList = null
    //lastElement in the first linked list
    var lastFirstLinked = firstList
    //iterating to get the last element
    var lengthFirst = 1
    while (lastFirstLinked.getNext() != null) {
      lastFirstLinked = lastFirstLinked.getNext()
      lengthFirst += 1
    }
    //println(lengthFirst)
    //setting the last element
    lastFirstLinked.setNext(firstList)
    var fast = secondList
    for (i <- 1 to lengthFirst) {

      fast = fast.getNext()
    }


    /**
      * Here is the game figure it out
      */

    var slow = secondList
    while (fast != slow) {
      slow = slow.getNext()
      fast = fast.getNext()
    }
    node = slow
    lastFirstLinked.setNext(null)
    node
  }

  /**
    * This function is used to check weather this list has loop or not
    *
    * @param list this is the list for which detection needs to be made
    * @return Boolean
    */
  def floydCycleDetector(list: LinkedList): Boolean = {
    if (list.getNext() == null || list == null || list.getNext().getNext() == null)
      return false
    var start = list.getNext()
    var fast = list.getNext().getNext()
    while (start != null && fast != null && fast.getNext() != null) {
      if (start == fast) {
        return true
      }
      start = start.getNext()
      fast = fast.getNext().getNext()
    }
    false
  }
}

class LinkedList(elem: Int, var next: LinkedList) {
  def getElem(): Int = {
    elem
  }

  def getNext(): LinkedList = {
    next
  }

  def setNext(newNext: LinkedList): Unit = {
    next = newNext
  }
}

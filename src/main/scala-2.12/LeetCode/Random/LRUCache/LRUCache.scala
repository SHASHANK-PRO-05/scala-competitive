package LeetCode.Random.LRUCache

import scala.collection.mutable

/**
  * Created by shanky on 10/30/17.
  */
class LRUCache(_capacity: Int) {

  class DoubleLinkedList {
    var value = 0
    var prev: DoubleLinkedList = null
    var key: Int = 0
    var next: DoubleLinkedList = null
  }

  val hashMap = new mutable.HashMap[Int, DoubleLinkedList]()
  var counter = 0
  var head: DoubleLinkedList = null
  var tail: DoubleLinkedList = null

  def removeNode(key: Int): Unit = {
    if (hashMap.contains(key)) {
      val dummy = hashMap.getOrElse(key, null)
      if (dummy.next == null && dummy.prev == null) null
      else if (dummy.prev == null) dummy.next.prev = null
      else if (dummy.next == null) dummy.prev.next = null
      else {
        dummy.prev.next = dummy.next
        dummy.next.prev = dummy.prev
      }
      hashMap.remove(key)
    }
  }

  def put(key: Int, value: Int): Unit = {
    removeNode(key)
    val dummy = new DoubleLinkedList
    dummy.value = value
    dummy.key = key
    if (tail == null) {
      head = dummy
      tail = dummy
      counter += 1
    } else if (counter == _capacity) {
      hashMap.remove(head.key)
      head = head.next
      head.prev.next = null
      head.prev = null
      tail.next = dummy
      dummy.prev = tail
      tail = dummy
    } else {
      tail.next = dummy
      dummy.prev = tail
      tail = dummy
      counter += 1
    }
    hashMap.put(key, dummy)
  }

  def get(key: Int): Int = {
    var ans = -1
    if (hashMap.contains(key)) {
      val dummy = hashMap.getOrElse(key, null)
      if (dummy.prev == null && dummy.next == null) {
        head = dummy
        tail = dummy
      } else {
        if (dummy.prev == null)
          dummy.next.prev = null
        else if (dummy.next == null)
          dummy.prev.next = null
        else {
          dummy.next.prev = dummy.prev
          dummy.prev.next = dummy.next
        }
        dummy.next = null
        dummy.prev = tail
        tail = dummy
      }
      ans = dummy.value
    }
    ans
  }
}

object LRUCache {
  def main(args: Array[String]): Unit = {
    val lru = new LRUCache(3)
    //println(lru.get(0))
    lru.put(1, 1)
    lru.put(2, 2)
    lru.put(3, 3)
    lru.put(4, 4)
    println(lru.get(4))
    println(lru.get(3))
    println(lru.get(1))
    println(lru.get(2))
    println(lru.put(5, 5))
    println(lru.get(1))
    println(lru.get(2))
    println(lru.get(3))
    println(lru.get(4))
    //    println(lru.get(1))
    //    lru.put(3, 3)
    //    println(lru.get(2))
    //    lru.put(4, 4)
    //    println(lru.get(1))
    //    println(lru.get(3))
    //    println(lru.get(4))
  }

}

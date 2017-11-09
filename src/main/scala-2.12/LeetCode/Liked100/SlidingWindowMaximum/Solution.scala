package LeetCode.Liked100.SlidingWindowMaximum


/**
  * Created by shanky on 11/7/17.
  */
object Solution {

  import java.util

  def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int] = {
    //Boundary Case
    if (k > nums.length) return Array(nums.max)
    if (nums.length == 0) return Array()
    //Final Answer Array
    val ansArray = Array.ofDim[Int](nums.length + 1 - k)
    //These are used for looping
    var ansArrayIndex = 0
    var numsIndex = 0
    //This is the one which keeps track of the window
    val deque: util.Deque[Int] = new util.ArrayDeque[Int]()
    //This is the first window
    while (numsIndex != k) {
      while (!deque.isEmpty && nums(deque.peekLast()) <= nums(numsIndex)) {
        deque.pollLast()
      }
      deque.addLast(numsIndex)
      numsIndex += 1
    }
    ansArray(ansArrayIndex) = nums(deque.peek())
    ansArrayIndex += 1
    while (numsIndex != nums.length) {
      while (!deque.isEmpty && deque.peekFirst() <= numsIndex - k) {
        deque.removeFirst()
      }
      while (!deque.isEmpty && nums(deque.peekLast()) <= nums(numsIndex)) {
        deque.removeLast()
      }
      deque.addLast(numsIndex)
      numsIndex += 1
      ansArray(ansArrayIndex) = nums(deque.peek())
      ansArrayIndex += 1
    }
    ansArray
  }

  /** *
    * This returns the maxima element of the deque
    *
    * @param deque
    * @return maxima element of deque
    */
  def maximaOfDeque(deque: util.Deque[Int], array: Array[Int]): Int = {
    var ans = Int.MinValue
    val iter = deque.iterator()
    while (iter.hasNext) {
      ans = math.max(ans, array(iter.next()))
    }
    ans
  }


  def main(args: Array[String]): Unit = {
    println(maxSlidingWindow(Array(), 100).toList)
  }
}

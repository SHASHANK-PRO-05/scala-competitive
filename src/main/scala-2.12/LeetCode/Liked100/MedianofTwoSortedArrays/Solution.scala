package LeetCode.Liked100.MedianofTwoSortedArrays


object Solution {
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    def findKthElement(A: Array[Int], aStart: Int, B: Array[Int], bStart: Int, k: Int): Int = {
      if (aStart > A.length - 1) return B(bStart + k - 1)
      else if (bStart > B.length - 1) return A(aStart + k - 1)
      if (k == 1) return math.min(A(aStart), B(bStart))
      var aMid = Int.MaxValue
      var bMid = Int.MaxValue
      if (aStart + k / 2 - 1 < A.length)
        aMid = A(aStart + k / 2 - 1)
      if (bStart + k / 2 - 1 < B.length)
        bMid = B(bStart + k / 2 - 1)
      if (aMid < bMid) findKthElement(A, aStart + k / 2, B, bStart, k - k / 2)
      else findKthElement(A, aStart, B, bStart + k / 2, k - k / 2)
    }

    val l = (nums1.length + nums2.length + 1) / 2
    val r = (nums2.length + nums1.length + 2) / 2
    (findKthElement(nums1, 0, nums2, 0, l).toDouble + findKthElement(nums1, 0, nums2, 0, r).toDouble) / 2
  }

  def main(args: Array[String]): Unit = {
    println(findMedianSortedArrays(Array(1, 2), Array(3, 4)))
  }
}

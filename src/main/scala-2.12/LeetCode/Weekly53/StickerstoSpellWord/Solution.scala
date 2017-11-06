package LeetCode.Weekly53.StickerstoSpellWord

/**
  * Created by shanky on 10/10/17.
  */
object Solution {
  def minStickers(stickers: Array[String], target: String): Int = {
    val mainCount = returnCharCount(target)
    val array = Array.ofDim[Array[Int]](stickers.length)
    for (i <- array.indices) {
      array(i) = returnCharCount(stickers(i))
    }
    var ans = recursiveSolution(mainCount, checkTheHighestSolver(mainCount, array), array, 0)
    ans
  }

  def recursiveSolution(mainCount: Array[Int], solvingData: List[Int], stickers: Array[Array[Int]], usedTillNow: Int): Int = {
    if (checkAllZeros(mainCount)) return usedTillNow
    var ans = Int.MaxValue
    for (iter <- solvingData) {
      var tempArray = mainCount.clone()
      subtractThem(tempArray, stickers(iter))
      var list = checkTheHighestSolver(tempArray, stickers)
      if (!list.isEmpty) {
        ans = math.min(ans, recursiveSolution(tempArray, list, stickers, usedTillNow + 1))
      }
    }
    ans
  }

  def subtractThem(mainCount: Array[Int], sticker: Array[Int]): Int = {
    for (iter <- mainCount.indices) {
      mainCount(iter) = math.max(0, mainCount(iter) - sticker(iter))
    }
    0
  }

  def checkTheHighestSolver(mainCount: Array[Int], stickers: Array[Array[Int]]): List[Int] = {
    var ansList: List[Int] = List()
    var max = 0
    for (iter <- stickers.indices) {
      val temp = checkHowManyThisDeletes(mainCount, stickers(iter))
      if (temp > max) {
        max = temp
        ansList = List(iter)
      } else if (temp == max) {
        ansList = ansList :+ iter
      }
    }
    ansList
  }

  def checkHowManyThisDeletes(mainCount: Array[Int], sticker: Array[Int]): Int = {
    var ans = 0
    for (iter <- sticker.indices) {
      if (mainCount(iter) != 0) ans = ans + math.min(mainCount(iter), sticker(iter))
    }
    ans
  }

  def checkAllZeros(array: Array[Int]): Boolean = {
    for (iter <- array.indices) if (array(iter) != 0) return false
    true
  }

  def returnCharCount(string: String): Array[Int] = {
    val array = new Array[Int](26)
    for (char <- string) {
      array(char - 'a') += 1
    }
    array
  }

  def main(args: Array[String]): Unit = {
    println(minStickers(Array("these", "guess", "about", "garden", "him"), "atomher"))
  }

}

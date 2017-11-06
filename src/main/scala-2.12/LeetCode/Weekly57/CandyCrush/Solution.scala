package LeetCode.Weekly57.CandyCrush


object Solution {
  def candyCrush(board: Array[Array[Int]]): Array[Array[Int]] = {
    if (board.length == 0) board.length
    var todo = false
    val newBoard = Array.ofDim[Int](board.length, board(0).length)
    for (i <- 0 until board.length - 2) {
      for (j <- 0 until board(i).length) {
        val v = board(i)(j)
        if (v != 0 && math.abs(v) == math.abs(board(i + 1)(j)) && math.abs(v) == math.abs(board(i + 2)(j))) {
          board(i)(j) = -1 * math.abs(v)
          board(i + 1)(j) = -1 * math.abs(v)
          board(i + 2)(j) = -1 * math.abs(v)
          todo = true
        }
      }
    }
    for (i <- 0 until board.length) {
      for (j <- 0 until board(i).length - 2) {
        val v = board(i)(j)
        if (v != 0 && math.abs(v) == math.abs(board(i)(j + 1)) && math.abs(v) == math.abs(board(i)(j + 2))) {
          board(i)(j) = -1 * math.abs(v)
          board(i)(j + 1) = -1 * math.abs(v)
          board(i)(j + 2) = -1 * math.abs(v)
          todo = true
        }
      }
    }
//    for (iter <- board)
//      println(iter.toList)
//    println("--------------------")
    for (j <- board(0).indices) {
      var temp = board.length - 1
      for (i <- board.indices.reverse) {
        if (board(i)(j) > 0) {
          newBoard(temp)(j) = board(i)(j)
          temp -= 1
        }
      }
    }

    if (todo) candyCrush(newBoard) else newBoard
  }

  def main(args: Array[String]): Unit = {
    println(candyCrush(Array(Array(110, 5, 112, 113, 114), Array(210, 211, 5, 213, 214), Array(310, 311, 3, 313, 314), Array(410, 411, 412, 5, 414), Array(5, 1, 512, 3, 3), Array(610, 4, 1, 613, 614), Array(710, 1, 2, 713, 714), Array(810, 1, 2, 1, 1), Array(1, 1, 2, 2, 2), Array(4, 1, 4, 4, 1014))))
  }
}

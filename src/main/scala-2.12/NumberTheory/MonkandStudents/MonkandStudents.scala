package NumberTheory.MonkandStudents

import FastIO.CustomScanner

import scala.util.Sorting._

/**
  * Created by home on 12/25/2016.
  */
object MonkandStudents {
  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    var stringBuilder = new StringBuilder
    val size = customScanner.nextInt()
    val arr = new Array[Line](size)
    for (i <- 0 to size - 1) {
      val line = new Line(customScanner.nextLong(), customScanner.nextLong(), customScanner.nextLong(), customScanner.nextLong(), i)
      line.setLatticePoints()
      arr(i) = line
    }
    quickSort(arr)
    val q = customScanner.nextInt()
    for (i <- 0 to q - 1) {
      stringBuilder.append(bsearch(arr, customScanner.nextLong()) + "\n")
    }
    print(stringBuilder)
  }

  def bsearch(arr: Array[Line], number: Long): Long = {
    var ans: Long = -1
    var start = 0
    var end = arr.length - 1
    while (start <= end) {
      val mid = (start + end) / 2
      if (arr(mid).lattice >= number) {
        end = mid - 1
        ans = arr(mid).getIndex() + 1
      } else {
        start = mid + 1
      }
    }
    ans
  }
}

class Line(x1: Long, y1: Long, x2: Long, y2: Long, index: Long) extends Ordered[Line] {
  private[this] def gcd(x: Long, y: Long): Long = {
    if (y == 0) x else gcd(y, x % y)
  }

  var lattice: Long = 0;

  def getIndex(): Long = {
    this.index
  }

  def getX1(): Long = {
    x1
  }

  def getX2(): Long = {
    x2
  }

  def getY1(): Long = {
    y1
  }

  def getY2(): Long = {
    y2
  }

  def setLatticePoints(): Unit = {
    if (x1 == x2) lattice = Math.abs(y2 - y1) + 1
    else if (y2 == y1) lattice = Math.abs(x2 - x1) + 1
    else lattice = gcd(Math.abs(x2 - x1), Math.abs(y2 - y1)) + 1
  }

  def compare(that: Line): Int = {
    if (this.lattice > that.lattice) return 1
    else if (this.lattice < that.lattice) return -1
    else if (this.index > that.getIndex()) return 1
    else return -1
  }
}

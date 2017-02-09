package NumberTheory.MonkandStudentsTest

import org.junit.runner.RunWith
import org.scalatest.{DoNotDiscover, FlatSpec}
import org.scalatest.junit.JUnitRunner
import NumberTheory.MonkandStudents._

import scala.util.Sorting._

/**
  * Created by home on 12/25/2016.
  */
@DoNotDiscover
@RunWith(classOf[JUnitRunner])
class MonkandStudentsTest extends FlatSpec {
  //  "MonkandStudentsTest" should " solve the lattice problem " in {
  //    println("here")
  //    val size = randSize()
  //    val arr = new Array[Line](size)
  //    val arrToBe = new Array[Line](size)
  //    for (i <- 0 to size - 1) {
  //      //println("here")
  //      val line = new Line(randLong(), randLong(), randLong(), randLong(), i)
  //      //println("here")
  //      findLatticePoints(line)
  //      arr(i) = line
  //      val newLine = new Line(line.getX1(), line.getY1(), line.getX2(), line.getY2(), i)
  //      newLine.setLatticePoints()
  //      arrToBe(i) = newLine
  //      println(line.getX1() + " " + line.getY1() + " " + line.getX2() + " " + line.getY2() + " " + size + " " + arr(i).lattice)
  //      assert(arrToBe(i).lattice === arr(i).lattice)
  //    }
  //    quickSort(arr)
  //    quickSort(arrToBe)
  //    for (i <- 0 to size - 1) {
  //      println(arr(i).lattice + " " + arrToBe(i).lattice)
  //      assert(arr(i).getIndex() === arrToBe(i).getIndex())
  //    }
  //    val q = randSize()
  //    for (i <- 1 to q) {
  //      val x = randX()
  //      val myAns = MonkandStudents.bsearch(arrToBe, x)
  //      val trueAns = findBruteForce(arr, x)
  //      println(trueAns + " " + myAns)
  //      assert(trueAns == myAns)
  //    }
  // }

  def findBruteForce(arr: Array[Line], x: Long): Int = {
    for (i <- 0 to arr.size - 1) {
      if (arr(i).lattice >= x) {
        return arr(i).getIndex().toInt + 1
      }
    }
    return -1
  }

  def findLatticePoints(line: Line): Unit = {
    if (line.getX1() == line.getX2()) line.lattice = Math.abs(line.getY2() - line.getY1()) + 1
    else if (line.getY1() == line.getY2()) line.lattice = Math.abs(line.getX2() - line.getX1()) + 1
    var lattice = 1

    var i = line.getX1()
    var incre = -1
    if (line.getX1() < line.getX2()) incre = 1
    while (i != line.getX2()) {
      var y = ((BigDecimal(line.getY2() - line.getY1()) * BigDecimal(i - line.getX1())) / BigDecimal(line.getX2() - line.getX1())).toDouble
      y = y + line.getY1()
      if (Math.floor(y) == y) {
        lattice += 1
      }
      i += incre
      //println(i + " " + line.getX1() + " " + line.getX2())
    }
    line.lattice = lattice
  }

  def randLong(): Long = {
    negate((Math.random() * Math.pow(10, 6)).toLong)
  }

  def randX(): Long = {
    (Math.random() * Math.pow(10, 2)).toLong
  }

  def randSize(): Int = {
    var size = (Math.random() * Math.pow(2, 7)).toInt
    while (size == 0) {
      size = (Math.random() * Math.pow(2, 7)).toInt
    }
    size
  }

  def negate(num: Long): Long = {
    var temp = (Math.random() * 3).toLong
    while (temp == 0) {
      temp = (Math.random() * 3).toLong
    }
    if (temp == 1) {
      num
    } else {
      num * -1
    }
  }

}

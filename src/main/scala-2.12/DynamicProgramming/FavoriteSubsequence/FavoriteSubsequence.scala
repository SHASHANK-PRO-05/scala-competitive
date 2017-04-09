package DynamicProgramming.FavoriteSubsequence

import FastIO.CustomScanner

class Point {
  var nextA = -1
  var nextB = -1
  var nextC = -1
  var visited = false
  var solution = 0L

  override def toString: String = {
    this.nextA + " " + this.nextB + " " + this.nextC + " " + solution
  }
}

/**
  * Created by shashank on 1/4/17.
  */
object FavoriteSubsequence {

  var s: String = ""

  var dpLookUp = Array[Point]()
  var ans: Long = 0L
  var mod = 1000000007L
  var dpLookUpNew: Array[Array[Long]] = null

  def main(args: Array[String]): Unit = {
    val customScanner = new CustomScanner()
    s = customScanner.nextLine()
    dpLookUp = Array.ofDim[Point](s.length + 1)
    dpLookUpNew = Array.ofDim[Long](s.length + 1, 3)
    for (i <- s.length to 0 by -1) {
      if (i == s.length) {
        //case when we are last
        dpLookUp(i) = new Point
      }
      else {
        dpLookUp(i) = new Point
        s.charAt(i) match {
          case 'a' => {
            dpLookUp(i).nextA = i + 1
            dpLookUp(i).nextB = dpLookUp(i + 1).nextB
            dpLookUp(i).nextC = dpLookUp(i + 1).nextC
          }
          case 'b' => {
            dpLookUp(i).nextB = i + 1
            dpLookUp(i).nextC = dpLookUp(i + 1).nextC
            dpLookUp(i).nextA = dpLookUp(i + 1).nextA
          }
          case 'c' => {
            dpLookUp(i).nextC = i + 1
            dpLookUp(i).nextA = dpLookUp(i + 1).nextA
            dpLookUp(i).nextB = dpLookUp(i + 1).nextB
          }
        }
      }
    }
    //println(findSolution(0, dpLookUp(0).nextA))


    findSolutionNonRecursive()

    //    for (i <- 0 to 2) {
    //      for (j <- 0 to s.length) {
    //        print(dpLookUpNew(j)(i) + " ")
    //      }
    //      println()
    //    }

  }

  def findSolutionNonRecursive(): Unit = {
    for (i <- s.length to 1 by -1) {
      s.charAt(i - 1) match {
        case 'a' => {
          if (dpLookUp(i).nextA != -1) {
            dpLookUpNew(i)(0) = (dpLookUpNew(i)(0)
              + (dpLookUpNew(dpLookUp(i).nextA)(0) * 2) % mod) % mod
          }
          if (dpLookUp(i).nextB != -1) {
            dpLookUpNew(i)(0) = (dpLookUpNew(i)(0) + dpLookUpNew(dpLookUp(i).nextB)(1)) % mod
          }
        }
        case 'b' => {
          if (dpLookUp(i).nextB != -1) {
            dpLookUpNew(i)(1) = (dpLookUpNew(i)(1)
              + (dpLookUpNew(dpLookUp(i).nextB)(1) * 2) % mod) % mod
          }
          if (dpLookUp(i).nextC != -1) {
            dpLookUpNew(i)(1) = (dpLookUpNew(i)(1)
              + dpLookUpNew(dpLookUp(i).nextC)(2)) % mod
          }
        }
        case 'c' => {
          dpLookUpNew(i)(2) = (dpLookUpNew(i)(2) + 1) % mod
          if (dpLookUp(i).nextC != -1) {
            dpLookUpNew(i)(2) = (dpLookUpNew(i)(2)
              + (dpLookUpNew(dpLookUp(i).nextC)(2) * 2) % mod) % mod
          }
        }
      }
    }
    if (dpLookUp(0).nextA != -1)
      println(dpLookUpNew(dpLookUp(0).nextA)(0))
    else
      println(0L)
  }

  def findSolution(findThing: Int, index: Int): Long = {
    if (index != -1 && dpLookUp(index).visited) {
      dpLookUp(index).solution
    }
    else if (index != -1) {
      findThing match {
        case 0 => {
          /**
            * case when it is a, either we choose this a and then
            * lookup for next a or we just move to next a, or we choose this
            * a and move to next b
            */
          val tempAns = ((findSolution(0, dpLookUp(index).nextA) * 2) % mod +
            findSolution(1, dpLookUp(index).nextB)) % mod
          dpLookUp(index).visited = true
          dpLookUp(index).solution = tempAns
          tempAns
        }
        case 1 => {
          /**
            * case when we are looking for b and we would be choosing this b
            * including it and checkin next b or next c
            */
          val tempAns = ((findSolution(1, dpLookUp(index).nextB) * 2) % mod +
            findSolution(2, dpLookUp(index).nextC)) % mod
          dpLookUp(index).visited = true
          dpLookUp(index).solution = tempAns
          tempAns
        }
        case 2 => {
          /**
            * we found a solution
            */
          //println("LookingFor: " + findThing + " Index:" + index + " Result:" + (list :+ index))
          val tempAns = ((findSolution(2, dpLookUp(index).nextC) * 2) % mod + 1) % mod
          dpLookUp(index).visited = true
          dpLookUp(index).solution = tempAns
          tempAns
        }
      }
    } else {
      0
    }
  }
}

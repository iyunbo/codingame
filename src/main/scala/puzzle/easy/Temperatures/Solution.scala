package puzzle.easy.Temperatures

import scala.math._
import scala.util._

/**
  * Auto-generated code below aims at helping you parse
  * the standard input according to the problem statement.
  **/
object Solution extends App {
  def calculateClosest(temperatures: String): Int = {
    if (temperatures.isEmpty) {
      return 0
    }
    temperatures.split(" ").map(_.toInt).reduce((a, b) => {
      val valA: Int = abs(a)
      val valB: Int = abs(b)
      if (valA > valB)
        b
      else if (valA == valB)
        if (a > 0) a else b
      else
        a
    })
  }

  def convertToArray(input: String): Array[Int] = {
    input.split(" ").map(_.toInt)
  }

  val n = readInt
  // the number of temperatures to analyse
  val temps = readLine // the n temperatures expressed as integers ranging from -273 to 5526

  // Write an action using println
  // To debug: Console.err.println("Debug messages...")

  println(calculateClosest(temps))
}
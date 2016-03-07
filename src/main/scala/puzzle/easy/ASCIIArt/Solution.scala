package puzzle.easy.ASCIIArt

import scala.collection.mutable.ListBuffer
import scala.math._
import scala.util._

/**
  * Auto-generated code below aims at helping you parse
  * the standard input according to the problem statement.
  **/
object Solution extends App {
  def toAsciiArtLine(referenceLine: List[String], index: Int, lineNumber: Int, lineWidth: Int) = {
    referenceLine.slice(index * lineWidth, index * lineWidth + lineWidth).reduce(_ + _)
  }

  def toList(row: String): List[String] = {
    val line = ListBuffer[String]()
    for (i <- 0 until row.length) {
      line += row.charAt(i).toString
    }
    line.toList
  }

  def charIndex(char: Char): Int = {
    if (char.toInt >= 'A'.toInt && char.toInt <= 'Z'.toInt) char.toInt - 'A'.toInt else 'Z'.toInt - 'A'.toInt + 1
  }

  val l = readInt
  val h = readInt
  val t = readLine
  val answer = new StringBuilder()
  for (i <- 0 until h) {
    val row = readLine
    val line = toList(row)
    answer ++= t.toUpperCase.map(char => toAsciiArtLine(line, charIndex(char), i, l)).reduce(_ + _)
    answer ++= "\n"
  }

  // Write an action using println
  // To debug: Console.err.println("Debug messages...")
  println(answer)
}
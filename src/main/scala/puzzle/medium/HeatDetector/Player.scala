package puzzle.medium.HeatDetector

import scala.math._
import scala.util._

/**
  * Auto-generated code below aims at helping you parse
  * the standard input according to the problem statement.
  **/
object Player extends App {
  var position = (0, 0)
  var limit = ((0, 0), (6, 6))

  def nextOutput(input: String) = {
    input.foreach(d =>
      position = nextPosition(limit, position, d)
    )
    position._1 + " " + position._2
  }


  def nextPosition(limit: ((Int, Int), (Int, Int)), start: (Int, Int), direction: Char): (Int, Int) = {
    direction match {
      case 'R' =>
        val next = (start._1 + (limit._2._1 - start._1 + 1) / 2, start._2)
        Player.limit = ((start._1 + 1, limit._1._2), limit._2)
        next
      case 'D' =>
        val next = (start._1, start._2 + (limit._2._2 - start._2 + 1) / 2)
        Player.limit = ((limit._1._1, start._2 + 1), limit._2)
        next
      case 'L' =>
        val next = (start._1 - (start._1 - limit._1._1 + 1) / 2, start._2)
        Player.limit = (limit._1, (start._1 - 1, limit._2._2))
        next
      case 'U' =>
        val next = (start._1, start._2 - (start._2 - limit._1._2 + 1) / 2)
        Player.limit = (limit._1, (limit._2._1, start._2 - 1))
        next
    }

  }

  // w: width of the building.
  // h: height of the building.
  val Array(w, h) = for (i <- readLine split " ") yield i.toInt
  val n = readInt
  limit = ((0, 0), (w - 1, h - 1))
  // maximum number of turns before game over.
  val Array(x0, y0) = for (i <- readLine split " ") yield i.toInt
  position = (x0, y0)

  // game loop
  while (true) {
    val bombdir = readLine // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)

    // Write an action using println
    // To debug: Console.err.println("Debug messages...")


    // the location of the next window Batman should jump to.
    println(nextOutput(bombdir))
  }
}
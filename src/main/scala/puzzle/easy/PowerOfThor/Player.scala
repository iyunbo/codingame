package puzzle.easy.PowerOfThor

import scala.math._
import scala.util._

/**
  * Auto-generated code below aims at helping you parse
  * the standard input according to the problem statement.
  * ---
  * Hint: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.
  **/
object Player extends App {
  def nextMove(x: Int, y: Int, lightx: Int, lighty: Int): String = {
    var yMove = ""
    var xMove = ""
    if (lighty < y) {
      yMove = "N"
    }
    if (lighty > y) {
      yMove = "S"
    }
    if (lightx > x) {
      xMove = "E"
    }
    if (lightx < x) {
      xMove = "W"
    }
    yMove + xMove
  }

  def deltaY(s: String): Int = {
    if (s.contains("N")) {
      return -1
    }
    if (s.contains("S")) {
      return 1
    }
    0
  }

  def deltaX(s: String): Int = {
    if (s.contains("W")) {
      return -1
    }
    if (s.contains("E")) {
      return -1
    }
    0
  }

  // lightx: the X position of the light of power
  // lighty: the Y position of the light of power
  // initialtx: Thor's starting X position
  // initialty: Thor's starting Y position
  val Array(lightx, lighty, initialtx, initialty) = for (i <- readLine split " ") yield i.toInt
  var x = initialtx
  var y = initialty
  // game loop
  while (true) {
    val remainingturns = readInt // The remaining amount of turns Thor can move. Do not remove this line.

    // Write an action using println
    // To debug: Console.err.println("Debug messages...")
    val moveTo = nextMove(x, y, lightx, lighty)
    x = x + deltaX(moveTo)
    y = y + deltaY(moveTo)
    println(moveTo) // A single line providing the move to be made: N NE E SE S SW W or NW

  }


}
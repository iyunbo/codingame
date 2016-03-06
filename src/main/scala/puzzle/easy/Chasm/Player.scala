package puzzle.easy.Chasm

import scala.math._
import scala.util._

/**
  * Auto-generated code below aims at helping you parse
  * the standard input according to the problem statement.
  **/
object Player extends App {
  def nextAction(speed: Int, coordx: Int, road: Int, gap: Int): String = {
    if (coordx > road) {
      return "SLOW"
    }
    if (coordx + speed > road) {
      return "JUMP"
    }
    if (speed < calculateEnoughSpeed(gap, road)) {
      return "SPEED"
    }
    if (speed > calculateEnoughSpeed(gap, road)) {
      return "SLOW"
    }
    "WAIT"
  }

  def calculateEnoughSpeed(gap: Int, road: Int): Int = {
    gap + 1
  }

  val road = readInt
  // the length of the road before the gap.
  val gap = readInt
  // the length of the gap.
  val platform = readInt // the length of the landing platform.

  // game loop
  while (true) {
    val speed = readInt // the motorbike's speed.
    val coordx = readInt // the position on the road of the motorbike.

    // Write an action using println
    // To debug: Console.err.println("Debug messages...")

    println(nextAction(speed, coordx, road, gap)) // A single line containing one of 4 keywords: SPEED, SLOW, JUMP, WAIT.
  }
}
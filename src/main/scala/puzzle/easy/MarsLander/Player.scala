package puzzle.easy.MarsLander

import scala.math._
import scala.util._

/**
  * Auto-generated code below aims at helping you parse
  * the standard input according to the problem statement.
  **/
object Player extends App {


  def nextPower(altitude: Int, vspeed: Int): Int = {
    if (vspeed > -40 || altitude > 2300) {
      0
    } else {
      4
    }
  }

  val surfacen = readInt // the number of points used to draw the surface of Mars.
  for (i <- 0 until surfacen) {
    // landx: X coordinate of a surface point. (0 to 6999)
    // landy: Y coordinate of a surface point. By linking all the points together in a sequential fashion, you form the surface of Mars.
    val Array(landx, landy) = for (i <- readLine split " ") yield i.toInt
  }

  // game loop
  while (true) {
    // hspeed: the horizontal speed (in m/s), can be negative.
    // vspeed: the vertical speed (in m/s), can be negative.
    // fuel: the quantity of remaining fuel in liters.
    // rotate: the rotation angle in degrees (-90 to 90).
    // power: the thrust power (0 to 4).
    val Array(x, y, hspeed, vspeed, fuel, rotate, power) = for (i <- readLine split " ") yield i.toInt

    // Write an action using println
    // To debug: Console.err.println("Debug messages...")
    println("0 " + nextPower(y, vspeed)) // 2 integers: rotate power. rotate is the desired rotation angle (should be 0 for level 1), power is the desired thrust power (0 to 4).
  }
}
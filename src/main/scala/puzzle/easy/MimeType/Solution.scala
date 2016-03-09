package puzzle.easy.MimeType

import scala.math._
import scala.util._

/**
  * Auto-generated code below aims at helping you parse
  * the standard input according to the problem statement.
  **/
object Solution extends App {
  def extension(filename: String): Any = {
    val lastIndexOfDot: Int = filename.lastIndexOf('.')
    if (lastIndexOfDot < 0 || lastIndexOfDot >= filename.length - 1)
      None
    else
      Some(filename.substring(lastIndexOfDot + 1).toLowerCase())
  }

  val n = readInt
  // Number of elements which make up the association table.
  val q = readInt
  // Number Q of file names to be analyzed.
  var mapping: Map[Any, String] = Map()
  for (i <- 0 until n) {
    // ext: file extension
    // mt: MIME type.
    val Array(ext, mt) = readLine split " "
    mapping += (Some(ext.toLowerCase()) -> mt)
  }
  for (i <- 0 until q) {
    val fname = readLine // One file name per line.
    val ext: Any = extension(fname)
    println(if (mapping.contains(ext)) mapping(ext) else "UNKNOWN")
  }

  // Write an action using println
  // To debug: Console.err.println("Debug messages...")

}
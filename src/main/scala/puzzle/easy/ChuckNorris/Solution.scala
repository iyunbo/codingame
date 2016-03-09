package puzzle.easy.ChuckNorris

import scala.math._
import scala.util._

/**
  * Auto-generated code below aims at helping you parse
  * the standard input according to the problem statement.
  **/
object Solution extends App {

  object Code extends Enumeration {
    type Code = Value
    val One = Value("0")
    val Zero = Value("00")

    def valueOf(char: Char): Code = {
      if ('0' == char) Zero else One
    }

    def inverse(c: Code): Char = {
      if (Zero == c) '1' else '0'
    }
  }


  def toChuckNorris(s: String): String = {
    if (s.isEmpty) return s
    val firstChar = Code.valueOf(s.charAt(0))
    val firstPartLength: Int = countOfPrefixLetter(s, firstChar)
    firstChar.toString + " " + "0" * firstPartLength + " " + toChuckNorris(nextPart(s, firstPartLength)).trim
  }

  def nextPart(s: String, firstPartLength: Int): String = {
    if (s.length > firstPartLength) s.substring(firstPartLength) else ""
  }

  def countOfPrefixLetter(s: String, c: Code.Code): Int = {
    if (s.contains(Code.inverse(c))) s.indexOf(Code.inverse(c)) else s.length
  }

  def toBinary(message: String): String = {
    message.map(msg => {
      val b = msg.toInt.toBinaryString
      ("0" * 7 + b).substring(b.length())
    }).reduce(_ + _)
  }

  val message = readLine
  // Write an action using println
  // To debug: Console.err.println("Debug messages...")

  println(toChuckNorris(toBinary(message)))
}
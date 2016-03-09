package puzzle.easy.ChuckNorris

import org.scalatest.{FlatSpec, Matchers}
import puzzle.easy.ChuckNorris.Solution.{toBinary, toChuckNorris}

import scala.math._
import scala.util._

class Spec extends FlatSpec with Matchers {

  it should "convert a letter to binary format" in {
    toBinary("C") should be("1000011")
  }


  it should "convert a string to binary format" in {
    toBinary("CC") should be("10000111000011")
  }

  it should "convert a special letter to binary format" in {
    toBinary("%") should be("0100101")
  }

  it should "convert a special string to binary format" in {
    toBinary("%%") should be("01001010100101")
  }

  it should "convert one single 1 to 0 0" in {
    toChuckNorris("1") should be("0 0 ")
  }

  it should "convert four 0 to 00 0000" in {
    toChuckNorris("0000") should be("00 0000 ")
  }

  it should "convert 10000 to 0 0 00 0000" in {
    toChuckNorris("10000") should be("0 0 00 0000")
  }
}
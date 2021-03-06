package puzzle.easy.Temperatures

import org.scalatest.{FlatSpec, Matchers}
import puzzle.easy.Temperatures.Solution.calculateClosest

import scala.math._
import scala.util._

/**
  * Auto-generated code below aims at helping you parse
  * the standard input according to the problem statement.
  **/
class Spec extends FlatSpec with Matchers {
  it should "calculate the closest int to 0" in {
    calculateClosest("1 -2 -8 4 5") should be(1)
  }

  it should "return the positive int if two are equally close to 0" in {
    calculateClosest("-1 -2 -8 4 1") should be(1)
  }

  it should "return 0 if no temparatures are provided" in {
    calculateClosest("") should be(0)
  }
}
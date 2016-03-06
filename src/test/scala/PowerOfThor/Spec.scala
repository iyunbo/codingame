package PowerOfThor

import PowerOfThor.Player.{deltaX, deltaY, nextMove}
import org.scalatest.{FlatSpec, Matchers}

class Spec extends FlatSpec with Matchers {

  it should "move to one the 8 directions: N NE E SE S SW W NW" in {
    Some(nextMove(0, 0, 39, 17)) should contain oneOf("N", "NE", "E", "SE", "S", "SW", "W", "NW")
  }

  it should "move towards N if the light is on the top" in {
    Some(nextMove(10, 10, 10, 0)) should contain oneOf("NE", "N", "NW")
  }

  it should "move towards S if the light is on the bottom" in {
    Some(nextMove(10, 10, 10, 20)) should contain oneOf("SE", "S", "SW")
  }

  it should "move towards E if the light is on the right" in {
    Some(nextMove(10, 10, 20, 10)) should contain oneOf("NE", "E", "SE")
  }

  it should "move towards W if the light is on the left" in {
    Some(nextMove(10, 10, 0, 10)) should contain oneOf("W", "SW", "NW")
  }

  it should "move towards SW if the light is on the SW" in {
    nextMove(10, 10, 0, 20) should be("SW")
  }

  it should "move towards NE if the light is on the NE" in {
    nextMove(10, 10, 20, 0) should be("NE")
  }

  it should "reduce y if moving towards N" in {
    deltaY("N") should be(-1)
    deltaY("NW") should be(-1)
  }

  it should "increase y if moving towards S" in {
    deltaY("S") should be(1)
    deltaY("SE") should be(1)
  }

  it should "reduce x if moving towards W" in {
    deltaX("W") should be(-1)
    deltaX("NW") should be(-1)
  }

  it should "increase x if moving towards E" in {
    deltaX("E") should be(-1)
    deltaX("SE") should be(-1)
  }

  it should "keep x if moving towards N or S" in {
    deltaX("N") should be(0)
    deltaX("S") should be(0)
  }

  it should "keep y if moving towards E or W" in {
    deltaY("E") should be(0)
    deltaY("W") should be(0)
  }

}
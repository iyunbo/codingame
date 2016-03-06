package Chasm

import Chasm.Player.{calculateEnoughSpeed, nextAction}
import org.scalatest.{FlatSpec, Matchers}

class Spec extends FlatSpec with Matchers {

  it should "do on of those things: SPEED, JUMP, SLOW, WAIT" in {
    Some(nextAction(1, 1, 5, 2)) should contain oneOf("SPEED", "JUMP", "SLOW", "WAIT")
  }

  it should "JUMP at the end of the bridge" in {
    nextAction(3, 5, 5, 2) should be("JUMP")
  }

  it should "JUMP before drop" in {
    nextAction(3, 4, 5, 2) should be("JUMP")
  }

  it should "SPEED before reaching the enough speed to jump over the gap" in {
    nextAction(2, 1, 5, 2) should be("SPEED")
  }

  it should "WAIT when reaching the enough speed to jump over the gap" in {
    nextAction(4, 1, 5, 3) should be("WAIT")
  }

  it should "SLOW down after jumped over the gap" in {
    nextAction(3, 8, 5, 3) should be("SLOW")
  }

  it should "SLOW down if speed is too high" in {
    nextAction(6, 1, 9, 3) should be("SLOW")
  }

  it should "get the speed as the gap length + 1 if the bridge fits" in {
    calculateEnoughSpeed(3, 15) should be(4)
  }

}
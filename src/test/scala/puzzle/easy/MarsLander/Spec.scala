package puzzle.easy.MarsLander

import org.scalatest.{FlatSpec, Matchers}
import puzzle.easy.MarsLander.Player.nextPower

class Spec extends FlatSpec with Matchers {

  it should "return power between 0 and 4" in {
    Some(nextPower(5000, 50)) should contain oneOf(0, 1, 2, 3, 4)
  }

  it should "use 0 power for speeding if speed does not reach the max landing speed" in {
    nextPower(5000, 0) should be(0)
  }

  it should "use max power for slowing if speed reaches the max landing speed" in {
    nextPower(2300, -50) should be(4)
  }

  it should "start to slow only after 2300 altitude" in {
    nextPower(5000, -50) should be(0)
    nextPower(1500, -50) should be(4)
  }

}
package puzzle.medium.HeatDetector

import org.scalatest.{FlatSpec, Matchers}
import puzzle.medium.HeatDetector.Player.{limit, nextOutput, nextPosition, position}

/**
  * Created by iyunbo on 13/05/16.
  */
class HeatDetector extends FlatSpec with Matchers {

  it should "jump to half length bigger if direction is Right or Up" in {
    nextPosition(((0, 0), (6, 6)), (2, 2), 'R') should be((4, 2))
    nextPosition(((0, 0), (6, 6)), (3, 3), 'D') should be((3, 5))
  }

  it should "jump to half length less if direction is Left or Down" in {
    nextPosition(((0, 0), (6, 6)), (5, 2), 'L') should be((2, 2))
    nextPosition(((0, 0), (6, 6)), (3, 5), 'U') should be((3, 2))
  }

  it should "return next position string" in {
    position = (3, 3)
    limit = ((0, 0), (6, 6))
    nextOutput("RD") should be("5 5")
    position should be(5, 5)
    limit should be((4, 4), (6, 6))
  }

  it should "return next position of the center" in {
    position = (0, 0)
    limit = ((0, 0), (49, 49))
    nextOutput("RD") should be("25 25")
    position should be(25, 25)
    limit should be((1, 1), (49, 49))
  }

}

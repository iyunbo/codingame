package puzzle.easy.ASCIIArt

import org.scalatest.{FlatSpec, Matchers}
import puzzle.easy.ASCIIArt.Solution.{charIndex, toAsciiArtLine, toList}

class Spec extends FlatSpec with Matchers {


  it should "read one line into array" in {
    toList("### ") should equal(List("#", "#", "#", " "))
  }

  it should "read one line of mutiple ascii into array" in {
    toList("###  #  ") should equal(List("#", "#", "#", " ", " ", "#", " ", " "))
  }

  private val dictionary: List[List[String]] = List(
    List("#", "#", "#", " ", " ", "#", " ", " "),
    List("#", " ", " ", " ", "#", " ", "#", " "),
    List("#", "#", " ", " ", "#", "#", "#", " "),
    List("#", " ", " ", " ", "#", " ", "#", " "),
    List("#", "#", "#", " ", "#", " ", "#", " ")
  )

  it should "print one line of ascii" in {
    toAsciiArtLine(
      dictionary(1), 1, 1, 4) should equal(
      "# # "
    )
  }

  it should "return 26 when char is not acii" in {
    charIndex('@') should be(26)
  }

}
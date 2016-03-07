package puzzle.easy.ASCIIArt

import org.scalatest.{FlatSpec, Matchers}
import puzzle.easy.ASCIIArt.Solution.{charIndex, toData, toAsciiArtLine, toLine}

class Spec extends FlatSpec with Matchers {


  it should "read one line into array" in {
    toLine("### ") should equal(List("#", "#", "#", " "))
  }

  it should "read one line of mutiple ascii into array" in {
    toLine("###  #  ") should equal(List("#", "#", "#", " ", " ", "#", " ", " "))
  }

  it should "read one acii letter into data structure" in {
    toData(
        "### \n" +
        "#   \n" +
        "##  \n" +
        "#   \n" +
        "### \n", 5) should equal(
      List(
        List("#", "#", "#", " "),
        List("#", " ", " ", " "),
        List("#", "#", " ", " "),
        List("#", " ", " ", " "),
        List("#", "#", "#", " ")
      ))
  }

  private val dictionary: List[List[String]] = List(
    List("#", "#", "#", " ", " ", "#", " ", " "),
    List("#", " ", " ", " ", "#", " ", "#", " "),
    List("#", "#", " ", " ", "#", "#", "#", " "),
    List("#", " ", " ", " ", "#", " ", "#", " "),
    List("#", "#", "#", " ", "#", " ", "#", " ")
  )

  it should "read multiple acii letters into data structure" in {
    toData(
      "###  #  \n" +
      "#   # # \n" +
      "##  ### \n" +
      "#   # # \n" +
      "### # # \n", 5) should equal(
      dictionary)
  }

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
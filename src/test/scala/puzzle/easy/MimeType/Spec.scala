package puzzle.easy.MimeType

import org.scalatest.{FlatSpec, Matchers}
import puzzle.easy.MimeType.Solution.extension

/**
  * Created by "Yunbo WANG" on 09/03/16.
  */
class Spec extends FlatSpec with Matchers {

  it should "determine the extension of a normal file " in {
    extension("hello.txt") should be(Some("txt"))
  }

  it should "determine the extension of a file without extension" in {
    extension("hello") should be(None)
  }

  it should "determine the extension of a file with multiple dots" in {
    extension("hello.txt.gif") should be(Some("gif"))
  }

  it should "determine the extension of a file with dot at the end" in {
    extension("hello.txt.") should be(None)
  }

  it should "determine the extension ignoring the case" in {
    extension("hello.TXt") should be(Some("txt"))
  }

}

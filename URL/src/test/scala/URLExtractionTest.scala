import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class URLExtractionTest extends AnyFlatSpec with Matchers {

  //it should match when url is null
  "it" should "match with given url output" in {
    val obj = new URLExtraction("")
    val result = obj match {
      case e if (obj.url.isEmpty) => "Empty string"
      case URLExtraction(protocol, domain, path) => s"Protocol: $protocol\n Domain: $domain\n Path: $path"
      case _ => "Invalid"
    }
    val expectedOutput = "Empty string"
    assert(expectedOutput == result)
  }

  //it should check if url is correct
  "it" should "match with given url https://www.google.com/home" in {
    val obj = new URLExtraction("https://www.google.com/home")
    val result = obj match {
      case URLExtraction(protocol, domain, path) => s"Protocol: $protocol\nDomain: $domain\nPath: $path"
      case _ => "Invalid"
    }
    val expectedOutput = "Protocol: https\nDomain: www.google.com\nPath: home"
    assert(expectedOutput == result)
  }
}

package idetest

import org.apache.commons.io.IOUtils
import java.io.OutputStream
import org.apache.commons.lang.StringUtils

/**
 * &éèïöä
 */
object ObjectA {
  def mA0() = "jjgjkgjk&éèàä" + "üöäßÜÖÄ"

  def main(args: Array[String]) {
    println("mA0 : " + mA0() + " .. " + StringUtils.isEmpty(""))
    IOUtils.closeQuietly(null : OutputStream)
  }
}

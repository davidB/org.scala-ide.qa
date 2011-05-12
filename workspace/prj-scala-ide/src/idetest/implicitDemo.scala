/**
 * 
 */
package idetest

object String2Int {
  
  val s1 = "1"
  val s2 = "2"
  val s3 = "3"

  val i1 = 1
  val i2 = 2
  val i3 = 3
  
  implicit def string2Int(s : String) : Int = Integer.parseInt(s) //s.toInt
  
  /** apidoc here */
  def printInt(i : Int) = println("int : " + i)
  
  def main(args: Array[String]) {
    println(s1 + " .. " + s2 + ".. " + s3)
    printInt("33")
    
    printInt(s1)
    printInt(i1)
    printInt(s1 + s2 + s3)
    printInt(i1 + i2 + i3)
    printInt(s1 + 10)
    printInt(i1 + 10)
    assert(11 == (s1 : Int) + 10)
  }
//  implicit val somewords = new  SomeWords("yeah!")
  

}
/**
 * 
 */
package idetest

/**
 * Doc ClassD2
 */
class ClassD2 {
  
  /**
   * Doc method m01 of ClassD2
   * @param s parameter 1
   */
  def m01(s : String) = "xx" + s
  
  /**
   * Doc method m02 of ClassD2
   * @param s parameter 1
   */
  def m02(s : String) = m01(s) + "zzz"

  /**
   * Doc val v02 of ClassD2
   * @param s parameter 1
   */
  val v02 = "foo"
    
  /**
   * Doc nested object o01 of ClassD2
   */
  object o01 extends ClassD2

  /**
   * Doc nested class D2D1
   */
  class ClassD2D1 {
    
  }
}

/**
 * Doc objectD1
 * @author david.bernard
 *
 */
object objectD1 {

  /**
   * Doc method m01 of objectD1
   * @param s parameter 1
   */
  def m01(z : ClassD2) = {
    println(z)
    println(z.o01)
    println(new z.ClassD2D1())
    println(z.m02("foo"))
  }
}

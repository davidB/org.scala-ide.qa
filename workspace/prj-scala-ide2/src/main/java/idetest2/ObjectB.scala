/**
 * 
 */
package idetest2

import idetest.ObjectA
/**
 * @author david.bernard
 *
 */
object ObjectB {
  def mB0() =  ObjectA.mA0()
  
  def main(args: Array[String]) {
	
    println(this.getClass)
  }
}
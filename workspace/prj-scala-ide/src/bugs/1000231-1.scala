package bugs
package bug1000231

//see http://www.assembla.com/spaces/scala-ide/tickets/1000231

trait T1

trait T11 extends T1

trait T2 {
  def noop = ()
}

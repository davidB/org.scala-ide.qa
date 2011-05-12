package bugs
package bug1000229

//see http://www.assembla.com/spaces/scala-ide/tickets/1000229
// TODO hello 
trait Foo {
  def calc(p: Int): String
}
class FooBar extends Foo { def calc(p : Int): String = "hello world" }

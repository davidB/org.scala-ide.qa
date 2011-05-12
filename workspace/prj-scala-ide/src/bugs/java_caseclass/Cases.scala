package bugs.java_caseclass

trait CaseTest

case class Case(id : Int, name : String) extends CaseTest
case class Case2(id : Int, name : AnyRef) extends CaseTest
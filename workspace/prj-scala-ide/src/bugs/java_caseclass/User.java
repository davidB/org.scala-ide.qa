package bugs.java_caseclass;

public class User {

	public Case c = new Case(12, "hi");
	public int i = c.id();
	public Case2 ct = new Case2(12, "hallo");
	public int i2 = ct.id();
	
}

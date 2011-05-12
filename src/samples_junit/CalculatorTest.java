package samples_junit;

import org.junit.*;
import static org.junit.Assert.*;

public class CalculatorTest {
	private Calculator calculator;

	@Test
	public void addition() {
		assertEquals(12, calculator.add(7, 5));
	}

	@Test
	public void subtraction() {
		assertEquals(9, calculator.substract(12, 3));
	}
	
	@Test(expected = Exception.class)  
	public void divisionWithException() {  
	    // divide by zero
	    calculator.divide(42, 0);  
	}
	
	@Ignore("Still under development")  
	@Test  
	public void multiplication() {  
	  assertEquals(15, calculator.multiply(3, 5));
	}
	
	@Before
	public void runBeforeEveryTest() {
		calculator = new Calculator();
	}

	@After
	public void runAfterEveryTest() {
		calculator.shutdown();
	}

	@BeforeClass
	public static void runBeforeClass() {
		// run for one time before all test cases
	}

	@AfterClass
	public static void runAfterClass() {
		// run for one time after all test cases
	}
}

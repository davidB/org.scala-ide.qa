package samples.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MyFirstTest {

  @Test
  public void thisPasses() throws Exception {
    assertEquals(2, 2);
  }

  @Test
  public void thisFails() throws Exception {
    assertTrue(false);
  }
}

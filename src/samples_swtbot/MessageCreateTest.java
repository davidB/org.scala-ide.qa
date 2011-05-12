package samples_swtbot;

import static org.junit.Assert.assertEquals;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SWTBotJunit4ClassRunner.class)
// To capture screenshot
public class MessageCreateTest {

  private SWTWorkbenchBot bot;

//  @Test
//  public void canCreateAMessage() throws Exception {
//    bot.menu("File").menu("Open Another Message View").click();
//  }

  @Before
  public void setup() {
    bot = new SWTWorkbenchBot();
    bot.viewByTitle("Welcome").close();
  }
}
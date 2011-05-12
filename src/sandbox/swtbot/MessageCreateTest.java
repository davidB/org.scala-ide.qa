package samples.swtbot;

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

  @Test
  public void canCreateAMessage() throws Exception {
    bot.menu("File").menu("Open Another Message View").click();
  }

  @Before
  public void setup() {
    bot = new SWTWorkbenchBot();
    bot.viewByTitle("Welcome").close();
  }

  @Test
  public void canCreateANewJavaProject() throws Exception {
    bot.menu("File").menu("New").menu("Project...").click();
    SWTBotShell shell = bot.shell("New Project");
    shell.activate();
    bot.tree().select("Scala Project");
    bot.button("Next >").click();
    bot.textWithLabel("Project name:").setText("MyFirstProject");
    bot.button("Finish").click();
  }
}
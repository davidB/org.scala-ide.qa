package demo;

import static org.junit.Assert.assertEquals;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

// !!!!! WIP !!!!!!!

@RunWith(SWTBotJunit4ClassRunner.class) // To capture screenshot
public class HelloworldTest {

  private SWTWorkbenchBot bot;

  @Before
  public void setup() {
    bot = new SWTWorkbenchBot();
    bot.viewByTitle("Welcome").close();
  }

  @Test
  public void canCreateANewHelloworldProject() throws Exception {
    bot.menu("File").menu("New").menu("Project...").click();
    SWTBotShell shell = bot.shell("New Project");
    shell.activate();
    bot.text().setText("Scala Project");//.typeText("Scala Project");//.pressShortcut(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0));
    assertEquals(1, bot.tree().selectionCount());
    bot.button("Next >").click();
    bot.textWithLabel("Project name:").setText("MyFirstProject");
    bot.button("Finish").click();
  }
}
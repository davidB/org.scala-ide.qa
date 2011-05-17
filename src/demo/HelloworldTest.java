package demo;

import static org.junit.Assert.assertEquals;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

// !!!!! WIP !!!!!!!

@RunWith(SWTBotJunit4ClassRunner.class) // To capture screenshot
public class HelloworldTest {

  private final SWTWorkbenchBot _bot = new SWTWorkbenchBot();
  private final String _projectName = "Helloworld";

  @Before
  public void setup() {
    try {
      _bot.viewByTitle("Welcome").close();
    } catch(WidgetNotFoundException exc) {
      //ignore
    }
  }

  @Test
  public void canCreateANewHelloworldProject() throws Exception {
	createHelloworldProject();
    deleteHelloworldProject();
  }

  private void createHelloworldProject() throws Exception {
    _bot.menu("File").menu("New").menu("Project...").click();
    SWTBotShell shell = _bot.shell("New Project");
    shell.activate();
    //bot.text().setText("Scala Project");//.typeText("Scala Project");//.pressShortcut(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0));
    //bot.tree().select("General").expandNode("General").select("Existing Projects into Workspace");
    _bot.tree().select("Scala Wizards").expandNode("Scala Wizards").select("Scala Project");
    assertEquals(1, _bot.tree().selectionCount());
    _bot.button("Next >").click();
    _bot.textWithLabel("Project name:").setText(_projectName);
    _bot.button("Finish").click();
  }
  
  private void deleteHelloworldProject() throws Exception {
    SWTBotShell shell = _bot.shell("Package Explorer");
    shell.activate();
    _bot.tree().select(_projectName);
    assertEquals(1, _bot.tree().selectionCount());
    //TODO call delete
  }
}
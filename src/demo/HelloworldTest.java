package demo;

import static org.junit.Assert.assertEquals;

import org.eclipse.core.runtime.Platform;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

// !!!!! WIP !!!!!!!

@RunWith(SWTBotJunit4ClassRunner.class)
// To capture screenshot
public class HelloworldTest {

  private final SWTWorkbenchBot _bot = new SWTWorkbenchBot();
  private final String _projectName = "Helloworld";

  @Before
  public void setup() throws Exception {
    // slow down tests
    // SWTBotPreferences.PLAYBACK_DELAY = 10;
    // set to the default speed
    SWTBotPreferences.PLAYBACK_DELAY = 0;
    // increase timeout to 10 seconds
    //SWTBotPreferences.TIMEOUT = 10000;
    // set to the default timeout of 5 seconds
    SWTBotPreferences.TIMEOUT = 5000;
    try {
      _bot.viewByTitle("Welcome").close();
      _bot.perspectiveById("org.scala-ide.sdt.core.perspective").activate();
      //closeDialog("Run Scala Setup Diagnostics?", "Never", false);
    } catch (WidgetNotFoundException exc) {
      // ignore
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
    // bot.text().setText("Scala Project");//.typeText("Scala Project");//.pressShortcut(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER,
    // 0));
    // bot.tree().select("General").expandNode("General").select("Existing Projects into Workspace");
    _bot.tree().select("Scala Wizards").expandNode("Scala Wizards")
        .select("Scala Project");
    assertEquals(1, _bot.tree().selectionCount());
    _bot.button("Next >").click();
    _bot.textWithLabel("Project name:").setText(_projectName);
    _bot.button("Finish").click();
    closeDialog("Open Associated Perspective?", "Yes", true);
    _bot.waitUntil(Conditions.shellCloses(shell));
  }

  private void closeDialog(String title, String button, Boolean toggleCheckBox0) throws Exception {
    try {
      SWTBotShell shell = _bot.shell(title);
      if (shell != null) {
        System.out.println("found :" + title);
        shell.activate();
        if (toggleCheckBox0) {
          _bot.checkBox(0).click();
        }
        _bot.button(button).click();
        _bot.waitUntil(Conditions.shellCloses(shell));
      }
//      Shell[] shell = _bot.getDisplay().getShells();
//
//      for (int i = 0; i < shell.length; i++) {
//        if (shell[i].getText().indexOf("Open Associated Perspective?") > -1) {
//          shell[i].activate();
//          _bot.button("Finish").click();
//        }
//      }
    } catch (Throwable r) {
      System.out.println("Fail::" + r.getMessage());
    }
  }
  
  private void deleteHelloworldProject() throws Exception {
    deleteProject(_projectName);
  }
  
  private void deleteProject(String projectName) throws Exception {
    SWTBotView shell = _bot.viewByTitle("Package Explorer");
    shell.show();
    //shell.setFocus();
    _bot.tree().select(projectName).contextMenu("Delete").click();
    //assertEquals(1, _bot.tree().selectionCount());
    //_bot.menu("Edit").menu("Delete").click();
    String version = (String) Platform.getBundle("org.eclipse.core.runtime").getHeaders().get("Bundle-Version");
    String confirmDialogName = "Delete Resources";
    //String confirmDialogName = "Confirm Project Delete";
    closeDialog(confirmDialogName, "OK", true);
  }
}
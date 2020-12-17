package com.herokuapp.theinternet.editortests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.EditorPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditorTest extends TestUtilities {

    @Test
    public void defaultEditorValueText() {
        log.info("starting deafultEditorVaule test");
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        welcomePageObject.openPage();
        sleep(3000);

        //scroll to the button
        welcomePageObject.scrollToTheBottom();
        sleep(3000);
        //Click on Widiwig link
        EditorPage editorPage = welcomePageObject.clickWisiswigLink();

        //get default editor text
        String editorText = editorPage.getEditorText();

        //Verifications
        Assert.assertTrue(editorText.equals("Your content goes here."),
                "Editor text is not as expected.It is :" + editorText);

    }
}

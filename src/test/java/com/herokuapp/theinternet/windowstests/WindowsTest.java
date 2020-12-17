package com.herokuapp.theinternet.windowstests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.NewWindowPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import com.herokuapp.theinternet.pages.WindowsPage;
import org.testng.annotations.Test;

public class WindowsTest extends TestUtilities {

    @Test
    public void newWindowTest(){
        log.info("Starting newWindowsTest");

        //open main page
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        welcomePageObject.openPage();

        //click on multiple window link
        WindowsPage windowsPage = welcomePageObject.clickMultipleWindowLink();

        //click "click here" to open a new window
        windowsPage.openNewWindow();

        //Find and switch to new window page
        NewWindowPage newWindowPage = windowsPage.switchToNewWindowPage();

        String pageSource = newWindowPage.getCurrentPageSource();



    }
}

package com.herokuapp.theinternet.loginPageTest;

import java.util.Map;

import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.herokuapp.theinternet.base.CsvDataProviders;
import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;

public class NegativeLoginTests extends TestUtilities {

    @Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
    public void negativeLogInTest(Map<String, String> testData) {
        // Data
        String no = testData.get("no");
        String username  = testData.get("username");
        String password = testData.get("password");
        String expectedErrorMessage = testData.get("expectedMessage");
        String description = testData.get("description");

        log.info("Starting negativeLogInTest #" + no + " for " + description);

        // open main page
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        // Click on Form Authentication link
        LoginPage loginPage = welcomePage.clickFormAutheticationLink();

        // execute negative login
        loginPage.negativeLogIn(username, password);

        // wait for error message
        loginPage.waitForErrorMessage();
        String message = loginPage.getErrorMessageText();

        // Verification
        Assert.assertTrue(message.contains(expectedErrorMessage), "Message doesn't contain expected text.");
    }
}
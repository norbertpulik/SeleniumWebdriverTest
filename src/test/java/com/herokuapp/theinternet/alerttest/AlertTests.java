package com.herokuapp.theinternet.alerttest;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptAlertsPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AlertTests extends TestUtilities {
    @Test
    public void jsAlertTest() {
        log.info("Starting js Alert test");

        SoftAssert softAssert = new SoftAssert();


        //open main page
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        welcomePageObject.openPage();

        //click on JS alert link
        JavaScriptAlertsPage alertsPage = welcomePageObject.clickJavaScriptAlertLink();

        //click on js alert button
        alertsPage.openJsAlert();

        //get alert text
        String alertMessage = alertsPage.getAlertText();

        //click ok button
        alertsPage.acceptAlert();

        //get result text
        String result = alertsPage.getResultText();

        //verification
        softAssert.assertTrue(alertMessage.equals("I am a JS Alert"),
                "Alert message is not expected. " +
                        "\nShould be 'I am a JS Alert', but it is '" + alertMessage + "'");

        // 2 - Result text is expected
        softAssert.assertTrue(result.equals("You successfuly clicked an alert"),
                "result is not expected. " +
                        "\nShould be 'You successfuly clicked an alert', but it is '" + result + "'");
        softAssert.assertAll();

    }

    @Test
    public void jsDismissTest() {
        log.info("Starting js dismiss test");
        SoftAssert softAssert = new SoftAssert();

        //open main page
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        welcomePageObject.openPage();

        //click on JS alert link
        JavaScriptAlertsPage alertsPage = welcomePageObject.clickJavaScriptAlertLink();

        //Click on js confirm
        alertsPage.openJsConfirm();

        //Get alert text
        String alertMessage = alertsPage.getAlertText();

        //Click cancel button
        alertsPage.dismissAlert();

        //Get result text
        String result = alertsPage.getResultText();

        softAssert.assertTrue(alertMessage.equals("I am a JS Confirm"),
                "Alert message is not expected. \nShould be 'I am a JS Confirm', but it is '" + alertMessage + "'");

        // 2 - Result text is expected
        softAssert.assertTrue(result.equals("You clicked: Cancel"),
                "result is not expected. \nShould be 'You clicked: Cancel', but it is '" + result + "'");
        softAssert.assertAll();
    }

    @Test
    public void jsPromptTest() {
        log.info("Starting js prompt test");
        SoftAssert softAssert = new SoftAssert();

        //open main page
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        welcomePageObject.openPage();

        //click on JS alert link
        JavaScriptAlertsPage alertsPage = welcomePageObject.clickJavaScriptAlertLink();

        //Click on ja prompt button
        alertsPage.openJsPrompt();

        //Get alert text
        String alertMessage = alertsPage.getAlertText();

        //Type text into alert
        alertsPage.typeTextIntoAlert("Hello alert, I am here");

        //Get result text
        String result = alertsPage.getResultText();

        softAssert.assertTrue(alertMessage.equals("I am a JS prompt"),
                "Alert message is not expected. \nShould be 'I am a JS prompt', but it is '" + alertMessage + "'");

        // 2 - Result text is expected
        softAssert.assertTrue(result.equals("You entered: Hello alert, I am here"),
                "result is not expected. \nShould be 'You entered: Hello Alert, its Dmitry here', but it is '" + result
                        + "'");
        softAssert.assertAll();
    }
}

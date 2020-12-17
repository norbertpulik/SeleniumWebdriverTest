package com.herokuapp.theinternet.loginPageTest;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTests extends TestUtilities {

    @Test
    public void logInTest() {
        log.info("Starting logIn test");
        // open main page
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();
        takeScreenshot("WelcomePage opened");


        log.info("Main page is opened.");

        // Click on Form Authentication link
        LoginPage loginPage = welcomePage.clickFormAutheticationLink();
        takeScreenshot("LoggingPage opened");

        //Add cookie
        Cookie ck = new Cookie("username", "tomsmith", "the-internet.herokuapp.com",
                "/", null);

        loginPage.setCookie(ck);

        //execute login
        SecureAreaPage secureAreaPage = loginPage.logIn("tomsmith", "SuperSecretPassword!");
        takeScreenshot("secure page opened");

        //get cookie
        String username = secureAreaPage.getCookie("username");
        log.info("Username cookie: " + username);

        String session = secureAreaPage.getCookie("rack.session");
        log.info("Session cookie: " + session);

        //New page url is expected
        Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());

        //logout button is visible
        Assert.assertTrue(secureAreaPage.isLogOutButtonVisible(), "Logout button is not visible");


        Assert.assertTrue(driver.findElement
                (By.xpath("//a[@class='button secondary radius']")).
                isDisplayed(), "logOutButton is not visible.");

        // Successful log in message
        String expectedSuccessMessage = "You logged into a secure area!";
        String actualSuccessMessage = secureAreaPage.getSuccedMessageText();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
                "actualSuccessMessage does not contain expectedSuccessMessage" +
                        "\nexpectedSuccessMessage: "
                        + expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);

    }
}
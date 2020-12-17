package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SecureAreaPage extends BasePageObject {
    private String pageUrl = "http://the-internet.herokuapp.com/secure";
    private By logOutButton = By.xpath("//a[@class='button secondary radius']");
    private By message = By.id("flash-messages");

    public SecureAreaPage(WebDriver driver, Logger log) {
        super(driver, log);
    }
    //get url variable from PageObject
    public String getPageUrl(){
        return pageUrl;
    }
    //verification if logout buttom is visible on the page
    public boolean isLogOutButtonVisible(){
        return find(logOutButton).isDisplayed();
    }
    //get text from succes massage
    public String getSuccedMessageText(){
        return find(message).getText();
    }
}

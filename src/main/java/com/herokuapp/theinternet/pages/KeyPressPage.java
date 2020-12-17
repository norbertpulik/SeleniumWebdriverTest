package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressPage extends BasePageObject {

    private String url = "http://the-internet.herokuapp.com/key_presses";
    private By body = By.xpath("//body");
    private By resultTextLocator = By.id("result");

    public KeyPressPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //Open Key Press Page with url

    public void openPage() {
        log.info("Opening key press page");
        openUrl(url);
        log.info("Page is opened");
    }

    //Press given key while on the site
    public void pressKey(Keys key) {
        log.info("Pressing :" + key.name());
        pressKey(body, key);
    }

    //Get result text
    public String getResultText() {
        String result = find(resultTextLocator).getText();
        log.info("Result text :" + result);
        return result;
    }


}

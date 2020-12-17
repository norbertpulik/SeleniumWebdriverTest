package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsPage extends BasePageObject {

    private By clickForJsButtonLocator = By.xpath("//div[@id='content']//ul//button[.='Click for JS Alert']");
    private By clickForJsConfirmButton = By.xpath("//div[@id='content']//ul//button[.='Click for JS Confirm']");
    private By clickForJsPromptButton = By.xpath("//div[@id='content']//ul//button[.='Click for JS Prompt']");
    private By resultTextLocator = By.id("result");

    public JavaScriptAlertsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //Clicking on Js Alert button to open the alert
    public void openJsAlert() {
        log.info("Clicking on JS Alert button to open the alert ");
        click(clickForJsButtonLocator);
    }
    //Clicking on Js Confirm button to open the alert

    public void openJsConfirm() {
        log.info("Clicking on Js Confirm button to open the alert");
        click(clickForJsConfirmButton);
    }

    //Clicking on Js Prompt button to open the alert

    public void openJsPrompt() {
        log.info("Clicking on Js Prompt button to open the alert ");
        click(clickForJsPromptButton);
    }

    //Switch to alert and get its message
    public String getAlertText() {
        Alert alert = switchToAlert();
        String alertText = alert.getText();
        log.info("Alert says:" + alertText);
        return alertText;
    }

    public void acceptAlert() {
        log.info("Switching to alert and pressing OK");
        Alert alert = switchToAlert();
        alert.accept();
    }

    //Switch to alert and click cancel
    public void dismissAlert() {
        log.info("Switching to allert and pressing cancel");
        Alert alert = switchToAlert();
        alert.dismiss();
    }

    //type text into alert and press ok

    public void typeTextIntoAlert(String text) {
        log.info("Typing text into alert and pressing ok");
        Alert alert = switchToAlert();
        alert.sendKeys(text);
        alert.accept();
    }
    //get result text
    public String getResultText(){
        String result = find(resultTextLocator).getText();
        log.info("Result text :" + result);
        return result;

    }


}



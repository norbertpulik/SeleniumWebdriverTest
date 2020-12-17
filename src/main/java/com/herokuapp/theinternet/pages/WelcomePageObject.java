package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject {

    private By formAutenticationLinkLocator = By.linkText("Form Authentication");
    private String pageUrl = "http://the-internet.herokuapp.com/";
    private By checkBoxesLinkLocator = By.xpath("//div[@id='content']/ul//a[@href='/checkboxes']");
    private By dropdownLinkLocator = By.linkText("Dropdown");
    private By JSLinklocator = By.linkText("JavaScript Alerts");
    private By multipleWindowLocator = By.linkText("Multiple Windows");
    private By clickWisiswigLinkLocator = By.linkText("WYSIWYG Editor");


    public WelcomePageObject(WebDriver driver, Logger log) {
        super(driver, log);
    }

    // open page with its url
    public void openPage() {
        log.info("Opening page:" + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened");
    }

    public LoginPage clickFormAutheticationLink() {
        log.info("Clicking Form Autentication link on Welcome Page");
        click(formAutenticationLinkLocator);
        return new LoginPage(driver, log);
    }

    public CheckboxesPage clickCheckBoxesLink() {
        log.info("Clicking checkboxes link on Welcome page");
        click(checkBoxesLinkLocator);
        return new CheckboxesPage(driver, log);
    }

    ;

    public DropdownPage clickDropdownLink() {
        log.info("Clicking o dropdown link on welcome page");
        click(dropdownLinkLocator);
        return new DropdownPage(driver, log);

    }

    public JavaScriptAlertsPage clickJavaScriptAlertLink() {
        log.info("Click on Js Alert link");
        click(JSLinklocator);
        return new JavaScriptAlertsPage(driver, log);
    }

    public WindowsPage clickMultipleWindowLink(){
        log.info("Click on Multiple window link");
        click(multipleWindowLocator);
        return new WindowsPage(driver, log);
    }

    public EditorPage clickWisiswigLink(){
        log.info("CLick on Wisiwig link");
        click(clickWisiswigLinkLocator);
        return new EditorPage(driver, log);
    }

    public void scrollToTheBottom(){
        log.info("scrolling to the bottom of the page");
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

}

package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDropPage extends BasePageObject {

    private String pageUrl = "http://the-internet.herokuapp.com/drag_and_drop";
    private By columnA = By.id("column-a");
    private By columnB = By.id("column-b");

    public DragAndDropPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    // open D and D site
    public void openPage() {
        log.info("opening page:" + pageUrl);
        openUrl(pageUrl);
        log.info("page is open");
    }

    public void dragAToB() {
        log.info("drag A to B");
        performDragAndDrop(columnA, columnB);
    }

    //Getting column A text
    public String getColumnAText() {
        String text = find(columnA).getText();
        log.info("column A text is :" + text);
        return text;
    }

    //Getting column B text
    public String getColumnBText() {
        String text = find(columnB).getText();
        log.info("column B text is :" + text);
        return text;

    }
}
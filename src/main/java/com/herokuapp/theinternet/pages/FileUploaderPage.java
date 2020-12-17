package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploaderPage extends BasePageObject {

    private String pageUrl = "http://the-internet.herokuapp.com/upload";
    private By choseFileLocator = By.id("file-upload");
    private By uploadButtonLocator = By.id("file-submit");
    private By uploadeFileLocator = By.id("uploaded-files");

    public FileUploaderPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //open File uploader page
    public void  openPage(){
        log.info("Opening page " + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened");
    }

    public void pushUploadButton(){
        log.info("Clicking on upload button");
        click(uploadButtonLocator);
    }

    public void selectFile(String fileName){
        log.info("Selecting file'" + fileName + "'from files folder");
        String filePath = System.getProperty("user.dir") + "/src/main/resources/files/" + fileName;
        type(filePath,choseFileLocator);
        log.info("File selected");
    }

    //get names of uploaded files
    public String getUploadedFileNames(){
        String names = find(uploadeFileLocator).getText();
        log.info("Uploaded files: " + names);
        return names;
    }
}

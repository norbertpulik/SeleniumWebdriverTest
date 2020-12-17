package com.herokuapp.theinternet.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestUtilities extends BaseTest {

    //Static sleep

    protected void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @DataProvider(name = "files")
    protected static Object[][] files() {
        return new Object[][]{
                {1, "index.html"},
                {2, "logo.png"},
                {3, "text.txt"},
        };

    }

    //Take screenshot

    protected void takeScreenshot(String fileName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + File.separator + "test-output" +
                File.separator + getTodaysDate() + File.separator + testSuiteName + File.separator +
                testMethodName + File.separator + getSystemTime() + " " + fileName + ".png";

        try {
            FileUtils.copyFile(scrFile, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //Todays date

    private static String getTodaysDate() {
        return (new SimpleDateFormat("yyMMdd").format(new Date()));
    }

    //Current time
    private String getSystemTime() {
        return (new SimpleDateFormat("HHmmssSS").format(new Date()));
    }

    protected List<LogEntry>getBrowserLogs(){
        LogEntries log = driver.manage().logs().get("browser");
        List<LogEntry> logList = log.getAll();
        return logList;
    }
}

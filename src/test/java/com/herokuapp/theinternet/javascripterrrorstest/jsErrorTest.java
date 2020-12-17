package com.herokuapp.theinternet.javascripterrrorstest;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JSErrorPage;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class jsErrorTest extends TestUtilities {

    @Test
    public void jsErrorTest() {
        log.info("Starting js error test");
        SoftAssert softAssert = new SoftAssert();

        //Open js error page
        JSErrorPage jsErrorPage = new JSErrorPage(driver, log);
        jsErrorPage.openPage();

        //Get logs
        List<LogEntry> logs = getBrowserLogs();

        //Verifieng there are no JS errors in console
        for (LogEntry logEntry : logs) {
            if (logEntry.getLevel().toString().equals("SEVERE")) {
                softAssert.fail("Severe errors: " + logEntry.getMessage());
            }

        }
        softAssert.assertAll();

    }
}

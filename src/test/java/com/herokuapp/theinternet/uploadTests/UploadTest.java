package com.herokuapp.theinternet.uploadTests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.FileUploaderPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadTest extends TestUtilities {
    @Test(dataProvider = "files" )
    public void fileUploadTest(int no, String fileName) {
        log.info("startiong fileUplodTest no #" + no + "for" + fileName);

        //open file uploader page
        FileUploaderPage fileUploaderPage = new FileUploaderPage(driver,log);
        fileUploaderPage.openPage();

        //Select file
        fileUploaderPage.selectFile(fileName);

        //Push upload button
        fileUploaderPage.pushUploadButton();

        //Get uploade files
        String fileNames = fileUploaderPage.getUploadedFileNames();

        //Verify selected file uploaded
        Assert.assertTrue(fileNames.contains(fileName), "Our file (" + fileName + ") " +
                "is not one of the uploaded (" + fileNames + ")");

    }

}


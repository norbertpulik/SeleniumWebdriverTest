package com.herokuapp.theinternet.keypresstests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.KeyPressPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyPressTest extends TestUtilities {
    @Test
    public void pressKeyTest() {

        //open KeyPressPage

        KeyPressPage keyPressPage = new KeyPressPage(driver, log);
        keyPressPage.openPage();

        //Push keyboard key
        keyPressPage.pressKey(Keys.ENTER);

        //get result text
        String result = keyPressPage.getResultText();

        //Verify result is as expected
        Assert.assertTrue(result.equals("You entered: ENTER"),"Result is not expected but is :" + result);
    }
}

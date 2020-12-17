package com.herokuapp.theinternet.dropdowntests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DropdownPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest extends TestUtilities {

    @Test
    public void optionTwoTest() {
        log.info("Starting optionTwoTest");

        //open main page
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        welcomePageObject.openPage();

        //click on the dropdown link
        DropdownPage dropdownPage = welcomePageObject.clickDropdownLink();
        //Select option two
        dropdownPage.selectOptionTwo(2);

        //verify option 2 is selected
        String selectedOption = dropdownPage.getSelectedOption();
        Assert.assertTrue(selectedOption.equals("Option 2"),
                "Option two is not selected.Instead selected -" + selectedOption);


    }
}

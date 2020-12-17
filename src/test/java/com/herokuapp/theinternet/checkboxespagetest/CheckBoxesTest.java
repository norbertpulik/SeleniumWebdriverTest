package com.herokuapp.theinternet.checkboxespagetest;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckboxesPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.annotations.Test;

public class CheckBoxesTest extends TestUtilities {

    @Test
    public void selectTwoCheckboxes(){
        log.info("Starting Select Two Checkboxes test");

        //open main paig
        WelcomePageObject welcomPage = new WelcomePageObject(driver, log);
        welcomPage.openPage();

        //click on checkboxes lin
        CheckboxesPage checkboxesPage = welcomPage.clickCheckBoxesLink();

        //Select all checkboxes
        checkboxesPage.selectAllCheckboxes();
        //Verify all checkboxes are checked
        checkboxesPage.areAllCheckboxesChecked();


    }
}

package com.herokuapp.theinternet.slidertests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HorizontalSliderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SliderTest extends TestUtilities {

    @Test
    public void sliderTest() {

        //open slider page
        HorizontalSliderPage horizontalsliderPage = new HorizontalSliderPage(driver, log);
        horizontalsliderPage.openPage();

        String value = "3.5";

        //Ser slider value
        horizontalsliderPage.setSliderTo(value);
        sleep(2000);

        //verify slider value
        String sliderValue = horizontalsliderPage.getSliderValue();
        Assert.assertTrue(sliderValue.equals(value), "Range is not correct=");

    }
}

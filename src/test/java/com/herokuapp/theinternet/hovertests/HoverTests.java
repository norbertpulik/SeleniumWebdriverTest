package com.herokuapp.theinternet.hovertests;
import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HoverPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverTests extends TestUtilities {
    @Test
    public void user2ProfileTest(){
        log.info("Starting user2Profile test");
        //open hover page

        HoverPage hoverPage = new HoverPage(driver,log);
        hoverPage.openPage();

        //Open user profile
        hoverPage.openUserProfile(2);

        //Verify correct user profile opened
        Assert.assertTrue(hoverPage.getCurrentUrl().contains("/users/2"),
                "Url of opened page is not expected User 1 page url");
    }
}

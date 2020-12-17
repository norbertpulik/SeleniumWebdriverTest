package com.herokuapp.theinternet.draganddroptests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DragAndDropPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTests extends TestUtilities {

    @Test
    public void dragAtoBTests(){
        log.info("starting drag A to B test");
        //open D & D site
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver,log);
        dragAndDropPage.openPage();

        //Drag A and drop on B
        dragAndDropPage.dragAToB();

        //Verify correst headers in correct boxes
        String columnAText = dragAndDropPage.getColumnAText();
        Assert.assertTrue(columnAText.equals("B"));

        String columnBText = dragAndDropPage.getColumnBText();
        Assert.assertTrue(columnBText.equals("A"));

    }
}


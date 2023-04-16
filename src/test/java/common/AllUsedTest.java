package common;

import base.BaseTest;
import constants.messages.AssertionMessages;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.common.HomePage;
import pages.common.ViewSchedulePage;

public class AllUsedTest extends BaseTest {

    @Test
    public void allUsedTest(){
        HomePage homePage = loginPage.successfulLogIn();
        ViewSchedulePage viewSchedulePage = homePage.clickViewSchedule();
        String buttonText = viewSchedulePage.printButtonName();
        Assert.assertEquals(buttonText, AssertionMessages.EXPECTED_BUTTON_TEXT);
    }
}

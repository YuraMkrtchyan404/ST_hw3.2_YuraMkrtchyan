package common;

import base.BaseTest;
import constants.messages.AssertionMessages;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.common.HomePage;
import pages.common.ViewSchedulePage;

public class ViewSchedulePageTest extends BaseTest {

    @Test
    public void testViewSwitch(){
        HomePage homePage = loginPage.successfulLogIn();
        ViewSchedulePage viewSchedulePage = homePage.clickViewSchedule();
        String text = viewSchedulePage.clickViewSwitch();
        Assert.assertEquals(text, AssertionMessages.SWITCH_TO_BASIC_VIEW);
    }
}
